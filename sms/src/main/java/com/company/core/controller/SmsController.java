package com.company.core.controller;

import com.company.core.constant.NotifyException;
import com.company.core.domain.CommonRequestBo;
import com.company.core.domain.CommonResponseBo;
import com.company.core.enums.ErrorRespEnum;
import com.company.core.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: online
 * @description: 短信接口
 * @author: weiwankun
 * @create: 2018-05-30 14:27
 **/
@Controller
@RequestMapping(value = "/sms")
@Slf4j
public class SmsController extends BaseController {
    
    @Autowired
    SmsService smsService;
    
    /**
     * 发送验证码
     **/
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public void toSend(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        
        log.info("短信发送");
        
        /**应答参数**/
        CommonResponseBo commonResponseBo = new CommonResponseBo();
        try {
            CommonRequestBo commonRequestBo = super.getRequestParams(request);
            if (commonRequestBo == null) {
                throw new NotifyException(ErrorRespEnum.RESP999998, "传入参数为空");
            }
            /** IP**/
            String host = request.getHeader("X-Real-IP");
            if(StringUtils.isBlank(host)){
                host = request.getHeader("X-Forwarded-For");
                if(StringUtils.isBlank(host)){
                    host = request.getRemoteHost();
                }
            }
            commonRequestBo.setHost(host);
    
            smsService.checkSend(commonRequestBo);
    
            smsService.doSend(commonRequestBo, commonResponseBo);
            
        } catch (Exception ex) {
            log.error("短信发送失败");
            ex.printStackTrace();
            super.finalProcessException(ex, commonResponseBo);
        }
        super.responseToCaller(request, response, commonResponseBo);
    }
    
    /**
     * 检验验证码
     **/
    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public void toVerify(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        
        log.info("验证码验证");
        
        /**应答参数**/
        CommonResponseBo commonResponseBo = new CommonResponseBo();
        try {
            CommonRequestBo commonRequestBo = super.getRequestParams(request);
            if (commonRequestBo == null) {
                throw new NotifyException(ErrorRespEnum.RESP999998, "传入参数为空");
            }
            /** IP**/
            String host = request.getHeader("X-Real-IP");
            if(StringUtils.isBlank(host)){
                host = request.getHeader("X-Forwarded-For");
                if(StringUtils.isBlank(host)){
                    host = request.getRemoteHost();
                }
            }
            commonRequestBo.setHost(host);
            
            smsService.checkVerify(commonRequestBo);
            
            smsService.doVerify(commonRequestBo, commonResponseBo);
            
        } catch (Exception ex) {
            log.error("短信验证失败");
            ex.printStackTrace();
            super.finalProcessException(ex, commonResponseBo);
        }
        super.responseToCaller(request, response, commonResponseBo);
    }
    
}
