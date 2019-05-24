package com.springboot.framework.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 廖师兄
 * 2017-07-30 11:43
 */
@Data
@ConfigurationProperties(prefix = "project-url")
@Component
public class ProjectUrlConfig {

    /**
     * 微信公众平台授权回调redirect_url  后端url
     */
    public String wechatMpAuthorizeUrl;

    public String ownerIndex;
    public String complain;
    public String repair;

    /**
     * 微信
     */
    public String webUrl;

}
