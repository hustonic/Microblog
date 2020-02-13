package com.huston.microblog.common.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class FeignTokenRelayConfiguration implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        Jwt jwt =(Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        requestTemplate.header("Authorization","Bearer " + jwt.getTokenValue());
    }
}
