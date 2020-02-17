package com.huston.microblog.verification.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 用于管理员审核修改认证信息的DTO
 * @author huxiantao-cn@foxmail.com
 */
@Data
public class VerifyDTO {
    private Long verId;

    @Size(min=1, max=100, message = "认证描述为1-100个字符")
    @NotNull(message = "认证描述不能为空")
    private String verDesc;

    @Range(min = 1, max = 2, message = "认证状态不合法")
    @NotNull(message = "认证状态不能为空")
    private Byte verState;

    @Size(max=255, message = "认证结果描述最多255个字符")
    private String verResDesc;
}
