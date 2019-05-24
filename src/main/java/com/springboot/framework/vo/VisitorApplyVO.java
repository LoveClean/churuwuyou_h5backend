package com.springboot.framework.vo;

import com.springboot.framework.dao.pojo.Visitor;
import com.springboot.framework.dao.pojo.VisitorApply;
import lombok.Data;

import java.util.Date;

@Data
public class VisitorApplyVO {
    private Integer id;
    private Integer visitorId;
    private Integer ownerId;
    private Date startTime;
    private Date expirationTime;
    private String carNum;
    private Date inTime;
    private Date outTime;
    private Byte status;

    private String name;
    private Byte sex;
    private String photo;
    private String phone;
    private String wechatOpenid;
    private Byte type;

    public VisitorApplyVO() {
    }

    public VisitorApplyVO(VisitorApply record, Visitor visitor) {
        this.id = record.getId();
        this.visitorId = record.getVisitorId();
        this.ownerId = record.getOwnerId();
        this.startTime = record.getStartTime();
        this.expirationTime = record.getExpirationTime();
        this.carNum = record.getCarNum();
        this.inTime = record.getInTime();
        this.outTime = record.getOutTime();
        this.status = record.getStatus();

        this.name = visitor.getName();
        this.sex = visitor.getSex();
        this.photo = visitor.getPhoto();
        this.phone = visitor.getPhone();
        this.wechatOpenid = visitor.getWechatOpenid();
        this.type = visitor.getType();
    }
}
