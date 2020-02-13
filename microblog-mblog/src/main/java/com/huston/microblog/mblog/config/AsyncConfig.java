package com.huston.microblog.mblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutorService;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Configuration
public class AsyncConfig extends AsyncConfigurerSupport {

    //为了在@Async异步任务中传播安全上下文
    @Override
    public Executor getAsyncExecutor() {
        return new DelegatingSecurityContextExecutorService(Executors.newFixedThreadPool(5));
    }
}
