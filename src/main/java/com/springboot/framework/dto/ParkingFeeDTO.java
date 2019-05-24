package com.springboot.framework.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ParkingFeeDTO {
    private Integer visitorApplyId;
    private Integer money;
    private Date createTime;
    private Date lastTime;
    private Byte status;
}
