package com.springboot.framework.controller;

import com.springboot.framework.constant.Errors;
import com.springboot.framework.controller.request.PublicInsertComplain;
import com.springboot.framework.controller.request.PublicInsertRepair;
import com.springboot.framework.bo.PageResponseBO;
import com.springboot.framework.dto.ComplainDTO;
import com.springboot.framework.dto.RepairDTO;
import com.springboot.framework.service.PublicService;
import com.springboot.framework.bo.ResponseBO;
import com.springboot.framework.vo.ComplainVO;
import com.springboot.framework.vo.RepairVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(tags = {"通用操作接口"}, produces = "application/json")
@RestController
@RequestMapping("/public/")
public class PublicController extends BaseController {
    @Resource
    private PublicService publicService;

    @ApiOperation(value = "新增投诉", notes = "")
    @PostMapping(value = "insertComplain")
    public ResponseBO<Errors> insertComplain(@RequestBody PublicInsertComplain bean, HttpServletRequest request) {
        ComplainDTO recordDTO = new ComplainDTO(super.getSessionUser(request).getId(), bean.getTitle(), bean.getContent(), super.getSessionUser(request).getName());
        return publicService.insertComplain(recordDTO);
    }

    @ApiOperation(value = "新增报修", notes = "")
    @PostMapping(value = "insertRepair")
    public ResponseBO<Errors> insertRepair(@RequestBody PublicInsertRepair bean, HttpServletRequest request) {
        RepairDTO recordDTO = new RepairDTO(super.getSessionUser(request).getId(), bean.getTitle(), bean.getContent(), super.getSessionUser(request).getName());
        return publicService.insertRepair(recordDTO);
    }

    @ApiOperation(value = "查看投诉", notes = "")
    @GetMapping(value = "selectComplain")
    public ResponseBO<ComplainVO> selectComplain(@RequestParam Integer id) {
        return publicService.selectComplain(id);
    }

    @ApiOperation(value = "根据业主id查看投诉列表", notes = "")
    @GetMapping(value = "selectListComplainByOwnerId")
    public PageResponseBO selectListComplainByOwnerId(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam Integer ownerId) {
        return publicService.selectListComplainByOwnerId(pageNum, pageSize, ownerId);
    }

    @ApiOperation(value = "查看报修", notes = "")
    @GetMapping(value = "selectRepair")
    public ResponseBO<RepairVO> selectRepair(@RequestParam Integer id) {
        return publicService.selectRepair(id);
    }

    @ApiOperation(value = "根据业主id查看报修列表", notes = "")
    @GetMapping(value = "selectListRepairByOwnerId")
    public PageResponseBO selectListRepairByOwnerId(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam Integer ownerId) {
        return publicService.selectListRepairByOwnerId(pageNum, pageSize, ownerId);
    }
}
