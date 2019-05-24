package com.springboot.framework.controller.request;

import lombok.Data;

import java.util.Date;

@Data
public class VisitorApplyInsert {
    private Integer visitorId;
    private Integer ownerId;
    private String startTime;
    private String expirationTime;
    private String carNum;
}
