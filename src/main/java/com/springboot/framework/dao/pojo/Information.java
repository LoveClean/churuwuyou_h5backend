package com.springboot.framework.dao.pojo;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class Information {
    @Id
    private Integer id;
    private Integer ownerId;
    private String title;
    private String content;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private Byte status;
}