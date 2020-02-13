package com.huston.microblog.mblog.manager;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public interface MicroblogTimelineManager {

    void pushAsync(long userId, long mblogId, long timestamp);

    List<Long> get(int timelineType, long userId, long offset, long limit);

    Long getSize(int timelineType, long userId);

    boolean delete(int timelineType, long userId, long mblogId);
}
