package com.huston.microblog.mblog.manager.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huston.microblog.common.model.vo.Result;
import com.huston.microblog.mblog.manager.MicroblogTimelineManager;
import com.huston.microblog.mblog.manager.RedisTimelineManager;
import com.huston.microblog.mblog.model.constant.BaseConst;
import com.huston.microblog.mblog.model.enums.TimelineTypeEnum;
import com.huston.microblog.mblog.service.RelationService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Service
public class MicroblogTimelineManagerImpl implements MicroblogTimelineManager {

    private RedisTimelineManager redisTimelineManager;
    private RelationService relationService;
    private ObjectMapper objectMapper;

    public MicroblogTimelineManagerImpl(RedisTimelineManager redisTimelineManager, RelationService relationService, ObjectMapper objectMapper) {
        this.redisTimelineManager = redisTimelineManager;
        this.relationService = relationService;
        this.objectMapper = objectMapper;
    }

    /**
     * 查询粉丝列表，推送到自己主页的Timeline和所有粉丝的关注的人Timeline。
     * 个人主页Timeline不限制大小。
     * 关注的人的微博Timeline限制大小。
     * 这里粉丝数可能会很多，因此异步执行提高响应速度。
     */
    @Override
    @Async
    public void pushAsync(long userId, long mblogId, long timestamp) {
        //TODO 通过消息队列确保操作成功
        Result<List<Long>> result = relationService.listFansId(userId);
        if(!result.isSuccess()){
            return;
        }
        List<Long> fansIds = objectMapper.convertValue(result.getData(), new TypeReference<List<Long>>() {});
        String feed=String.valueOf(mblogId);
        //推送到个人主页Timeline
        redisTimelineManager.add(TimelineTypeEnum.MICROBLOG_ME.getCode(), userId,
                feed, timestamp, Long.MAX_VALUE);
        //推送到所有粉丝的Timeline
        fansIds.forEach(fansId->redisTimelineManager.add(TimelineTypeEnum.MICROBLOG_FOLLOW.getCode(), fansId,
                feed, timestamp, BaseConst.MAX_REDIS_TIMELINE_SIZE));
    }


    /**
     * 从指定类型的Feed流中获取mblogId
     * @param offset >= 0
     * @param limit > 0
     */
    @Override
    public List<Long> get(int timelineType, long userId, long offset, long limit) {
        List<String> feeds = redisTimelineManager.range(timelineType, userId, offset, limit);
        List<Long> mblogIds=new ArrayList<>();
        for (String feed : feeds) {
            mblogIds.add(Long.parseLong(feed));
        }
        return mblogIds;
    }

    @Override
    public Long getSize(int timelineType, long userId){
        return redisTimelineManager.getSize(timelineType, userId);
    }

    @Override
    public boolean delete(int timelineType, long userId, long mblogId) {
        return redisTimelineManager.delete(timelineType, userId, String.valueOf(mblogId));
    }
}
