package com.huston.microblog.resource.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author huxiantao-cn@foxmail.com
 */
@ConfigurationProperties("storage.file-system")
@Configuration
public class StorageProperties {

    private String location;
    private String host;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
