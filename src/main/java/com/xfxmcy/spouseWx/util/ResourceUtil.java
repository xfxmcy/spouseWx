/**
 * ResourceUtil.java
 * com.xfxmcy.spouse.util
 *
 * Function： resource 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2013-10-1 		cy
 *
 * Copyright (c) 2013, XFXMCY All Rights Reserved.
*/

package com.xfxmcy.spouseWx.util;

import java.util.ResourceBundle;

/**
 * ClassName:ResourceUtil
 * Function: resource
 * Reason:	 resource
 *
 * @author   cy
 * @version  
 * @since    Ver 1.1
 * @Date	 2013-10-1		下午4:32:23
 *
 * @see 	 
 */
public class ResourceUtil {
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("config");

	private  ResourceUtil() {
		
	}
	/**
	 * 
	 * getSessionInfo: acquire session 's name
	 *
	 * @return			property's key
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2013-10-1 		cy
	 */
	public static final String getSessionInfo() {
		
		return bundle.getString("sessionInfoName");
		
	}
	/**
	 * 
	 * getToken: get token
	 *
	 * @return			property's key
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2013-10-1 		cy
	 */
	public static final String getToken() {
		
		return bundle.getString("token");
		
	}
	/**
	 * 
	 * getEncodingAESKey:EncodingAESKey
	 *
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2014年7月16日 		cy
	 */
	public static final String getEncodingAESKey() {
			
		return bundle.getString("encodingAESKey");
			
	}
	
	/**
	 * 
	 * getMailSslEnable: ssl enable
	 *
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2014年7月16日 		cy
	 */
	public static final String getMailSslEnable() {
			
		return bundle.getString("mail.smtp.ssl.enable");
			
	}
	/**
	 * 
	 * getMailAuthor:mail author account
	 *
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2014年7月16日 		cy
	 */
	public static final String getMailAuthor() {
		
		return bundle.getString("mail.author.account");
		
	}
	/**
	 * 
	 * getMailAuthor: get second mail author
	 *
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2014年9月7日 		cy
	 */
	public static final String getMailSecondAuthor() {
		
		return bundle.getString("mail.second.author.account");
		
	}
	/**
	 * 
	 * getMailAuthor: get second mail passwd
	 *
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2014年9月7日 		cy
	 */
	public static final String getMailSecondAuthorPasswd() {
		
		return bundle.getString("mail.second.author.passwd");
		
	}
	/**
	 * 
	 * getMailAuthorPasswd:mail author passwd
	 *
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2014年7月16日 		cy
	 */
	public static final String getMailAuthorPasswd() {
		
		return bundle.getString("mail.author.passwd");
		
	}
	/**
	 * 
	 * getMailSmtpServer:mail smtp server
	 *
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2014年7月16日 		cy
	 */
	public static final String getMailSmtpServer() {
		
		return bundle.getString("mail.smtp.server");
		
	}
	/**
	 * 
	 * getMailSender:mail receiver
	 *
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2014年7月16日 		cy
	 */
	public static final String getMailSender() {
		
		return bundle.getString("mail.transport.sender.account");
		
	}
	/**
	 * 
	 * getSmtpPort:get smtp port
	 *
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2014年7月19日 		cy
	 */
	public static int getSmtpPort() {
		
		return Integer.valueOf(bundle.getString("mail.smtp.port"));
		
	}
	
	/**
	 * 
	 * getMailSenderSecond:mail receiver
	 *
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2014年7月21日 		cy
	 */
	public static String getMailSenderSecond() {

		return bundle.getString("mail.transport.sender.second.account");
	}
	
	/**
	 * 
	 * getPop3Port:get port for pop3
	 *
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2014年9月16日 		cy
	 */
	public static int getPop3Port() {
		
		return Integer.valueOf(bundle.getString("mail.pop3.port"));
		
	}
	
	/**
	 * 
	 * getMeialTempaltePath: get media  's tempalte path
	 *
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2014年11月22日 		cy
	 */
	public static String getMediaTempaltePath() {
		
		return bundle.getString("media.template");
		
	}
}

