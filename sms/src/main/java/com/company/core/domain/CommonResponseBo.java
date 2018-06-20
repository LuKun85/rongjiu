package com.company.core.domain;

import com.company.core.enums.ErrorRespEnum;
import lombok.Data;

/**
 * @Description: 通用应答
 *
 * @Author: weiwankun
 * @Date:  2018/5/25
 */
@Data
public class CommonResponseBo {

	private String version;
	private String respCode = ErrorRespEnum.RESP999999.getRespCode();
	private String respMsg = "系统错误";
	
	private String smsOrderId;  //短信发送订单信息
	private String requestId;
	private String bizId;
	
	
	
}
