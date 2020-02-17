package com.huston.microblog.mblog;

import com.huston.microblog.mblog.manager.MicroblogTimelineManager;
import com.huston.microblog.mblog.manager.RedisTimelineManager;
import com.huston.microblog.mblog.mapper.MicroblogMapper;
import com.huston.microblog.mblog.model.constant.BaseConst;
import com.huston.microblog.mblog.model.domain.Microblog;
import com.huston.microblog.mblog.model.enums.TimelineTypeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@SpringBootTest
class MicroblogMblogApplicationTests {

    @Autowired
    private RedisTimelineManager redisTimelineManager;

    @Autowired
    private MicroblogTimelineManager microblogTimelineManager;

    @Autowired
    private MicroblogMapper microblogMapper;

    @Test
    void contextLoads() {

    }

    @Test
    void redisTest(){  //把用户个人主页的微博推送到 所有微博Timeline，要修改配置文件Redis和Mysql的IP地址
        long[] userIds={10000, 10017};
        for (long userId : userIds) {
            List<Long> mblogIds = microblogTimelineManager.get(TimelineTypeEnum.MICROBLOG_ME.getCode(), userId, 0, 30);
            for (Long mblogId : mblogIds) {
                Microblog microblog = microblogMapper.selectByPrimaryKey(mblogId).orElse(null);
                if(microblog==null){
                    System.out.println("mblogId微博不存在");

                }else{
                    if(!redisTimelineManager.add(TimelineTypeEnum.MICROBLOG_ALL.getCode(), BaseConst.USER_ID_MATCHING_ALL,
                            String.valueOf(mblogId), microblog.getMblogPubTime().getTime(), BaseConst.MAX_REDIS_TIMELINE_SIZE)){
                        System.out.println("发生错误");
                    }
                }
            }
        }
    }
}
