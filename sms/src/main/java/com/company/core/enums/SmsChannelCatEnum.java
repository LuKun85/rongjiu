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
public enum SmsChannelCatEnum {
	
	ALIYUN("ALIYUN", "阿里云"),
	;
	
	private String channalCat;
	private String channalName;
	
	SmsChannelCatEnum(String channalCat, String channalName) {
		this.channalCat = channalCat;
		this.channalName = channalName;
	}
	
	
	public String getChannelCatNameBychannelCat(String channalCat) {
		for (SmsChannelCatEnum cc : SmsChannelCatEnum.values()) {
			if (cc.getChannalCat().equals(channalCat)) {
				return cc.getChannalName();
			}
		}
		return null;
	}
	
	public String getChannalCat() {
		return channalCat;
	}
	
	public void setChannalCat(String channalCat) {
		this.channalCat = channalCat;
	}
	
	public String getChannalName() {
		return channalName;
	}
	
	public void setChannalName(String channalName) {
		this.channalName = channalName;
	}
}
