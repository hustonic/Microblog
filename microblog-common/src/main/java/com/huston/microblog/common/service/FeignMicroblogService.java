package com.huston.microblog.common.service;

import com.huston.microblog.common.model.dto.MicroblogDTO;
import com.huston.microblog.common.model.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author huxiantao-cn@foxmail.com
 */
public interface FeignMicroblogService {

    @GetMapping("/microblogs/{mblogId}")
    public Result<MicroblogDTO> getMicroblog(@PathVariable("mblogId") Long mblogId);

}
