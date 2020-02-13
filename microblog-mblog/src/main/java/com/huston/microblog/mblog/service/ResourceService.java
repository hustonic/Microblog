package com.huston.microblog.mblog.service;

import com.huston.microblog.common.service.FeignResourceService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author huxiantao-cn@foxmail.com
 */
@FeignClient("microblog-resource")
public interface ResourceService extends FeignResourceService {
}
