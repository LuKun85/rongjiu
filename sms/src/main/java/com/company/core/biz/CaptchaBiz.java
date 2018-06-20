package com.company.core.biz;

import com.company.core.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

/**
 * @program: mmp
 * @description: 验证码Redis
 * @author: weiwankun
 * @create: 2018-05-15 16:51
 **/
@Service
public class CaptchaBiz {
    
    public static final String CAPTCHA_KEY = "captcha_key";
    private static final String AUTHORIZATION = "AuthorizationToken";
    
    @Autowired
    JedisBiz jedisBiz;
    
    public void saveCaptchaToRedis(String capText) {
        
        Jedis jedis = null;
        try {
            jedis = jedisBiz.getResource();
            /** 保存5分钟 **/
            jedis.setex(CAPTCHA_KEY + TimeUtil.getCurrentDate() + capText, 60 * 5, capText);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jedisBiz.returnResource(jedis);
        }
    }
    
    public String getCaptchaToRedis(String capText) {
        Jedis jedis = null;
        String captcha = "";
        try {
            jedis = jedisBiz.getResource();
            captcha = jedis.get(CAPTCHA_KEY + TimeUtil.getCurrentDate() + capText);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jedisBiz.returnResource(jedis);
        }
        return captcha;
    }
    
    /**
     * 删除指定验证码
     **/
    public String clearCaptchaFromRedis(String capText) {
        
        Jedis jedis = null;
        String captcha = "";
        try {
            jedis = jedisBiz.getResource();
            jedis.del(CAPTCHA_KEY + TimeUtil.getCurrentDate() + capText);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jedisBiz.returnResource(jedis);
        }
        return captcha;
    }
    
    /**
     * 批量删除
     **/
    public String clearCaptchaFromRedisBatch() {
        
        Jedis jedis = null;
        String captcha = "";
        try {
            jedis = jedisBiz.getResource();
            Set<String> set = jedis.keys("CAPTCHA_KEY*");
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String keyStr = it.next();
                jedis.del(keyStr);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jedisBiz.returnResource(jedis);
        }
        return captcha;
    }
}
