package com.company.core.domain;

import lombok.Data;

/**
 * @program: sms
 * @description: 短信应答属性
 * @author: weiwankun
 * @create: 2018-05-30 14:32
 **/
@Data
public class AliyunSmsResponseBo {

    private String respCode;
    private String respMsg;
    private String requestId;
    private String bizId;

}
