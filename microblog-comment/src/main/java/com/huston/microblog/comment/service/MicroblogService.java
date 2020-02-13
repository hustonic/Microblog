package com.huston.microblog.comment.service;

import com.huston.microblog.common.service.FeignMicroblogService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author huxiantao-cn@foxmail.com
 */
@FeignClient("microblog-mblog")
public interface MicroblogService extends FeignMicroblogService {
}
