package com.huston.microblog.mblog.service;

import com.huston.microblog.common.service.FeignRelationService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author huxiantao-cn@foxmail.com
 */
@FeignClient("microblog-relation")
public interface RelationService extends FeignRelationService {
}
