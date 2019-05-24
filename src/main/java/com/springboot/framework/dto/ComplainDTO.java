package com.springboot.framework.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ComplainDTO {
    private Integer id;
    private Integer ownerId;
    private String title;
    private String content;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private Byte status;

    public ComplainDTO() {
    }

    //新增
    public ComplainDTO(Integer ownerId, String title, String content, String createBy) {
        this.ownerId = ownerId;
        this.title = title;
        this.content = content;
        this.createBy = createBy;
    }
}
