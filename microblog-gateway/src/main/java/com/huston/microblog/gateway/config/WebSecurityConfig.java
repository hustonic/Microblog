package com.huston.microblog.gateway.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author 胡献涛
 */
@Configuration
@EnableOAuth2Sso    //用于实现令牌中继
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                    .disable()
                .authorizeRequests()
                    .anyRequest().permitAll().and()    //全部放行，否则会要求重定向到登录页面
                .cors(Customizer.withDefaults());      //如果Spring MVC在类路径上并且没有提供CorsConfigurationSource，
                                                       // Spring Security将使用提供给Spring MVC的CORS配置
    }
}