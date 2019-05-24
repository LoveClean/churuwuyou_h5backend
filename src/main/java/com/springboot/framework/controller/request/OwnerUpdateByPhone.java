package com.springboot.framework.controller.request;

import lombok.Data;

@Data
public class OwnerUpdateByPhone {
    private String phone;
    private String wechatOpenid;
}
