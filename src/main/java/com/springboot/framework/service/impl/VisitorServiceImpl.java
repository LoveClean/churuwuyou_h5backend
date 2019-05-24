package com.springboot.framework.service.impl;

import com.springboot.framework.constant.Errors;
import com.springboot.framework.dao.pojo.Visitor;
import com.springboot.framework.dao.mapper.VisitorMapper;
import com.springboot.framework.dto.VisitorDTO;
import com.springboot.framework.service.VisitorService;
import com.springboot.framework.bo.ResponseBO;
import com.springboot.framework.util.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VisitorServiceImpl implements VisitorService {
    @Resource
    private VisitorMapper visitorMapper;

    @Override
    public ResponseBO<Errors> insertSelective(VisitorDTO recordDTO) {
        //1.请求校验
        Errors errors = validRequest(recordDTO, "insertSelective");
        if (errors.code != 0) {
            return ResponseUtil.fail(errors);
        }
        //2.创建entity
        Visitor record = new Visitor(recordDTO);
        //3.响应校验
        if (visitorMapper.insertSelective(record) == 0) {
            return ResponseUtil.fail("添加失败");
        }
        return ResponseUtil.success(Errors.SUCCESS);
    }

    @Override
    public ResponseBO<Visitor> selectByWechatOpenid(String wechatOpenid) {
        //1.请求校验
//        Errors errors = validRequest(recordDTO, "login");
//        if (errors.code != 0) {
//            return ResponseUtil.fail(errors);
//        }
        //2.创建entity
        Visitor record = new Visitor();
        record.setWechatOpenid(wechatOpenid);
        record = visitorMapper.selectOne(record);
        //3.响应校验
//        if (record == null) {
//            return ResponseUtil.fail(Errors.SYSTEM_BUSINESS_ERROR);
//        }
        return ResponseUtil.success(record);
    }

    @Override
    public ResponseBO<Errors> updateBySession(VisitorDTO recordDTO) {
        //2.创建entity
        Visitor record = new Visitor(recordDTO);
        //3.响应校验
        if (visitorMapper.updateByPrimaryKeySelective(record) == 0) {
            return ResponseUtil.fail("失败");
        }
        return ResponseUtil.success(Errors.SUCCESS);
    }

    private Errors validRequest(VisitorDTO recordDTO, String type) {
        Visitor validRequest = new Visitor();
        switch (type) {
            case "insertSelective":
                validRequest.setPhone(recordDTO.getPhone());
                validRequest = visitorMapper.selectOne(validRequest);
                if (validRequest != null) {
                    return Errors.USER_MOBILE_EXISTS;
                }
//                validRequest = adminMapper.selectByAccount(recordDTO.getAccount());
//                if (validRequest != null) {
//                    return Errors.USER_USERNAME_SAME;
//                }
                break;
//            case "login":
//                if (StringUtil.isEmpty(recordDTO.getLoginKey()) || StringUtil.isEmpty(recordDTO.getPassword())) {
//                    return Errors.SYSTEM_REQUEST_PARAM_ERROR;
//                }
//                break;
//            case "updateByPrimaryKeySelective":
//                validRequest = adminMapper.selectByPhone(recordDTO.getPhone());
//                if (validRequest != null && !validRequest.getId().equals(recordDTO.getId())) {
//                    return Errors.USER_MOBILE_EXISTS;
//                }
//                break;
            default:
                return Errors.SUCCESS;
        }
        return Errors.SUCCESS;
    }
}
