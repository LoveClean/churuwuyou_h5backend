package com.springboot.framework.controller;

import com.springboot.framework.annotation.ACS;
import com.springboot.framework.constant.Errors;
import com.springboot.framework.controller.request.VisitorInsert;
import com.springboot.framework.controller.request.VisitorUpdateBySession;
import com.springboot.framework.dao.pojo.Visitor;
import com.springboot.framework.dto.VisitorDTO;
import com.springboot.framework.service.VisitorService;
import com.springboot.framework.bo.ResponseBO;
import com.springboot.framework.util.ResponseUtil;
import com.springboot.framework.bo.UserBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(tags = {"访客操作接口"}, produces = "application/json")
@RestController
@RequestMapping("/visitor/")
public class VisitorController extends BaseController {
    @Resource
    private VisitorService visitorService;

    @ACS(allowAnonymous = true)
    @ApiOperation(value = "登陆", notes = "")
    @GetMapping(value = "login")
    public ResponseBO<UserBO> login(@RequestParam String wechatOpenid, HttpServletRequest request) {
        ResponseBO<Visitor> response = visitorService.selectByWechatOpenid(wechatOpenid);
        if (response.isSuccess()) {
            UserBO userBO = new UserBO(response.getData());
            return accessToken(userBO, request);
        }
        return ResponseUtil.fail("登陆失败");
    }

    @ACS(allowAnonymous = true)
    @ApiOperation(value = "新增", notes = "")
    @PostMapping(value = "insertSelective")
    public ResponseBO<Errors> insertSelective(@RequestBody VisitorInsert bean) {
        VisitorDTO recordDTO = new VisitorDTO(bean.getName(), bean.getSex(), bean.getPhoto(), bean.getPhone(),bean.getWechatOpenid());
        return visitorService.insertSelective(recordDTO);
    }

    @ApiOperation(value = "查看个人信息", notes = "查看个人信息")
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
    public ResponseBO<Errors> updateBySession(@RequestBody VisitorUpdateBySession bean, HttpServletRequest request) {
        VisitorDTO recordDTO = new VisitorDTO(super.getSessionUser(request).getId(), bean.getName(), bean.getSex(), bean.getPhoto(), bean.getPhone(), bean.getPassword());
        return visitorService.updateBySession(recordDTO);
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
}
