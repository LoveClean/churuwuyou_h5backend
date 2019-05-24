package com.springboot.framework.service;

import com.springboot.framework.constant.Errors;
import com.springboot.framework.dao.pojo.Owner;
import com.springboot.framework.dto.OwnerDTO;
import com.springboot.framework.bo.ResponseBO;

import java.util.List;

public interface OwnerService {
    ResponseBO<List<Owner>> selectList();

    ResponseBO<Owner> selectByWechatOpenid(String wechatOpenid);

    ResponseBO<Errors> updateBySession(OwnerDTO recordDTO);

    ResponseBO<Errors> updateByPhone(OwnerDTO recordDTO);
}
