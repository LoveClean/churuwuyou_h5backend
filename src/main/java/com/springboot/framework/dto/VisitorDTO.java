package com.springboot.framework.dto;

import lombok.Data;

import java.util.Date;

@Data
public class VisitorDTO {
    private Integer id;
    private String name;
    private Byte sex;
    private String photo;
    private String phone;
    private String password;
    private String wechatOpenid;
    private Byte type;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private Byte status;

    public VisitorDTO() {
    }

    //新增
    public VisitorDTO(String name, Byte sex, String photo, String phone, String wechatOpenid) {
        this.name = name;
        this.sex = sex;
        this.photo = photo;
        this.phone = phone;
        this.wechatOpenid = wechatOpenid;
    }

    //更新
    public VisitorDTO(Integer id, String name, Byte sex, String photo, String phone, String password) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.photo = photo;
        this.phone = phone;
        this.password = password;
    }
}
