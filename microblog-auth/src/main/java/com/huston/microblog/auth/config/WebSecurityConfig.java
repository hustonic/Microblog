package com.huston.microblog.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;

/**
 * @author 胡献涛
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private KeyPair keyPair;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/users**","/validation-codes","/passwords" ,"/error**").permitAll()
                                .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2ResourceServer ->   //配置资源服务器验证Token的方式，这里使用JWT验证方式
                        oauth2ResourceServer
                                .jwt()
                                .decoder(jwtDecoder())
                );
    }

    @Bean
    public JwtDecoder jwtDecoder() {     //因为此资源服务器与授权服务器在同一台主机，所以直接从本地获取公钥来解码JWT
        return NimbusJwtDecoder.withPublicKey((RSAPublicKey) this.keyPair.getPublic()).build();
    }

    //用于AuthorizationServerConfig配置类
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}