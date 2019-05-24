package com.springboot.framework.dao.pojo;

import com.springboot.framework.dto.VisitorDTO;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Data
public class Visitor implements Serializable {
    @Id
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
    @Transient
    private String accessToken;

    public Visitor() {
    }

    public Visitor(VisitorDTO visitorDTO) {
        this.id = visitorDTO.getId();
        this.name = visitorDTO.getName();
        this.sex = visitorDTO.getSex();
        this.photo = visitorDTO.getPhoto();
        this.phone = visitorDTO.getPhone();
        this.password = visitorDTO.getPassword();
        this.wechatOpenid = visitorDTO.getWechatOpenid();
        this.type = visitorDTO.getType();
        this.createBy = visitorDTO.getCreateBy();
        this.createDate = visitorDTO.getCreateDate();
        this.updateBy = visitorDTO.getUpdateBy();
        this.updateDate = visitorDTO.getUpdateDate();
        this.status = visitorDTO.getStatus();
    }
}