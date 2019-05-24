package com.springboot.framework.service.impl;

import com.springboot.framework.constant.Errors;
import com.springboot.framework.dao.pojo.ParkingFee;
import com.springboot.framework.dao.mapper.ParkingFeeMapper;
import com.springboot.framework.dto.ParkingFeeDTO;
import com.springboot.framework.service.ParkingFeeService;
import com.springboot.framework.bo.ResponseBO;
import com.springboot.framework.util.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ParkingFeeServiceImpl implements ParkingFeeService {
    @Resource
    private ParkingFeeMapper parkingFeeMapper;

    @Override
    public ResponseBO<Errors> insertSelective(ParkingFeeDTO recordDTO) {
        //1.请求校验
//        Errors errors = validRequest(recordDTO, "insertSelective");
//        if (errors.code != 0) {
//            return ResponseUtil.fail(errors);
//        }
        //2.创建entity
        ParkingFee record = new ParkingFee(recordDTO);
        //3.响应校验
        if (parkingFeeMapper.insertSelective(record) == 0) {
            return ResponseUtil.fail("添加失败");
        }
        return ResponseUtil.success(Errors.SUCCESS);
    }

    @Override
    public ResponseBO<Errors> updateByMoneySelective(ParkingFeeDTO recordDTO) {
        //2.创建entity
        ParkingFee record = new ParkingFee(recordDTO);

        //计算当前事件与最后一次缴费时间相差多少分钟数
        Long tempTime = (System.currentTimeMillis() - parkingFeeMapper.selectByPrimaryKey(recordDTO.getVisitorApplyId()).getLastTime().getTime()) / (1000 * 60);
        System.out.println(tempTime);

        //3.响应校验
        if (parkingFeeMapper.updateByMoneySelective(record.getVisitorApplyId(), record.getMoney()) == 0) {
            return ResponseUtil.fail("更新失败");
        }
        return ResponseUtil.success(Errors.SUCCESS);
    }
}
