package com.springboot.framework.service;

import com.springboot.framework.constant.Errors;
import com.springboot.framework.bo.PageResponseBO;
import com.springboot.framework.dto.VisitorApplyDTO;
import com.springboot.framework.bo.ResponseBO;

public interface VisitorApplyService {
    ResponseBO<Errors> insertSelective(VisitorApplyDTO recordDTO);

    PageResponseBO selectListByOwnerId(Integer pageNum, Integer pageSize, Integer ownerId);

    ResponseBO<Errors> updateByStatus(Integer id, Byte status);
}
