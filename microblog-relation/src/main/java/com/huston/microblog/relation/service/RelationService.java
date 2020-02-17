package com.huston.microblog.relation.service;

import com.huston.microblog.common.model.exception.CustomException;
import com.huston.microblog.relation.model.dto.RelationDTO;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public interface RelationService {

    RelationDTO insertRelation(Long userIdSub, Long userIdPub) throws CustomException;

    void deleteRelation(Long userId, Long relaId) throws CustomException;

    void updateRelation(Long userId, Long relaId, String relaRemark) throws CustomException;

    List<RelationDTO> listFollowRelation(Long userId, Long offset, Long limit);

    List<RelationDTO> listFansRelation(Long userId, Long offset, Long limit);

    Long countRelation(Long userIdSub, Long userIdPub);

    List<Long> listFansId(Long userId);

}
