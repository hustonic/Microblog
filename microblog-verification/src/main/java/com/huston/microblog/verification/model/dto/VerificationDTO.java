package com.huston.microblog.verification.model.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Data
public class VerificationDTO {
    private Long verId;

    private Byte verType;

    private String verDesc;

    private String verRealName;

    private String verIdentityCard;

    private Byte verState;

    private String verResDesc;

    private Date verTime;

    private Long userId;

    private List<Long> resIds;
}
