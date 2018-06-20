package com.company.core.domain;

import lombok.Data;

/**
 * @program: sms
 * @description: 短信请求属性
 * @author: weiwankun
 * @create: 2018-05-30 14:32
 **/
@Data
public class AliyunSmsRequestBo {
    
    private String toPhoneNumber;
    private String sendOrderNo;  //发送的流水号
    
    private String smsChannelId;
    private String smsChannelName;
    private String smsProduct;
    private String smsDomain;
    private String smsAccessKeyId;
    private String smsAccessKeySecret;
    private String connectTimeOut;
    private String readTimeOut;
    private String signName;
    private String templicateCode;
    private String templicateParam;


}
