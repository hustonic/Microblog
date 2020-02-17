package com.huston.microblog.verification.model.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Data
public class AddVerificationVO {

    @Range(min= 0, max=2, message = "认证类型不合法")
    @NotNull(message = "认证类型不能为空")
    private Byte verType;

    @Size(min=1, max=100, message = "认证描述为1-100个字符")
    @NotNull(message = "认证描述不能为空")
    private String verDesc;

    @Pattern(regexp= "^[\\u4E00-\\u9FA5a-zA-Z·]{1,30}$", message = "真实姓名只能包含中、英文和圆点‘·’，1-30个字符")
    @NotNull(message = "真实姓名不能为空")
    private String verRealName;

    @Pattern(regexp= "^[0-9X]{18}$", message = "身份证号为18位数字，最后一位可以为X")
    @NotNull(message = "身份证号不能为空")
    private String verIdentityCard;

    @Size(min = 1, max = 9, message = "认证材料为1-9张图片")
    @NotNull(message = "认证材料不能为空")
    private List<Long> resIds;
}
