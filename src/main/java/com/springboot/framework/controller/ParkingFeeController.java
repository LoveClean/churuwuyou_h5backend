package com.springboot.framework.controller;

import com.springboot.framework.constant.Errors;
import com.springboot.framework.controller.request.ParkingFeeUpdateByMoneySelective;
import com.springboot.framework.dto.ParkingFeeDTO;
import com.springboot.framework.service.ParkingFeeService;
import com.springboot.framework.bo.ResponseBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = {"停车费操作接口"}, produces = "application/json")
@RestController
@RequestMapping("/parkingFee/")
public class ParkingFeeController {
    @Resource
    private ParkingFeeService parkingFeeService;

    @ApiOperation(value = "访客进入园区", notes = "访客进入园区")
    @PostMapping(value = "insertSelective")
    public ResponseBO<Errors> insertSelective(@RequestParam Integer visitorApplyId) {
        ParkingFeeDTO recordDTO = new ParkingFeeDTO();
        recordDTO.setVisitorApplyId(visitorApplyId);
        return parkingFeeService.insertSelective(recordDTO);
    }

    @ApiOperation(value = "访客支付停车费", notes = "访客支付停车费")
    @PostMapping(value = "updateByMoneySelective")
    public ResponseBO<Errors> updateByMoneySelective(@RequestBody ParkingFeeUpdateByMoneySelective bean) {
        ParkingFeeDTO recordDTO = new ParkingFeeDTO();
        recordDTO.setVisitorApplyId(bean.getVisitorApplyId());
        recordDTO.setMoney(bean.getMoney());
        return parkingFeeService.updateByMoneySelective(recordDTO);
    }
}
