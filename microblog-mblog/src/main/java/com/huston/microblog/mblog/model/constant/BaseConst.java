package com.huston.microblog.mblog.model.constant;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class BaseConst {
    public static final int MAX_PICTURE_COUNT = 9;
    public static final int MAX_VIDEO_COUNT = 1;

    public static final String REDIS_TIMELINE_PREFIX = "timeline:";
    public static final String REDIS_TIMELINE_TYPE_PREFIX = "timelineType:";
    public static final String REDIS_TIMELINE_USER_ID_PREFIX = "userId:";

    public static final int MAX_REDIS_TIMELINE_SIZE = 10_000;
}
