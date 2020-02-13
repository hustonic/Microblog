package com.huston.microblog.mblog.service;

import com.huston.microblog.common.model.exception.CustomException;
import com.huston.microblog.mblog.model.domain.AgreeMicroblog;
import com.huston.microblog.mblog.model.dto.ListAgreeMicroblogDTO;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public interface AgreeMicroblogService {

    void insertAgreeMicroblog(Long userId, Long mblogId) throws CustomException;

    void deleteAgreeMicroblog(Long userId, Long agreeId) throws CustomException;

    List<AgreeMicroblog> listAgreeMicroblog(ListAgreeMicroblogDTO listAgreeMicroblogDTO);

    Long count(Long mblogId);
}
