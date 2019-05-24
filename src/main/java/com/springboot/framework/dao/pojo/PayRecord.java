package com.springboot.framework.dao.pojo;

import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class PayRecord {
    @Id
    private Integer id;
    private Integer parkingFeeId;
    private BigDecimal money;
    private String createBy;
    private Date createDate;
}