package com.springboot.framework.controller.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ParkingFeeUpdateByMoneySelective {
    private Integer visitorApplyId;
    private Integer money;
}
