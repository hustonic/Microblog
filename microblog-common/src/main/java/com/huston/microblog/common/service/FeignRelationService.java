package com.huston.microblog.common.service;

import com.huston.microblog.common.model.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public interface FeignRelationService {

    @GetMapping("/fansIds")
    Result<List<Long>> listFansId(@RequestParam Long userId);

}
