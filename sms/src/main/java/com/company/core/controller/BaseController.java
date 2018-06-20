package com.company.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.core.constant.NotifyException;
import com.company.core.constant.SystemConstant;
import com.company.core.domain.CommonRequestBo;
import com.company.core.domain.CommonResponseBo;
import com.company.core.domain.RequestBo;
import com.company.core.enums.ErrorRespEnum;
import com.company.core.util.AESUtility;
import com.company.core.util.MD5Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import jodd.util.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @program: online
 * @description: 抽象方法
 * @author: weiwankun
 * @create: 2018-06-01 21:54
 **/
@Slf4j
public abstract class BaseController {
    
    private static final String AUTHORIZATION = "Authorization";
    
    protected CommonRequestBo getRequestParams(HttpServletRequest request) throws IOException {
        
        try {
            /**获取参数**/
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            StringBuilder stb = new StringBuilder();
            String line = null;
            while ((line = in.readLine()) != null) {
                stb.append(line);
            }
            String param = stb.toString();
            if (StringUtils.isBlank(param)) {
                throw new NotifyException(ErrorRespEnum.RESP999998, "传入参数为空");
            }
            /**解析获取参数**/
            RequestBo requestBo = new Gson().fromJson(param, RequestBo.class);
            if (requestBo == null) {
                throw new NotifyException(ErrorRespEnum.RESP999998, "传入参数为空");
            }
            /**参数验证**/
            this.paramCheckString(requestBo.getInstCode(), "机构号不能为空");
            this.paramCheckString(requestBo.getRequestBody(), "请求内容不能为空");
            this.paramCheckString(requestBo.getSign(), "签名不能为空");
    
            /**解析参数requestBody**/
            String body = this.parseBody(requestBo.getRequestBody());
            log.info("请求参数明细:" + body);
    
            /**验签**/
            this.verifySign(body, requestBo.getSign());
            log.info("请求参数明细:" + body);
            /**属性赋值**/
            CommonRequestBo commonRequestBo = new Gson().fromJson(body, CommonRequestBo.class);
            this.paramCheckRequest(commonRequestBo);
            
            return commonRequestBo;
            
        } catch (Exception ex) {
            if (ex instanceof NotifyException) {
                throw ex;
            } else {
                throw new NotifyException(ErrorRespEnum.RESP999999, "系统错误");
            }
        }
    }
    
    /**
     * 验签
     **/
    protected void verifySign(String query, String sign) {
        
        try {
            String sysSign = MD5Util.getMD5Str2(query + SystemConstant.ENCRYPT_SIGN_KEY).toUpperCase();
            if(!sysSign.equals(sign)){
                throw new NotifyException(ErrorRespEnum.RESP999997, "验签失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new NotifyException(ErrorRespEnum.RESP999999, "系统错误");
        }
    }
    
    /**
     * 解析参数
     **/
    protected String parseBody(String body){
        try {
            String base64 = Base64.decodeToString(body);
            String parsedBody = AESUtility.decrypt(base64);
            if (StringUtils.isBlank(parsedBody)) {
                throw new NotifyException(ErrorRespEnum.RESP999996, "解析参数失败");
            }
            return parsedBody;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new NotifyException(ErrorRespEnum.RESP999999, "系统错误");
        }
    }
    
    protected void paramCheckRequest(CommonRequestBo commonRequestBo) {
        if (commonRequestBo == null) {
            throw new NotifyException(ErrorRespEnum.RESP999998, "传入参数为空");
        }
    }
    
    protected void paramCheckString(String param, String popMessage) {
        if (StringUtils.isBlank(param)) {
            throw new NotifyException(ErrorRespEnum.RESP999998, popMessage);
        }
    }
    
    public void paramCheckList(List list, String popMessage) {
        if (list == null || list.size() == 0) {
            throw new NotifyException(ErrorRespEnum.RESP999998, popMessage);
        }
    }
    
    public void paramCheckJson(JSONObject jsonObject, String popMessage) {
        if (jsonObject == null || jsonObject.size() == 0) {
            throw new NotifyException(ErrorRespEnum.RESP999998, popMessage);
        }
    }
    
    protected void finalProcessException(Exception ex, CommonResponseBo commonResponseBo) {
        if (ex instanceof NotifyException) {
            commonResponseBo.setRespCode(((NotifyException) ex).getErrorResp().getRespCode());
            commonResponseBo.setRespMsg(((NotifyException) ex).getErrorMesg());
        } else {
            commonResponseBo.setRespCode(ErrorRespEnum.RESP999999.getRespCode());
            commonResponseBo.setRespMsg("系统错误");
        }
    }
    
    protected void responseToCaller(HttpServletRequest request, HttpServletResponse response, Object obj) {
        
        response.setContentType("application/Json" + ";charset=UTF-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Access-Control-Allow-Origin", "*");
        
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                Boolean isSet = false;
                if (cookie.getName().equals(AUTHORIZATION)) {
                    cookie.setValue(request.getSession().getId());
                    cookie.setPath("/");
                    cookie.setMaxAge(5000);
                    response.addCookie(cookie);
                    isSet = true;
                }
                if (!isSet) {
                    Cookie cookie2 = new Cookie("AuthorizationToken", request.getSession().getId());
                    response.addCookie(cookie2);
                }
            }
        } else {
            Cookie cookie = new Cookie("AuthorizationToken", request.getSession().getId());
            response.addCookie(cookie);
        }
        
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String str = gson.toJson(obj);
        log.info("返回结果:" + str);
        
        try {
            response.getWriter().write(str);
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
            log.info("返回调用失败", e);
        }
    }
    
    
}
