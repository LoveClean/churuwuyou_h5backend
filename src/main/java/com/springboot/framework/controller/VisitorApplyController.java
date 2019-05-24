package com.springboot.framework.controller;

import com.springboot.framework.constant.Errors;
import com.springboot.framework.controller.request.UpdateByStatus;
import com.springboot.framework.controller.request.VisitorApplyInsert;
import com.springboot.framework.bo.PageResponseBO;
import com.springboot.framework.dto.VisitorApplyDTO;
import com.springboot.framework.service.VisitorApplyService;
import com.springboot.framework.bo.ResponseBO;
import com.springboot.framework.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(tags = {"访客预约操作接口"}, produces = "application/json")
@RestController
@RequestMapping("/visitorApply/")
public class VisitorApplyController {
    @Resource
    private VisitorApplyService visitorApplyService;

    @ApiOperation(value = "新增", notes = "")
    @PostMapping(value = "insertSelective")
    public ResponseBO<Errors> insertSelective(@RequestBody VisitorApplyInsert bean) {
        VisitorApplyDTO recordDTO = new VisitorApplyDTO(bean.getVisitorId(), bean.getOwnerId(), DateUtil.stringToDate(bean.getStartTime().replace('/', '-'),DateUtil.DEFAULT_PATTERN) , DateUtil.stringToDate(bean.getExpirationTime().replace('/', '-'),DateUtil.DEFAULT_PATTERN), bean.getCarNum());
        return visitorApplyService.insertSelective(recordDTO);
    }

    @ApiOperation(value = "根据业主id查看列表", notes = "")
    @GetMapping(value = "selectListByOwnerId")
    public PageResponseBO selectListByOwnerId(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam Integer ownerId) {
        return visitorApplyService.selectListByOwnerId(pageNum, pageSize, ownerId);
    }

    @ApiOperation(value = "更新访客预约状态", notes = "")
    @PutMapping(value = "updateByStatus")
    public ResponseBO<Errors> updateByStatus(@RequestBody UpdateByStatus bean, HttpServletRequest request) {
        return visitorApplyService.updateByStatus(bean.getId(), bean.getStatus());
    }
}
