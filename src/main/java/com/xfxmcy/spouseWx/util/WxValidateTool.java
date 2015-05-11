/**
 * WxValidateTool.java
 * com.xfxmcy.weixin.util
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年4月11日 		cy
 *
 * Copyright (c) 2015, xfxmcy All Rights Reserved.
*/

package com.xfxmcy.spouseWx.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.springframework.stereotype.Component;

/**
 * ClassName:WxValidateTool
 * Function: validateTools 
 * Reason:	 validateTools
 *
 * @author   cy
 * @version  
 * @since    Ver 1.1
 * @Date	 2015年4月11日		下午10:38:59
 *
 * @see 	 
 */
@Component
public class WxValidateTool {
	
	private static final String token = ResourceUtil.getToken();
	
	/*	消息加密密钥由43位字符组成，可随机修改，字符范围为A-Z，a-z，0-9。 */
	
	private static final String  EncodingAESKey  = ResourceUtil.getEncodingAESKey();
	
	
	public  boolean validateRequest(String signature,String timestamp, String nonce){
		String array[] = {token,timestamp,nonce};
		/*按字典顺序排序,即字母*/
		Arrays.sort(array);
		/*连接成一个字符串*/
		StringBuffer validateStr = new StringBuffer();
		if(null != array && 0 < array.length){
			for (int i = 0; i < array.length; i++) {
				validateStr.append(array[i]);
			}
		}
		MessageDigest md = null;
		String result = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
			byte[] disBytes = md.digest(validateStr.toString().getBytes());
			/*加密*/
			result = bytesToStr(disBytes);
			System.out.println(result+"---");
			/*比较验证*/
			return result != null ? (result.equals(signature.toUpperCase())): false ;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * 
	 * bytesToStr:加密
	 *
	 * @param disBytes
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2015年4月12日 		cy
	 */
	private static String bytesToStr(byte[] disBytes) {
		
		String strDigest = "";
		for(int i = 0 ;i < disBytes.length ; i++){
			strDigest += bytesToHexStr(disBytes[i]);	
		}	
		return strDigest;
		
	}
	/**
	 * 
	 * bytesToHexStr:将字节转换十六进制字符串
	 *
	 * @param b
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2015年4月12日 		cy
	 */
	private static String bytesToHexStr(byte b) {
		char [] digit = {'0','1','2','3','4','5','6','7','8','9','A',
				'B','C','D','E','F'};
		char [] temp = new char[2];
		temp[0] = digit[ (b >>>4) & 0X0F];
		temp[1] = digit[ b & 0X0F];
		
		return new String(temp);
		
	}
}

