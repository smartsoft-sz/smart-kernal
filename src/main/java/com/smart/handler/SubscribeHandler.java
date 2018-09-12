package com.smart.handler;

import com.smart.service.UserService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 */
@Component
public class SubscribeHandler extends AbstractHandler {

    @Autowired
    private UserService userService;

//    @Autowired
//    private RoleService roleService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) throws WxErrorException {

//        this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser());
//
//        // 获取微信用户基本信息
//        WxMpUser userWxInfo = weixinService.getUserService()
//                .userInfo(wxMessage.getFromUser(), null);
//        userService.preRegisterClientUser(userWxInfo);
//
//        WxMpXmlOutMessage responseResult = null;
//        try {
//            responseResult = handleSpecial(wxMessage);
//        } catch (Exception e) {
//            this.logger.error(e.getMessage(), e);
//        }
//
//        if (responseResult != null) {
//            return responseResult;
//        }
//
//        try {
//            return new TextBuilder().build("感谢关注", wxMessage, weixinService);
//        } catch (Exception e) {
//            this.logger.error(e.getMessage(), e);
//        }

        return null;
    }

    /**
     * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
     */
    private WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage)
            throws Exception {
        //TODO
        return null;
    }

}
