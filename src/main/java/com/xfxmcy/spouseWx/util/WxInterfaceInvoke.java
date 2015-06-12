/**
 * WxInterfaceInvoke.java
 * com.xfxmcy.spouseWx.util
 *
 * Function： weixin 's interface invoking 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年5月12日 		cy
 *
 * Copyright (c) 2015, xfxmcy All Rights Reserved.
*/

package com.xfxmcy.spouseWx.util;

import net.sf.json.JSONObject;


import com.xfxmcy.spouseWx.pojo.WxUser;

/**
 * ClassName:WxInterfaceInvoke
 * Function: weixin 's interface invoking
 * Reason:	 weixin 's interface invoking
 *
 * @author   cy
 * @version  
 * @since    Ver 1.1
 * @Date	 2015年5月12日		下午4:56:29
 *
 * @see 	 
 */
public class WxInterfaceInvoke {
	
	// user 查询（POST）
	public final static String USER_QUERY_OPENID = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	
	
	
	/**
	 * 
	 * queryWxUserByOpenId: query user by openId
	 *
	 * @param openId
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2015年5月12日 		cy
	 */
	public WxUser queryWxUserByOpenId(String openId){
		String requestUrl = USER_QUERY_OPENID.replace("ACCESS_TOKEN", CommonUtil.ACCESS_TOKEN);
		// 发起GET请求查询菜单
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			//result = jsonObject.toString();
		}
		return null;
	}
}

