package com.springboot.framework.controller;

import com.alibaba.fastjson.JSON;
import com.springboot.framework.annotation.ACS;
import com.springboot.framework.config.ProjectUrlConfig;
import com.springboot.framework.config.WechatAccountConfig;
import com.springboot.framework.constant.Errors;
import com.springboot.framework.controller.request.WechatAuthRequestBean;
import com.springboot.framework.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.net.URLEncoder;

/**
 * @author swf
 * @date 2019/3/15 14:17
 **/
@Api(tags = {"微信测试API"}, produces = "application/json")
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Resource
    private WxMpService wxMpService;

    @Resource
    private ProjectUrlConfig projectUrlConfig;

//    @Autowired
//    private WeixinUtil weixinUtil;
//
//    @Autowired
//    private WeixinSign weixinSign;


    @ACS(allowAnonymous = true)
    @ApiOperation(value = "微信授权", notes = "授权完成后以及获取到openid后的跳转页面")
    @GetMapping("/authorize")
    public String authorize(@RequestParam("type") String type) {
        // 授权成功后跳转到的url，此时会携带code，state两个参数
        String url;
        switch (type) {
            case "ownerIndex":
                url = projectUrlConfig.getOwnerIndex();
                break;
            case "complain":
                url = projectUrlConfig.getComplain();
                break;
            case "repair":
                url = projectUrlConfig.getRepair();
                break;
            default:
                url = projectUrlConfig.getWechatMpAuthorizeUrl();
                break;
        }
        WechatAuthRequestBean bean = new WechatAuthRequestBean();
        String state = JSON.toJSONString(bean);
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_BASE, URLEncoder.encode(state));
        return "redirect:" + redirectUrl;
    }

    /**
     * 获取access token 以及 openid
     *
     * @param code
     * @return userInfo
     */
    @ACS(allowAnonymous = true)
    @ApiOperation(value = "微信授权回调页", notes = "微信授权回调页")
    @GetMapping("/getOpenId")
    @ResponseBody
    public String getOpenId(@RequestParam("code") String code) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】{}", e);
            throw new BusinessException(Errors.SYSTEM_DATA_ERROR, e.getError().getErrorMsg());
        }
        return wxMpOAuth2AccessToken.getOpenId();
    }


//    @ACS(allowAnonymous = true)
//    @ApiOperation(value = "获取微信jssdk配置",notes = "获取微信jssdk配置")
//    @GetMapping("/config")
//    @ResponseBody
//    public Map<String, String> getWeChatApiConfig(@RequestParam("url") String url) throws Exception {
//        //获取ticket
//        String jsapiTicket = weixinUtil.getWeiXinTicket();
//
//        Map<String, String> ret = weixinSign.sign(jsapiTicket, url);
//
//        ret.put("appId",wechatAccountConfig.getMpAppId());
//
//        return ret;
//    }
}
