package com.huston.microblog.mblog.service;

import com.huston.microblog.common.model.exception.CustomException;
import com.huston.microblog.mblog.model.domain.Collect;
import com.huston.microblog.mblog.model.dto.ListCollectDTO;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public interface CollectService {
    void insertCollect(Long userId, Long mblogId) throws CustomException;

    void deleteCollect(Long userId, Long collectId) throws CustomException;

    List<Collect> listCollect(ListCollectDTO listCollectDTO);

    Collect getCollect(Long userId, Long mblogId);
}
