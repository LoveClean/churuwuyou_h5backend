package com.springboot.framework.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OwnerDTO {
    private Integer id;
    private String name;
    private Byte sex;
    private String photo;
    private String phone;
    private String password;
    private String buildingNum;
    private String houseNum;
    private String wechatOpenid;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private Byte status;

    public OwnerDTO() {
    }

    //更新
    public OwnerDTO(Integer id, String name, Byte sex, String photo, String phone, String password, String buildingNum, String houseNum) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.photo = photo;
        this.phone = phone;
        this.password = password;
        this.buildingNum = buildingNum;
        this.houseNum = houseNum;
    }
}
