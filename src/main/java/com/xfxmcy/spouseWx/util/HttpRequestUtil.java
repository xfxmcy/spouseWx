/**
 * HttpJuheUtil.java
 * com.xfxmcy.spouseWx.util
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年5月20日 		cy
 *
 * Copyright (c) 2015, xfxmcy All Rights Reserved.
*/

package com.xfxmcy.spouseWx.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * ClassName:HttpRequestUtil
 * Function: http coonection util in juhe
 * Reason:	 http coonection util in juhe
 *
 * @author   cy
 * @version  
 * @since    Ver 1.1
 * @Date	 2015年5月20日		下午4:59:11
 *
 * @see 	 
 */
public class HttpRequestUtil {
	/*快递查询url   聚合数据*/
	public static String EXPRESS_URL_JUHE = "http://v.juhe.cn/exp/index?key=" + ResourceUtil.getJuHeKey_EXPRESS();
	/*天气预报查询url 聚合数据*/
	public static String WEATHER_URL_JUHE = "http://op.juhe.cn/onebox/weather/query?key=" + ResourceUtil.getJuHeKey_WEATHER();
	/*快递100*/ 
	public static String EXPRESS_URL_KUAIDI100 = "http://api.kuaidi100.com/api?id=XXXX&com=tiantian&nu=11111&show=2&muti=1&order=desc=";
	/**
	 * 
	 * httpRequest:get response
	 *
	 * @param url	url
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2015年5月20日 		cy
	 */
	public static String httpRequest(String urlAddress){
		String result = null;
		URL url = null ;
		HttpURLConnection conn = null ;
		try {
			url = new URL(urlAddress);
			conn = (HttpURLConnection) url.openConnection();
			BufferedReader bR = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line = "";
			while ((line = bR.readLine())!= null) {
				sb.append(line);
			}
			bR.close();
			conn.disconnect();
			result = sb.toString();
			sb  = null ;
		} catch (Exception e) {
			LoggerWx.loggingWx(e);
		}
		
		return result;
	}
}

