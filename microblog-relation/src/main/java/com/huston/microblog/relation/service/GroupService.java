package com.huston.microblog.relation.service;

import com.huston.microblog.common.model.exception.CustomException;
import com.huston.microblog.relation.model.dto.InsertGroupDTO;

/**
 * @author huxiantao-cn@foxmail.com
 */
public interface GroupService {

    void insertGroup(InsertGroupDTO insertGroupDTO) throws CustomException;

}
