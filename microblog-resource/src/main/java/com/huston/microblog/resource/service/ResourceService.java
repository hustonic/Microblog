package com.huston.microblog.resource.service;

import com.huston.microblog.common.model.dto.ResourceDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public interface ResourceService {

    String getResURL(Long resId);

    ResourceDTO getResource(Long resId);

    List<ResourceDTO> listResource(List<Long> resIds);

    ResourceDTO insertResource(MultipartFile file, int resUsage, long userId);
}
