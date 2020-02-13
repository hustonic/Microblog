package com.huston.microblog.auth.manager.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.huston.microblog.auth.manager.ValidationCodeManager;
import com.huston.microblog.auth.model.constant.ValidationCodeManagerConstant;
import com.huston.microblog.common.model.enums.ManagerExceptionErrorCodeEnum;
import com.huston.microblog.auth.model.enums.ValidationTypeEnum;
import com.huston.microblog.common.model.exception.ManagerException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Service
public class ValidationCodeManagerImpl implements ValidationCodeManager {

    private JavaMailSender javaMailSender;
    private StringRedisTemplate redisTemplate;
    private SecureRandom secureRandom = new SecureRandom();   //使用加密的强随机数生成器

    @Value("${spring.mail.username}")
    private String emailFrom;

    @Value("${aliyun.sms.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.sms.accessSecret}")
    private String accessSecret;
    @Value("${aliyun.sms.signName}")
    private String signName;
    @Value("${aliyun.sms.templateCode}")
    private String templateCode;

    public ValidationCodeManagerImpl(JavaMailSender javaMailSender, StringRedisTemplate redisTemplate) {
        this.javaMailSender = javaMailSender;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 发送验证码到指定手机号码，并保存
     *
     * @param phone          手机号码
     * @param validationType 验证类型/验证码的用途
     */
    @Override
    @Async
    public void sendValidationCodeToPhoneAndSave(String phone, ValidationTypeEnum validationType) throws ManagerException {
        String code = createCode();
        int expiration = ValidationCodeManagerConstant.VALIDATION_CODE_EXPIRATION;  //单位分钟
        //保存验证码
        saveCode(phone, code, validationType, expiration);

        //发送短信
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            if(response.getHttpStatus()!=200){
                throw new ManagerException(ManagerExceptionErrorCodeEnum.SEND_VALIDATION_CODE_TO_PHONE_FAILED.getErrorCode(),
                        "发送手机验证码失败"+ response.getData());
            }
        } catch (ClientException e) {
            throw new ManagerException(ManagerExceptionErrorCodeEnum.SEND_VALIDATION_CODE_TO_PHONE_FAILED.getErrorCode(),
                    "发送手机验证码失败", e);
        }
    }

    /**
     * 发送验证码到指定邮箱，并保存
     *
     * @param email          邮箱
     * @param validationType 验证类型/验证码的用途
     */
    @Override
    @Async
    public void sendValidationCodeToEmailAndSave(String email, ValidationTypeEnum validationType) throws ManagerException {
        String code = createCode();
        String typeDesc = validationType.getDescription();
        int expiration = ValidationCodeManagerConstant.VALIDATION_CODE_EXPIRATION;  //单位分钟

        //保存验证码
        saveCode(email, code, validationType, expiration);

        //发送邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(emailFrom);
        mailMessage.setTo(email);
        mailMessage.setSubject("【Microblog】验证码：" + code);
        mailMessage.setText("【Microblog】验证码：" + code + "。此验证码仅用于" + typeDesc + "，请勿转发他人，" + expiration + "分钟内有效。");

        try {
            javaMailSender.send(mailMessage);
        } catch (MailException e){
            throw new ManagerException(ManagerExceptionErrorCodeEnum.SEND_VALIDATION_CODE_TO_EMAIL_FAILED.getErrorCode(),
                    "发送邮箱验证码失败", e);
        }
    }

    /**
     * 验证用户提交的验证码和服务器生成的验证码是否相同，并且检查是否过期。
     *
     * @param receiver       手机号/邮箱
     * @param code           验证码
     * @param validationType 验证类型/验证码的用途
     * @return 若验证通过则返回true
     */
    @Override
    public boolean validate(String receiver, String code, ValidationTypeEnum validationType) {
        String key = getKey(receiver, validationType);
        String value = redisTemplate.opsForValue().get(key);
        return value != null && value.equals(code);
    }

    /**
     * 从Redis中删除验证码
     */
    @Override
    public void deleteCode(String receiver, ValidationTypeEnum validationType) {
        String key = getKey(receiver, validationType);
        redisTemplate.delete(key);
    }

    /**
     * 生成验证码
     */
    private String createCode() {
        int bitCount = ValidationCodeManagerConstant.VALIDATION_CODE_BIT_COUNT;  //生成验证码的位数
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bitCount; i++) {
            sb.append(secureRandom.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * 保存验证码到Redis，需要设置过期时间
     *
     * @param receiver 手机号/邮箱
     */
    private void saveCode(String receiver, String code, ValidationTypeEnum validationType, int expiration) {
        String key = getKey(receiver, validationType);
        redisTemplate.opsForValue().set(key, code, expiration, TimeUnit.MINUTES);
    }


    private String getKey(String receiver, ValidationTypeEnum validationType) {
        return ValidationCodeManagerConstant.VALIDATION_CODE_REDIS_KEY_PREFIX + "receiver:" + receiver + ":" +
                "validation_type:" + validationType.getType();
    }
}
