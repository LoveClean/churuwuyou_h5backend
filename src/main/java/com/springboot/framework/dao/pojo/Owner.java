package com.springboot.framework.dao.pojo;

import com.springboot.framework.dto.OwnerDTO;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Data
public class Owner {
    @Id
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
    @Transient
    private String accessToken;

    public Owner() {

    }

    public Owner(OwnerDTO recordDTO) {
        this.id = recordDTO.getId();
        this.name = recordDTO.getName();
        this.sex = recordDTO.getSex();
        this.photo = recordDTO.getPhoto();
        this.phone = recordDTO.getPhone();
        this.password = recordDTO.getPassword();
        this.buildingNum = recordDTO.getBuildingNum();
        this.houseNum = recordDTO.getHouseNum();
        this.wechatOpenid = recordDTO.getWechatOpenid();
        this.createBy = recordDTO.getCreateBy();
        this.createDate = recordDTO.getCreateDate();
        this.updateBy = recordDTO.getUpdateBy();
        this.updateDate = recordDTO.getUpdateDate();
        this.status = recordDTO.getStatus();
    }
}