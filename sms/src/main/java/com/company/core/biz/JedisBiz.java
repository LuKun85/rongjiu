package com.company.core.biz;

import com.company.core.constant.SystemConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Slf4j
@Service
public class JedisBiz {

	private static int TIME_OUT = 200 * 1000; // 单位毫秒
	static JedisPool pool = null;
	
	public JedisBiz() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(500); // 最多连接数，-1不限制
		config.setMaxIdle(5); // 最多空闲连接数
		config.setMaxWaitMillis(1000 * 100); // 等待空闲连接时间，-1不超时
		config.setTestOnBorrow(true); // 检测连接可用性，即返回的都可用
		pool = new JedisPool(config, SystemConstant.IP_SERVICE, Integer.parseInt(SystemConstant.PORT_SERVICE),
				TIME_OUT);
		
		log.debug("加载redis配置：ip:【{}】，prot:【{}】",SystemConstant.IP_SERVICE ,SystemConstant.PORT_SERVICE);
	}

	public Jedis getResource() {
		if (pool != null) {
			return pool.getResource();
		}
		return null;
	}

	public void returnResource(Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}
	
}
