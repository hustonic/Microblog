package com.huston.microblog.mblog.manager.impl;

import com.huston.microblog.mblog.manager.RedisTimelineManager;
import com.huston.microblog.mblog.model.constant.BaseConst;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Service
public class RedisTimelineManagerImpl implements RedisTimelineManager {

    private StringRedisTemplate redisTemplate;

    public RedisTimelineManagerImpl(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean add(int timelineType, long userId, String feed, double score,  long maxSize) {
        String key = getKey(timelineType, userId);
        Boolean success;
        success = redisTemplate.opsForZSet().add(key, feed, score);
        if (success == null || !success) {
            return false;
        }

        //如果 Timeline 太大则删除后面的元素。
        Long size = redisTemplate.opsForZSet().size(key);
        if(size!=null && size > maxSize){
            //排名是按照score从小到大
            redisTemplate.opsForZSet().removeRange(key, 0, size - maxSize);
        }
        return true;
    }

    /**
     * @param offset >= 0，否则默认值0
     * @param limit > 0，否则默认值1
     */
    @Override
    public List<String> range(int timelineType, long userId, long offset, long limit) {
        if(offset<0)
            offset=0;
        if(limit <=0)
            limit=1;

        String key = getKey(timelineType, userId);
        Set<String> feed = redisTemplate.opsForZSet().reverseRange(key, offset, offset+limit-1);
        if(feed==null){
            return new ArrayList<>();
        }
        return new ArrayList<>(feed);
    }

    @Override
    public Long getSize(int timelineType, long userId){
        return redisTemplate.opsForZSet().size(getKey(timelineType, userId));
    }

    @Override
    public boolean delete(int timelineType, long userId, String feed){
        String key = getKey(timelineType, userId);
        Long removeCount = redisTemplate.opsForZSet().remove(key, feed);
        return removeCount!=null && removeCount==1;
    }

    @Override
    public String getKey(int timelineType, long userId){
        return BaseConst.REDIS_TIMELINE_PREFIX + BaseConst.REDIS_TIMELINE_TYPE_PREFIX + timelineType + ":" +
                BaseConst.REDIS_TIMELINE_USER_ID_PREFIX + userId;
    }
}
