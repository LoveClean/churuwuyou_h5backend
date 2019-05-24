package com.springboot.framework.dao.pojo;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class Car {
    @Id
    private Integer id;
    private Integer ownerId;
    private Integer visitorId;
    private Integer carNum;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private Byte status;
}