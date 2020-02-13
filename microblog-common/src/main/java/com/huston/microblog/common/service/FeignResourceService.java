package com.huston.microblog.common.service;

import com.huston.microblog.common.model.dto.ResourceDTO;
import com.huston.microblog.common.model.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public interface FeignResourceService {
    @GetMapping("/resources/{resId}")
    public Result<ResourceDTO> getResource(@PathVariable("resId") Long resId);

    @GetMapping("/resources/{resId}/url")
    Result<String> getResUrl(@PathVariable("resId") Long resId);

    @GetMapping("/resources")
    Result<List<ResourceDTO>> listResource(@RequestParam List<Long> resIds);
}
