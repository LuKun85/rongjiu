package com.company.core.constant;

public class SystemConstant extends ConfigurableContants {

	static {
		init("/system.properties");
	}
	
	public static final String USER_SESSION_KEY = "User_Session_key";
	
	public static String IP_SERVICE = getProperty("redis.ip");
	public static String PORT_SERVICE = getProperty("redis.port");
	
	public static String ENCRYPT_REQUEST_AES_KEY = getProperty("encrypt.request.aes.key");
	public static String ENCRYPT_REQUEST_AES_IV = getProperty("encrypt.request.aes.iv");
	public static String ENCRYPT_SIGN_KEY = getProperty("encrypt.sign.key");
	
}
