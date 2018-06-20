package com.company.core.service;

import com.alibaba.fastjson.JSONObject;
import com.company.core.constant.Constant;
import com.company.core.constant.NotifyException;
import com.company.core.dao.TblAlismsConfigDAO;
import com.company.core.dao.TblSmsRouteDAO;
import com.company.core.dao.TblSmsVerifyCodeDAO;
import com.company.core.domain.CommonRequestBo;
import com.company.core.enums.ErrorRespEnum;
import com.company.core.enums.SmsChannelCatEnum;
import com.company.core.table.TblAlismsConfigSQL;
import com.company.core.table.TblSmsRouteSQL;
import com.company.core.table.TblSmsVerifyCodeSQL;
import com.company.core.util.DateUtility;
import com.company.core.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 抽象类
 * @Author: weiwankun
 * @Date: 2018/5/31
 */
@Slf4j
@Service
public class BaseService {
    
    private static List<String> SMS_TYPE = Arrays.asList("CODE", "MESSAGE");
    private static List<String> SMS_CHANNEL_CAT = Arrays.asList("ALIYUN");
    private static String NUMBER_REG = "-?[0-9]+\\.?[0-9]*";
    
    @Autowired
    TblSmsRouteSQL tblSmsRouteSQL;
    @Autowired
    TblAlismsConfigSQL tblAlismsConfigSQL;
    @Autowired
    TblSmsVerifyCodeSQL tblSmsVerifyCodeSQL;
    
    
    public void paramCheckString(String param, String popMessage) {
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
    
    public void paramCheckMap(Map map, String popMessage) {
        if (map == null || map.size() == 0) {
            throw new NotifyException(ErrorRespEnum.RESP999998, popMessage);
        }
    }
    
    public void paramCheckSmsCode(CommonRequestBo commonRequestBo) {
        
        TblSmsRouteDAO tblSmsRouteDAO = tblSmsRouteSQL.get(commonRequestBo.getSmsCode());
        if(tblSmsRouteDAO == null || !Constant.STATUS_Y.equals(tblSmsRouteDAO.getStatus())){
            throw new NotifyException(ErrorRespEnum.RESP000004, "短信路由没有配置");
        }
        commonRequestBo.setSmsChannelCat(tblSmsRouteDAO.getSmsChannelCat());
        commonRequestBo.setSmsChannelId(tblSmsRouteDAO.getSmsChannelId());
    }
    
    public void paramCheckSmsChannelCat(CommonRequestBo commonRequestBo) {
        if(!SMS_CHANNEL_CAT.contains(commonRequestBo.getSmsChannelCat())){
            throw new NotifyException(ErrorRespEnum.RESP000005, "短信渠道归类错误");
        }
    }
    
    public void paramCheckSmsType(CommonRequestBo commonRequestBo) {
        if(!SMS_TYPE.contains(commonRequestBo.getSmsType())){
            throw new NotifyException(ErrorRespEnum.RESP000001, "短信发送类型不正确");
        }
    }
    
    public void paramCheckSmsChannelId(CommonRequestBo commonRequestBo) {
       if(SmsChannelCatEnum.ALIYUN.getChannalCat().equals(commonRequestBo.getSmsChannelCat())){
           TblAlismsConfigDAO tblAlismsConfigDAO = tblAlismsConfigSQL.get(commonRequestBo.getSmsChannelId());
           if(tblAlismsConfigDAO == null || !Constant.STATUS_Y.equals(tblAlismsConfigDAO.getStatus())){
               throw new NotifyException(ErrorRespEnum.RESP000006, "短信渠道配置不正确");
           }
       }
    }
    
    public void paramCheckMessageCodeAvaileableAgain(CommonRequestBo commonRequestBo) {
        TblSmsVerifyCodeDAO tblSmsVerifyCodeDAO = tblSmsVerifyCodeSQL.get(commonRequestBo);
        if(tblSmsVerifyCodeDAO == null){
            /**可以再次发送**/
            return;
        }
        /**1分钟后才能再次发送**/
        long nextTime = Long.parseLong(tblSmsVerifyCodeDAO.getSendDateTime()) + 100;
        long currTime = Long.parseLong(TimeUtil.getCurrentDateTime());
        if(nextTime > currTime){
            SimpleDateFormat format =  new SimpleDateFormat("yyyyMMddHHmmss");
            try {
                long next = format.parse(String.valueOf(nextTime)).getTime();
                long curr = format.parse(String.valueOf(currTime)).getTime();
                long rest = next - curr;
                throw new NotifyException(ErrorRespEnum.RESP000008, "请在" + rest/1000 + "秒后, 再次请求验证码");
            } catch (ParseException e) {
                e.printStackTrace();
                throw new NotifyException(ErrorRespEnum.RESP999999, "系统错误");
            }
        }
    }
    
    //检查手机号是否正确
    public void paramCheckPhoneNumber(String phoneNumber) {
    
        isNumeric(phoneNumber);
        if (phoneNumber.length() != 11) {
            throw new NotifyException(ErrorRespEnum.RESP000003, "手机号不正确");
        }
        
        String firstChar = phoneNumber.substring(0, 1);
        if (!"1".equals(firstChar)) {
            throw new NotifyException(ErrorRespEnum.RESP000003, "手机号不正确");
        }
    }
    
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile(NUMBER_REG);
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
    
    public static boolean isNumeric2(String str) {
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
}
