

package com.company.core.service;

import com.company.core.domain.CommonRequestBo;
import com.company.core.domain.AliyunSmsRequestBo;
import com.company.core.domain.AliyunSmsResponseBo;
import com.company.core.domain.CommonResponseBo;

public interface SmsService {
    
    void checkSend(CommonRequestBo commonRequestBo);
    
    void checkVerify(CommonRequestBo commonRequestBo);
    
    void doSend(CommonRequestBo commonRequestBo, CommonResponseBo commonResponseBo);
    
    void doVerify(CommonRequestBo commonRequestBo, CommonResponseBo commonResponseBo);
    
    void aliyunSendCode(AliyunSmsRequestBo aliyunSmsRequestBo, CommonResponseBo commonResponseBo);
}
