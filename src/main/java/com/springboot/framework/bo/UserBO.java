package com.springboot.framework.bo;

import com.springboot.framework.dao.pojo.Owner;
import com.springboot.framework.dao.pojo.Visitor;
import lombok.Data;

@Data
public class UserBO {
    private Integer id;
    private String name;
    private Byte sex;
    private String photo;
    private String phone;
    private String wechatOpenid;
    private Byte status;
    private String accessToken;

    public UserBO() {
    }

    public UserBO(Owner record) {
        this.id = record.getId();
        this.name = record.getName();
        this.sex = record.getSex();
        this.photo = record.getPhoto();
        this.phone = record.getPhone();
        this.wechatOpenid = record.getWechatOpenid();
        this.status = record.getStatus();
        this.accessToken = record.getAccessToken();
    }

    public UserBO(Visitor record) {
        this.id = record.getId();
        this.name = record.getName();
        this.sex = record.getSex();
        this.photo = record.getPhoto();
        this.phone = record.getPhone();
        this.wechatOpenid = record.getWechatOpenid();
        this.status = record.getStatus();
        this.accessToken = record.getAccessToken();
    }
}
