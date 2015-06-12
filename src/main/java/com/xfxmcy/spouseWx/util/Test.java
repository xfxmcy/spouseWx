/**
 * Test.java
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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.xfxmcy.spouseWx.pojo.Express;
import com.xfxmcy.spouseWx.pojo.ExpressInfo;
import com.xfxmcy.spouseWx.pojo.ExpressItem;

/**
 * ClassName:Test
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   cy
 * @version  
 * @since    Ver 1.1
 * @Date	 2015年5月20日		下午5:25:12
 *
 * @see 	 
 */
public class Test {
	public static void main(String[] args) {
		String result = HttpRequestUtil.httpRequest("http://v.juhe.cn/exp/index?key=58bdf527a7197885574709141f0328ef&com=yt&no=802809550351");
		System.out.println(result);				//http://op.juhe.cn/onebox/weather/query?cityname=%E6%B8%A9%E5%B7%9E&key=您申请的KEY
		/*String tianjin = "天津";
		try {
			String urlWeather = URLEncoder.encode(tianjin, "UTF-8");
			String result = HttpRequestUtil.httpRequest("http://op.juhe.cn/onebox/weather/query?cityname="+urlWeather+"&key=c01948214f92e0531457c14008a0106f");
			System.out.println(result);
		} catch (UnsupportedEncodingException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}*/
		
		/*String test = "{\"resultcode\":\"200\",\"reason\":\"成功的返回\",\"result\":{\"company\":\"圆通\",\"com\":\"yt\",\"no\":\"802809550351\",\"list\":[{\"datetime\":\"2015-05-29 21:48\",\"remark\":\"广东省东莞市石碣公司 已收件\",\"zone\":\"\"},{\"datetime\":\"2015-05-29 23:16\",\"remark\":\"广东省东莞市石碣公司 已打包\",\"zone\":\"\"},{\"datetime\":\"2015-06-01 06:10\",\"remark\":\"天津转运中心公司 已拆包\",\"zone\":\"\"},{\"datetime\":\"2015-06-01 06:11\",\"remark\":\"天津转运中心公司 已发出\",\"zone\":\"\"},{\"datetime\":\"2015-06-01 14:33\",\"remark\":\"天津市北辰区二部公司 已收入\",\"zone\":\"\"},{\"datetime\":\"2015-06-01 14:55\",\"remark\":\"天津市北辰区二部公司 派件中\",\"zone\":\"\"},{\"datetime\":\"2015-06-02 11:00\",\"remark\":\"天津市北辰区二部公司 签收失败\",\"zone\":\"\"},{\"datetime\":\"2015-06-02 18:07\",\"remark\":\"天津市北辰区二部公司 派件中\",\"zone\":\"\"},{\"datetime\":\"2015-06-02 18:47\",\"remark\":\"天津市北辰区二部公司 已签收\",\"zone\":\"\"}],\"status\":1},\"error_code\":0}";
		Express exp = JSONObject.parseObject(test, Express.class);
		StringBuffer buffer = new StringBuffer();
		ExpressInfo result = exp.getResult();
		if(null != result){
			List<ExpressItem> items = result.getList();
			Collections.reverse(items);			
			if(null != items && items.size() > 0){
				
				for (int i = 0; i < items.size(); i++) {
					buffer.append(  items.get(i).getDatetime());
					buffer.append("\n");
					buffer.append("" + items.get(i).getRemark());
					buffer.append("\n\n");
				}
			}
		}
		System.out.println(buffer.toString());*/
		
	}
}

