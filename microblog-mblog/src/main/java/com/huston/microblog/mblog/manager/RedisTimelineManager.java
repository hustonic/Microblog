package com.huston.microblog.mblog.manager;


import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public interface RedisTimelineManager {

    boolean add(int timelineType, long userId, String feed, double score, long maxSize);

    List<String> range(int timelineType, long userId, long offset, long limit);

    Long getSize(int timelineType, long userId);

    boolean delete(int timelineType, long userId, String feed);

}
