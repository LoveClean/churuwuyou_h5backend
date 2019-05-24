package com.springboot.framework.service;

import com.springboot.framework.constant.Errors;
import com.springboot.framework.dto.ParkingFeeDTO;
import com.springboot.framework.bo.ResponseBO;

public interface ParkingFeeService {
    ResponseBO<Errors> insertSelective(ParkingFeeDTO recordDTO);

    ResponseBO<Errors> updateByMoneySelective(ParkingFeeDTO recordDTO);
}
