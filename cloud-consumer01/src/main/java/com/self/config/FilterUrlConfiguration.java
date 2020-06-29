package com.self.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Classname FilterUrlConfiguration
 * @Description TODO
 * @Date 2020/6/29 3:49 下午
 * @Created by liuhao
 */

@Configuration
@ConfigurationProperties(prefix = "filter")
public class FilterUrlConfiguration {

    private List<String> url;


    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }
}
