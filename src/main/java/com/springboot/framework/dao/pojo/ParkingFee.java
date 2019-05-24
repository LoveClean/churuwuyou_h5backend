package com.springboot.framework.dao.pojo;

import com.springboot.framework.dto.ParkingFeeDTO;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ParkingFee {
    @Id
    private Integer visitorApplyId;
    private Integer money;
    private Date createTime;
    private Date lastTime;
    private Byte status;

    public ParkingFee() {
    }

    public ParkingFee(ParkingFeeDTO recordDTO) {
        this.visitorApplyId = recordDTO.getVisitorApplyId();
        this.money = recordDTO.getMoney();
        this.createTime = recordDTO.getCreateTime();
        this.lastTime = recordDTO.getLastTime();
        this.status = recordDTO.getStatus();
    }
}