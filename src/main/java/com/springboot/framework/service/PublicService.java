package com.springboot.framework.service;

import com.springboot.framework.constant.Errors;
import com.springboot.framework.bo.PageResponseBO;
import com.springboot.framework.dto.ComplainDTO;
import com.springboot.framework.dto.RepairDTO;
import com.springboot.framework.bo.ResponseBO;
import com.springboot.framework.vo.ComplainVO;
import com.springboot.framework.vo.RepairVO;

public interface PublicService {
    ResponseBO<Errors> insertComplain(ComplainDTO recordDTO);

    ResponseBO<Errors> insertRepair(RepairDTO recordDTO);

    ResponseBO<ComplainVO> selectComplain(Integer id);

    PageResponseBO selectListComplainByOwnerId(Integer pageNum, Integer pageSize, Integer ownerId);

    ResponseBO<RepairVO> selectRepair(Integer id);

    PageResponseBO selectListRepairByOwnerId(Integer pageNum, Integer pageSize, Integer ownerId);
}
