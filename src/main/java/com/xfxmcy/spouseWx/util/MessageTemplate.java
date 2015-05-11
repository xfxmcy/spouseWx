/**
 * MessageTemplate.java
 * com.xfxmcy.spouseWx.util
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年5月11日 		cy
 *
 * Copyright (c) 2015, xfxmcy All Rights Reserved.
*/

package com.xfxmcy.spouseWx.util;
/**
 * ClassName:MessageTemplate
 * Function: message template
 * Reason:	 message template
 *
 * @author   cy
 * @version  
 * @since    Ver 1.1
 * @Date	 2015年5月11日		上午10:04:06
 *
 * @see 	 
 */
public class MessageTemplate {
	
	
	
	public static String getMainMenu() {  
	    StringBuffer buffer = new StringBuffer();  
	    buffer.append("您好，我是cy，请回复数字选择服务：").append("\n\n");  
	    buffer.append("1  天气预报").append("\n");  
	    buffer.append("2  公交查询").append("\n");  
	    buffer.append("3  我的照片").append("\n");  
	    buffer.append("4  他的照片").append("\n\n");  
	   /* buffer.append("5  经典游戏").append("\n");  
	    buffer.append("6  美女电台").append("\n");  
	    buffer.append("7  人脸识别").append("\n");  
	    buffer.append("8  聊天唠嗑").append("\n\n");*/  
	    buffer.append("回复“?”显示此帮助菜单");  
	    return buffer.toString();  
	}  
	
}

