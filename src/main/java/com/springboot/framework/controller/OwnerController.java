package com.springboot.framework.controller;

import com.springboot.framework.annotation.ACS;
import com.springboot.framework.constant.Errors;
import com.springboot.framework.controller.request.OwnerUpdateByPhone;
import com.springboot.framework.controller.request.OwnerUpdateBySession;
import com.springboot.framework.dao.pojo.Owner;
import com.springboot.framework.dto.OwnerDTO;
import com.springboot.framework.service.OwnerService;
import com.springboot.framework.bo.ResponseBO;
import com.springboot.framework.util.ResponseUtil;
import com.springboot.framework.bo.UserBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(tags = {"业主操作接口"}, produces = "application/json")
@RestController
@RequestMapping("/owner/")
public class OwnerController extends BaseController {
    @Resource
    private OwnerService ownerService;

    @ACS(allowAnonymous = true)
    @ApiOperation(value = "登陆", notes = "")
    @GetMapping(value = "login")
    public ResponseBO<UserBO> login(@RequestParam String wechatOpenid, HttpServletRequest request) {
        ResponseBO<Owner> response = ownerService.selectByWechatOpenid(wechatOpenid);
        if (response.isSuccess()) {
            UserBO userBO = new UserBO(response.getData());
            return accessToken(userBO, request);
        }
        return ResponseUtil.fail("登陆失败");
    }

    @ApiOperation(value = "查看列表", notes = "")
    @GetMapping(value = "selectList")
    public ResponseBO<List<Owner>> selectList() {
        return ownerService.selectList();
    }

    @ApiOperation(value = "查看个人信息", notes = "")
    @GetMapping(value = "selectBySession")
    public ResponseBO<UserBO> selectBySession(HttpServletRequest request) {
        UserBO admin = super.getSessionUser(request);
        if (admin != null) {
            return ResponseUtil.success(admin);
        }
        return ResponseUtil.fail("用户未登录，无法获取当前用户信息");
    }

    @ApiOperation(value = "更新个人信息", notes = "")
    @PutMapping(value = "updateBySession")
    public ResponseBO<Errors> updateBySession(@RequestBody OwnerUpdateBySession bean, HttpServletRequest request) {
        OwnerDTO recordDTO = new OwnerDTO(super.getSessionUser(request).getId(), bean.getName(), bean.getSex(), bean.getPhoto(), bean.getPhone(), bean.getPassword(), bean.getBuildingNum(), bean.getHouseNum());
        return ownerService.updateBySession(recordDTO);
    }

    @ACS(allowAnonymous = true)
    @ApiOperation(value = "业主绑定", notes = "")
    @PutMapping(value = "updateByPhone")
    public ResponseBO<Errors> updateByPhone(@RequestBody OwnerUpdateByPhone bean) {
        OwnerDTO recordDTO = new OwnerDTO();
        recordDTO.setPhone(bean.getPhone());
        recordDTO.setWechatOpenid(bean.getWechatOpenid());
        return ownerService.updateByPhone(recordDTO);
    }

    private ResponseBO<UserBO> accessToken(UserBO userBO, HttpServletRequest request) {
        //session.setAttribute(Const.CURRENT_USER, response.getData());
        // 创建访问token
        String accessToken = super.generateAccessToken(request);
        userBO.setAccessToken(accessToken);
        super.setAccessTokenAttribute(request, accessToken);
        super.setSessionUser(request, userBO);
        return ResponseUtil.success(userBO);
    }

//    @ACS(allowAnonymous = true)
    @ApiOperation(value = "根据房间号查看业主", notes = "")
    @GetMapping(value = "selectByHouseNum")
    public ResponseBO<Owner> selectByHouseNum(@RequestParam String buildingNum, @RequestParam String houseNum) {
        return ownerService.selectByHouseNum(buildingNum, houseNum);
    }
}
