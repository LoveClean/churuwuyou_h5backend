package com.springboot.framework.controller.request;

import lombok.Data;

@Data
public class OwnerUpdateBySession {
    private String name;
    private Byte sex;
    private String photo;
    private String phone;
    private String password;
    private String buildingNum;
    private String houseNum;
}
