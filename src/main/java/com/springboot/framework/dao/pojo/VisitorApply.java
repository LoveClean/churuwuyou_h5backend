package com.springboot.framework.dao.pojo;

import com.springboot.framework.dto.VisitorApplyDTO;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class VisitorApply {
    @Id
    private Integer id;
    private Integer visitorId;
    private Integer ownerId;
    private Date startTime;
    private Date expirationTime;
    private String carNum;
    private Date inTime;
    private Date outTime;
    private Byte status;

    public VisitorApply() {
    }

    public VisitorApply(VisitorApplyDTO recordDTO) {
        this.id = recordDTO.getId();
        this.visitorId = recordDTO.getVisitorId();
        this.ownerId = recordDTO.getOwnerId();
        this.startTime = recordDTO.getStartTime();
        this.expirationTime = recordDTO.getExpirationTime();
        this.carNum = recordDTO.getCarNum();
        this.inTime = recordDTO.getInTime();
        this.outTime = recordDTO.getOutTime();
        this.status = recordDTO.getStatus();
    }
}