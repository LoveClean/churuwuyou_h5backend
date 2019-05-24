package com.springboot.framework.service;

import com.springboot.framework.constant.Errors;
import com.springboot.framework.dao.pojo.Visitor;
import com.springboot.framework.dto.VisitorDTO;
import com.springboot.framework.bo.ResponseBO;

public interface VisitorService {
    ResponseBO<Errors> insertSelective(VisitorDTO recordDTO);

    ResponseBO<Visitor> selectByWechatOpenid(String wechatOpenid);

    ResponseBO<Errors> updateBySession(VisitorDTO recordDTO);
}
