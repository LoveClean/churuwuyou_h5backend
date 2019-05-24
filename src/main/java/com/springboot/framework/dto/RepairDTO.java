package com.springboot.framework.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RepairDTO {
    private Integer id;
    private Integer ownerId;
    private String title;
    private String content;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private Byte status;

    public RepairDTO() {
    }

    //新增
    public RepairDTO(Integer ownerId, String title, String content, String createBy) {
        this.ownerId = ownerId;
        this.title = title;
        this.content = content;
        this.createBy = createBy;
    }
}
