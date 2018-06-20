package com.company.core.domain;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class RequestBo {
 
	private String instCode;
	private String platformCode;
	private String requestBody;
	private String sign;
	
}

