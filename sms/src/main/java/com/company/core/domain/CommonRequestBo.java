package com.company.core.domain;

import lombok.Data;

@Data
public class CommonRequestBo {
    
    private String smsCode;  //短信
    private String smsType;  //短信类型  发送短信, 发送CODE
    private String smsChannelId;  //渠道ID
    private String smsChannelCat;  //渠道ID
    
    private String smsPhoneNumber; //发送到手机号
    private String host;  //IP 地址
    
    private String smsOrderId;  //短信发送订单信息
    private String messageCode;  //发送的验证码
    
    
    
}

