package com.springboot.framework.dao.pojo;

import com.springboot.framework.dto.ComplainDTO;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class Complain {
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

    public Complain() {
    }

    public Complain(ComplainDTO recordDTO) {
        this.id = recordDTO.getId();
        this.ownerId = recordDTO.getOwnerId();
        this.title = recordDTO.getTitle();
        this.content = recordDTO.getContent();
        this.createBy = recordDTO.getCreateBy();
        this.createDate = recordDTO.getCreateDate();
        this.updateBy = recordDTO.getUpdateBy();
        this.updateDate = recordDTO.getUpdateDate();
        this.status = recordDTO.getStatus();
    }
}