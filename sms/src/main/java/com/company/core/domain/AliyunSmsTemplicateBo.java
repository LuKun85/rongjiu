package com.company.core.domain;

import lombok.Data;

/**
 * @program: sms
 * @description: 短信发送内容
 * @author: weiwankun
 * @create: 2018-05-30 14:32
 **/
@Data
public class AliyunSmsTemplicateBo {
    
    private String code;
    private String message;
    private String time;
    private String restTime;
    
}
