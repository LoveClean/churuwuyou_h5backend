package com.springboot.framework.dto;

import lombok.Data;

import java.util.Date;

@Data
public class VisitorApplyDTO {
    private Integer id;
    private Integer visitorId;
    private Integer ownerId;
    private Date startTime;
    private Date expirationTime;
    private String carNum;
    private Date inTime;
    private Date outTime;
    private Byte status;

    //新增
    public VisitorApplyDTO(Integer visitorId, Integer ownerId, Date startTime, Date expirationTime, String carNum) {
        this.visitorId = visitorId;
        this.ownerId = ownerId;
        this.startTime = startTime;
        this.expirationTime = expirationTime;
        this.carNum = carNum;
    }
}
