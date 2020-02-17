package com.huston.microblog.verification.service;

import com.huston.microblog.common.model.exception.CustomException;
import com.huston.microblog.verification.model.dto.AddVerificationDTO;
import com.huston.microblog.verification.model.dto.VerificationDTO;
import com.huston.microblog.verification.model.dto.VerifyDTO;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public interface VerificationService {

    VerificationDTO addVerification(AddVerificationDTO addVerificationDTO) throws CustomException;

    VerificationDTO getVerification(Long userId);

    List<VerificationDTO> listVerifyingVerification(Long offset, Long limit);

    void verify(VerifyDTO verifyDTO) throws CustomException;

    void confirm(Long verId, Long userId) throws CustomException;

    void deleteVerification(Long verId, Long userId) throws CustomException;
}
