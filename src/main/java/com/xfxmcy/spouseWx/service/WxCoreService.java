/**
 * WxCoreService.java
 * com.xfxmcy.spouseWx.service
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年5月8日 		cy
 *
 * Copyright (c) 2015, xfxmcy All Rights Reserved.
*/

package com.xfxmcy.spouseWx.service;

import java.util.Map;

/**
 * ClassName:WxCoreService
 * Function: WxCoreService
 * Reason:	 WxCoreService
 *
 * @author   cy
 * @version  
 * @since    Ver 1.1
 * @Date	 2015年5月8日		下午2:13:51
 *
 * @see 	 
 */
public interface WxCoreService {
	/**
	 * 
	 * disposeWxBusiness:处理微信business
	 *
	 * @param res		requestMap
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2015年5月8日 		cy
	 */
	public String disposeWxBusiness(Map<String,String> res);
}

