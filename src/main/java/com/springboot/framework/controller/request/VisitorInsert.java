package com.springboot.framework.controller.request;

import lombok.Data;

@Data
public class VisitorInsert {
    private String name;
    private Byte sex;
    private String photo;
    private String phone;
    private String wechatOpenid;
}
