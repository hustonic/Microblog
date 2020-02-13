package com.huston.microblog.relation.service.impl;

import com.huston.microblog.common.model.exception.CustomException;
import com.huston.microblog.common.model.exception.InternalServerException;
import com.huston.microblog.relation.mapper.GroupMapper;
import com.huston.microblog.relation.model.domain.Group;
import com.huston.microblog.relation.model.dto.InsertGroupDTO;
import com.huston.microblog.relation.service.GroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    private GroupMapper groupMapper;

    public GroupServiceImpl(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }

    @Override
    public void insertGroup(InsertGroupDTO insertGroupDTO) throws CustomException {
        Group group = new Group();
        BeanUtils.copyProperties(insertGroupDTO,group);
        if(groupMapper.insertSelective(group)<=0){
            throw new InternalServerException("添加分组失败");
        }
    }
}
