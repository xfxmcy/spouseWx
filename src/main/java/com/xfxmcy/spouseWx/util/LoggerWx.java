/**
 * LoggerWx.java
 * com.xfxmcy.spouseWx.util
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年5月8日 		cy
 *
 * Copyright (c) 2015, xfxmcy All Rights Reserved.
*/

package com.xfxmcy.spouseWx.util;

import org.apache.log4j.Logger;

/**
 * ClassName:LoggerWx
 * Function: logging util
 * Reason:	 logging util
 *
 * @author   cy
 * @version  
 * @since    Ver 1.1
 * @Date	 2015年5月8日		下午1:45:21
 *
 * @see 	 
 */
public class LoggerWx {
	/**
	 *  looger
	 */
	private static final Logger logger = Logger.getLogger(LoggerWx.class);
	
	
	/**
	 * 
	 * loogingWx:logging for exception
	 *
	 * @param e
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2015年5月8日 		cy
	 */
	public static String loggingWx(Exception e){
		logger.error("weixin.........................." + e.getMessage());
		/*developing model*/
		e.printStackTrace();
		return null;
	}
	/**
	 * 
	 * debugInfo:debug information
	 *
	 * @param message
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2015年5月8日 		cy
	 */
	public static void debugInfo(String message){
		logger.debug("weixin.........................." + message);
	}
	
}

