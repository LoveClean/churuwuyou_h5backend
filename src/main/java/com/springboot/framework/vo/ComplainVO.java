package com.springboot.framework.vo;

import com.springboot.framework.dao.pojo.Complain;
import lombok.Data;

import java.util.Date;

@Data
public class ComplainVO {
    private Integer id;
    private Integer ownerId;
    private String title;
    private String content;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private Byte status;

    public ComplainVO() {
    }

    public ComplainVO(Complain record) {
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
