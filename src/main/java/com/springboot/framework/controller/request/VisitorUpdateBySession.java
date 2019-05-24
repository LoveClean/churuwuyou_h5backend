package com.springboot.framework.controller.request;

import lombok.Data;

@Data
public class VisitorUpdateBySession {
    private String name;
    private Byte sex;
    private String photo;
    private String phone;
    private String password;
}
