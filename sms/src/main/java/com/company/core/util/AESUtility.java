package com.company.core.util;

import com.company.core.constant.SystemConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

/**
 * @Description: AES
 *
 * @Author: weiwankun
 * @Date:  2018/6/6
 */
@Slf4j
public class AESUtility {
    
    // 解密
    public static String encrypt(String pdata) throws Exception {
        try {
            
            String key = SystemConstant.ENCRYPT_REQUEST_AES_KEY;
            String iv = SystemConstant.ENCRYPT_REQUEST_AES_IV;
            
            byte[] data = Hex.decodeHex(pdata.toCharArray());
            
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("utf-8"), "AES");
            
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(iv.getBytes("utf-8")));
            
            return new String(cipher.doFinal(data));
            
        } catch (NoSuchAlgorithmException na) {
            log.error(na.getMessage(),na);
        } catch (NoSuchPaddingException np) {
            log.error(np.getMessage(),np);
        } catch(Exception e) {
            log.error(e.getMessage(),e);
        }
        return null;
    }
    
    
    // 解密
    public static String decrypt(String pdata) throws Exception {
        try {
            
            String key = SystemConstant.ENCRYPT_REQUEST_AES_KEY;
            String iv = SystemConstant.ENCRYPT_REQUEST_AES_IV;
    
            byte[] data = Hex.decodeHex(pdata.toCharArray());
    
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("utf-8"), "AES");
    
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(iv.getBytes("utf-8")));
    
            return new String(cipher.doFinal(data));
    
        } catch (NoSuchAlgorithmException na) {
        	log.error(na.getMessage(),na);
        } catch (NoSuchPaddingException np) {
        	log.error(np.getMessage(),np);
        } catch(Exception e) {
        	log.error(e.getMessage(),e);
        }
        return null;
    }
    
    public static void main(String[] args) {
    
        String key = "1234567890000000";
        String iv = "1234567890000000";
        
        String parseData = "b64601e74f3bf3f70ee1cf1a4f74765b8ee4316959bdc826489f159c9e71e12c";
    
        
        try {
            byte[] data = Hex.decodeHex(parseData.toCharArray());
            
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("utf-8"), "AES");
            
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(iv.getBytes("utf-8")));
    
            log.info("cipher.doFinal(data)=" + String.valueOf(cipher.doFinal(data)));
    
        } catch (Exception ex) {
            ex.printStackTrace();
        
        }
	   
    }

}
