package com.springboot.framework.service.impl;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.springboot.framework.constant.Errors;
import com.springboot.framework.bo.PageResponseBO;
import com.springboot.framework.dao.pojo.VisitorApply;
import com.springboot.framework.dao.mapper.VisitorApplyMapper;
import com.springboot.framework.dao.mapper.VisitorMapper;
import com.springboot.framework.dto.VisitorApplyDTO;
import com.springboot.framework.service.VisitorApplyService;
import com.springboot.framework.util.PageUtil;
import com.springboot.framework.bo.ResponseBO;
import com.springboot.framework.util.ResponseUtil;
import com.springboot.framework.vo.VisitorApplyVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VisitorApplyServiceImpl implements VisitorApplyService {
    @Resource
    private VisitorApplyMapper visitorApplyMapper;
    @Resource
    private VisitorMapper visitorMapper;

    @Override
    public ResponseBO<Errors> insertSelective(VisitorApplyDTO recordDTO) {
        //1.请求校验
//        Errors errors = validRequest(recordDTO, "insertSelective");
//        if (errors.code != 0) {
//            return ResponseUtil.fail(errors);
//        }
        //2.创建entity
        VisitorApply record = new VisitorApply(recordDTO);
        //3.响应校验
        if (visitorApplyMapper.insertSelective(record) == 0) {
            return ResponseUtil.fail("添加失败");
        }
        return ResponseUtil.success(Errors.SUCCESS);
    }

    @Override
    public PageResponseBO selectListByOwnerId(Integer pageNum, Integer pageSize, Integer ownerId) {
        PageHelper.startPage(pageNum, pageSize);
        VisitorApply t = new VisitorApply();
        t.setOwnerId(ownerId);
        List<VisitorApply> visitorApplyList = visitorApplyMapper.select(t);
        List<VisitorApplyVO> visitorApplyVOList = Lists.newArrayList();
        for (VisitorApply visitorApply : visitorApplyList) {
            int status = visitorApply.getStatus();
            if (status == 0 || status == 1) {
                VisitorApplyVO visitorApplyVO = new VisitorApplyVO(visitorApply, visitorMapper.selectByPrimaryKey(visitorApply.getVisitorId()));
                visitorApplyVOList.add(visitorApplyVO);
            }
        }
        return PageUtil.page(visitorApplyList, visitorApplyVOList);
    }

    @Override
    public ResponseBO<Errors> updateByStatus(Integer id, Byte status) {
        //2.创建entity
        VisitorApply record = new VisitorApply();
        record.setId(id);
        record.setStatus(status);
        //3.响应校验
        if (visitorApplyMapper.updateByPrimaryKeySelective(record) == 0) {
            return ResponseUtil.fail("更新失败");
        }
        return ResponseUtil.success(Errors.SUCCESS);
    }
}
