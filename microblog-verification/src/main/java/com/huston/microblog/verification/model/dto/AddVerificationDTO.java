package com.huston.microblog.verification.model.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Data
public class AddVerificationDTO {
    private Byte verType;

    private String verDesc;

    private String verRealName;

    private String verIdentityCard;

    private Long userId;

    private List<Long> resIds;
}
