/**
 *
 */
package com.company.core.constant;

import com.company.core.enums.ErrorRespEnum;

/**
 * @Description:
 *
 * @Author: weiwankun
 * @Date:  2018/6/1
 */
public class NotifyException extends RuntimeException {
    
    private static final long serialVersionUID = -930457678038938439L;
    ErrorRespEnum errorResp;
    String errorMesg;

    public NotifyException(ErrorRespEnum errorResp, String errorMesg) {
        this.errorResp = errorResp;
        this.errorMesg = errorMesg;
    }

    public ErrorRespEnum getErrorResp() {
        return errorResp;
    }

    public String getErrorMesg() {
        return errorMesg;
    }
}
