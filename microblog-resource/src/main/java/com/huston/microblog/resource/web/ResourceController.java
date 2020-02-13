package com.huston.microblog.resource.web;

import com.huston.microblog.common.model.constant.CommonConstant;
import com.huston.microblog.common.model.dto.ResourceDTO;
import com.huston.microblog.common.model.vo.Result;
import com.huston.microblog.common.service.FeignResourceService;
import com.huston.microblog.resource.service.ResourceService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
@RestController
public class ResourceController implements FeignResourceService {

    private ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @PostMapping("/upload")
    public Result<ResourceDTO> insertResource(@RequestParam("resUsage") Integer resUsage,
                                          @RequestParam("file") MultipartFile file,
                                          @AuthenticationPrincipal Jwt jwt){
        long userId=Long.parseLong(jwt.getClaim(CommonConstant.JWT_CLAIMS_USER_ID_NAME));
        ResourceDTO resourceDTO = resourceService.insertResource(file, resUsage, userId);
        return Result.success(resourceDTO);
    }

    @Override
    public Result<ResourceDTO> getResource(Long resId){
        ResourceDTO resource = resourceService.getResource(resId);
        return Result.success(resource);
    }

    @Override
    public Result<String> getResUrl(Long resId) {
        return Result.success(resourceService.getResURL(resId));
    }

    @Override
    public Result<List<ResourceDTO>> listResource(List<Long> resIds) {
        return Result.success(resourceService.listResource(resIds));
    }
}
