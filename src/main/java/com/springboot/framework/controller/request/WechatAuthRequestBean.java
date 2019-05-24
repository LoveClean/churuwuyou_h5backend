package com.springboot.framework.controller.request;

import lombok.Data;

/**
 * @Author SWF
 * @Date 2019/4/17 15:01
 **/
@Data
public class WechatAuthRequestBean {
    private String type;

    private String sid;
}
