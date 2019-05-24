package com.springboot.framework.vo;

import com.springboot.framework.dao.pojo.Repair;
import lombok.Data;

import java.util.Date;

@Data
public class RepairVO {
    private Integer id;
    private Integer ownerId;
    private String title;
    private String content;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private Byte status;

    public RepairVO() {
    }

    public RepairVO(Repair record) {
        this.id = record.getId();
        this.ownerId = record.getOwnerId();
        this.title = record.getTitle();
        this.content = record.getContent();
        this.createBy = record.getCreateBy();
        this.createDate = record.getCreateDate();
        this.updateBy = record.getUpdateBy();
        this.updateDate = record.getUpdateDate();
        this.status = record.getStatus();
    }
}
