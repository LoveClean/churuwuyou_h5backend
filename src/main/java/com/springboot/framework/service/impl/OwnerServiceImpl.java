package com.springboot.framework.service.impl;

import com.springboot.framework.constant.Errors;
import com.springboot.framework.dao.pojo.Owner;
import com.springboot.framework.dao.mapper.OwnerMapper;
import com.springboot.framework.dto.OwnerDTO;
import com.springboot.framework.service.OwnerService;
import com.springboot.framework.bo.ResponseBO;
import com.springboot.framework.util.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Resource
    private OwnerMapper ownerMapper;

    @Override
    public ResponseBO<List<Owner>> selectList() {
        Owner record = new Owner();
        record.setStatus((byte) 1);
        return ResponseUtil.success(ownerMapper.select(record));
    }

    @Override
    public ResponseBO<Owner> selectByWechatOpenid(String wechatOpenid) {
        //1.请求校验
//        Errors errors = validRequest(recordDTO, "login");
//        if (errors.code != 0) {
//            return ResponseUtil.fail(errors);
//        }
        //2.创建entity
        Owner record = new Owner();
        record.setWechatOpenid(wechatOpenid);
        record = ownerMapper.selectOne(record);
        //3.响应校验
//        if (record == null) {
//            return ResponseUtil.fail(Errors.SYSTEM_BUSINESS_ERROR);
//        }
        return ResponseUtil.success(record);
    }

    @Override
    public ResponseBO<Errors> updateBySession(OwnerDTO recordDTO) {
        //2.创建entity
        Owner record = new Owner(recordDTO);
        //3.响应校验
        if (ownerMapper.updateByPrimaryKeySelective(record) == 0) {
            return ResponseUtil.fail("失败");
        }
        return ResponseUtil.success(Errors.SUCCESS);
    }

    @Override
    public ResponseBO<Errors> updateByPhone(OwnerDTO recordDTO) {
        //2.创建entity
        Owner record = new Owner(recordDTO);
        //3.响应校验
        if (ownerMapper.updateByPhone(record.getPhone(),record.getWechatOpenid()) == 0) {
            return ResponseUtil.fail("失败");
        }
        return ResponseUtil.success(Errors.SUCCESS);
    }
}
