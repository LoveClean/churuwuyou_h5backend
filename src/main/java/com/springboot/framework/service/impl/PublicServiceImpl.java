package com.springboot.framework.service.impl;

import com.github.pagehelper.PageHelper;
import com.springboot.framework.constant.Errors;
import com.springboot.framework.bo.PageResponseBO;
import com.springboot.framework.dao.pojo.Complain;
import com.springboot.framework.dao.pojo.Repair;
import com.springboot.framework.dao.mapper.ComplainMapper;
import com.springboot.framework.dao.mapper.RepairMapper;
import com.springboot.framework.dto.ComplainDTO;
import com.springboot.framework.dto.RepairDTO;
import com.springboot.framework.service.PublicService;
import com.springboot.framework.util.PageUtil;
import com.springboot.framework.bo.ResponseBO;
import com.springboot.framework.util.ResponseUtil;
import com.springboot.framework.vo.ComplainVO;
import com.springboot.framework.vo.RepairVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PublicServiceImpl implements PublicService {
    @Resource
    private ComplainMapper complainMapper;
    @Resource
    private RepairMapper repairMapper;

    @Override
    public ResponseBO<Errors> insertComplain(ComplainDTO recordDTO) {
        //1.请求校验
//        Errors errors = validRequest(recordDTO, "insertSelective");
//        if (errors.code != 0) {
//            return ResponseUtil.fail(errors);
//        }
        //2.创建entity
        Complain record = new Complain(recordDTO);
        //3.响应校验
        if (complainMapper.insertSelective(record) == 0) {
            return ResponseUtil.fail("添加失败");
        }
        return ResponseUtil.success(Errors.SUCCESS);
    }

    @Override
    public ResponseBO<Errors> insertRepair(RepairDTO recordDTO) {
        //1.请求校验
//        Errors errors = validRequest(recordDTO, "insertSelective");
//        if (errors.code != 0) {
//            return ResponseUtil.fail(errors);
//        }
        //2.创建entity
        Repair record = new Repair(recordDTO);
        //3.响应校验
        if (repairMapper.insertSelective(record) == 0) {
            return ResponseUtil.fail("添加失败");
        }
        return ResponseUtil.success(Errors.SUCCESS);
    }

    @Override
    public ResponseBO<ComplainVO> selectComplain(Integer id) {
        //2.创建entity
        Complain record = complainMapper.selectByPrimaryKey(id);
        //3.响应校验
        if (record == null) {
            return ResponseUtil.fail("记录不存在");
        }
        ComplainVO recordVO = new ComplainVO(record);
        return ResponseUtil.success(recordVO);
    }

    @Override
    public PageResponseBO selectListComplainByOwnerId(Integer pageNum, Integer pageSize, Integer ownerId) {
        PageHelper.startPage(pageNum, pageSize);
        Complain t = new Complain();
        t.setOwnerId(ownerId);
        List<Complain> complainList = complainMapper.select(t);
        return PageUtil.page(complainList);
    }

    @Override
    public ResponseBO<RepairVO> selectRepair(Integer id) {
        //2.创建entity
        Repair record = repairMapper.selectByPrimaryKey(id);
        //3.响应校验
        if (record == null) {
            return ResponseUtil.fail("记录不存在");
        }
        RepairVO recordVO = new RepairVO(record);
        return ResponseUtil.success(recordVO);
    }

    @Override
    public PageResponseBO selectListRepairByOwnerId(Integer pageNum, Integer pageSize, Integer ownerId) {
        PageHelper.startPage(pageNum, pageSize);
        Repair t = new Repair();
        t.setOwnerId(ownerId);
        List<Repair> complainList = repairMapper.select(t);
        return PageUtil.page(complainList);
    }
}
