package com.huston.microblog.mblog.service;

import com.huston.microblog.common.model.exception.CustomException;
import com.huston.microblog.mblog.model.dto.InsertMicroblogDTO;
import com.huston.microblog.common.model.dto.MicroblogDTO;
import com.huston.microblog.mblog.model.dto.UpdateMicroblogDTO;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public interface MicroblogService {

    void insertMicroblog(InsertMicroblogDTO insertMicroblogDTO) throws CustomException;

    List<MicroblogDTO> listUserMicroblog(Long userId, long offset, long limit);

    List<MicroblogDTO> listFollowMicroblog(Long userId, long offset, long limit);

    MicroblogDTO getMicroblog(Long mblogId);

    void updateMicroblog(UpdateMicroblogDTO updateMicroblogDTO) throws CustomException;

    void deleteMicroblog(Long userId, Long mblogId) throws CustomException;

    Long countForward(Long mblogId);
}
