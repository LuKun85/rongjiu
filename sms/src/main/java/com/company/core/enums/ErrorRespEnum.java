/**
 *
 */
package com.company.core.enums;

/**
 * @Description:
 *
 * @Author: weiwankun
 * @Date:  2018/5/28
 */
public enum ErrorRespEnum {
	
	/**请求成功**/
	RESP000000("000000", "请求成功"),
	
	/****/
	RESP000001("000001", "短信发送类型不正确"),
	RESP000002("000002", "短信类型CODE不正确"),
	RESP000003("000003", "手机号不正确"),
	RESP000004("000004", "短信路由没有配置"),
	RESP000005("000005", "短信渠道归类错误"),
	RESP000006("000006", "短信渠道配置不正确"),
	RESP000007("000007", "渠道短信发送失败"),
	RESP000008("000008", "请勿频繁发送验证码"),
	RESP000009("000009", "验证码不正确,请重新获取"),
	RESP000010("000010", "请先获取验证码"),
	
	//系统错误
	RESP999996("999996", "解析参数失败"),
	RESP999997("999997", "验签失败"),
	RESP999998("999998", "传入参数为空"),
	RESP999999("999999", "系统错误"),
	;
	
	private String respCode;
	private String respMsg;
	
	ErrorRespEnum(String respCode, String respMsg) {
		this.respCode = respCode;
		this.respMsg = respMsg;
	}
	
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	
	public String getRespMsg() {
		return respMsg;
	}
	
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	
	public String getRespCode() {
		return this.respCode;
	}
	
}
