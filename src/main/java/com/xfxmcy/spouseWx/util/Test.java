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
import java.util.List;


import com.alibaba.fastjson.JSONObject;
import com.xfxmcy.spouseWx.pojo.WeatherInfo;
import com.xfxmcy.spouseWx.pojo.WeatherRealtime;


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
		//String result = HttpRequestUtil.httpRequest("http://v.juhe.cn/exp/index?key=58bdf527a7197885574709141f0328ef&com=yt&no=802809550351");
		//System.out.println(result);				//http://op.juhe.cn/onebox/weather/query?cityname=%E6%B8%A9%E5%B7%9E&key=您申请的KEY
		/*String tianjin = "天津44";
		try {
			String urlWeather = URLEncoder.encode(tianjin, "UTF-8");
			String result = HttpRequestUtil.httpRequest("http://op.juhe.cn/onebox/weather/query?cityname="+urlWeather+"&key=c01948214f92e0531457c14008a0106f");
			System.out.println(result);
		} catch (UnsupportedEncodingException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}*/
		/*try {
			String position = "天津";
			position = URLEncoder.encode(position, "utf-8");
			String result = HttpRequestUtil.httpRequest("http://op.juhe.cn/onebox/weather/query?cityname="+ position +"&key=c01948214f92e0531457c14008a0106f");
			System.out.println(result);
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}*/
		
	/*	String test = "{\"reason\":\"successed!\",\"result\":{\"data\":{\"realtime\":{\"city_code\":\"101030100\",\"city_name\":\"天津\",\"date\":\"2015-06-15\",\"time\":\"10:00:00\",\"week\":1,\"moon\":\"四月廿九\",\"dataUptime\":1434334202,\"weather\":{\"temperature\":\"27\",\"humidity\":\"41\",\"info\":\"多云\",\"img\":\"1\"},\"wind\":{\"direct\":\"东风\",\"power\":\"2级\",\"offset\":null,\"windspeed\":null}},\"life\":{\"date\":\"2015-6-15\",\"info\":{\"chuanyi\":[\"炎热\",\"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。\"],\"ganmao\":[\"少发\",\"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。\"],\"kongtiao\":[\"部分时间开启\",\"天气热，到中午的时候您将会感到有点热，因此建议在午后较热时开启制冷空调。\"],\"wuran\":[\"中\",\"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。\"],\"xiche\":[\"较适宜\",\"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。\"],\"yundong\":[\"适宜\",\"天气较好，赶快投身大自然参与户外运动，尽情感受运动的快乐吧。\"],\"ziwaixian\":[\"中等\",\"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。\"]}},\"weather\":[{\"date\":\"2015-06-15\",\"info\":{\"day\":[\"1\",\"多云\",\"32\",\"南风\",\"微风\",\"04:44\"],\"night\":[\"1\",\"多云\",\"24\",\"西南风\",\"微风\",\"19:38\"]},\"week\":\"一\",\"nongli\":\"四月廿九\"},{\"date\":\"2015-06-16\",\"info\":{\"dawn\":[\"1\",\"多云\",\"24\",\"西南风\",\"微风\",\"19:38\"],\"day\":[\"2\",\"阴\",\"33\",\"东南风\",\"微风\",\"04:44\"],\"night\":[\"2\",\"阴\",\"24\",\"东北风\",\"3-4 级\",\"19:38\"]},\"week\":\"二\",\"nongli\":\"五月初一\"},{\"date\":\"2015-06-17\",\"info\":{\"dawn\":[\"2\",\"阴\",\"24\",\"东北风\",\"3-4 级\",\"19:38\"],\"day\":[\"1\",\"多云\",\"31\",\"东风\",\"微风\",\"04:44\"],\"night\":[\"4\",\"雷阵雨\",\"22\",\"北风\",\"3-4 级\",\"19:39\"]},\"week\":\"三\",\"nongli\":\"五月初二\"},{\"date\":\"2015-06-18\",\"info\":{\"dawn\":[\"4\",\"雷阵雨\",\"22\",\"北风\",\"3-4 级\",\"19:39\"],\"day\":[\"0\",\"晴\",\"31\",\"北风\",\"3-4 级\",\"04:44\"],\"night\":[\"1\",\"多云\",\"20\",\"北风\",\"微风\",\"19:39\"]},\"week\":\"四\",\"nongli\":\"五月初三\"},{\"date\":\"2015-06-19\",\"info\":{\"dawn\":[\"1\",\"多云\",\"20\",\"北风\",\"微风\",\"19:39\"],\"day\":[\"1\",\"多云\",\"30\",\"北风\",\"微风\",\"04:44\"],\"night\":[\"1\",\"多云\",\"22\",\"北风\",\"微风\",\"19:39\"]},\"week\":\"五\",\"nongli\":\"五月初四\"},{\"date\":\"2015-06-20\",\"info\":{\"dawn\":[\"1\",\"多云\",\"22\",\"北风\",\"微风\",\"19:39\"],\"day\":[\"2\",\"阴\",\"29\",\"东南风\",\"微风\",\"04:44\"],\"night\":[\"2\",\"阴\",\"21\",\"东南风\",\"微风\",\"19:40\"]},\"week\":\"六\",\"nongli\":\"五月初五\"},{\"date\":\"2015-06-21\",\"info\":{\"dawn\":[\"2\",\"阴\",\"21\",\"东南风\",\"微风\",\"19:40\"],\"day\":[\"1\",\"多云\",\"31\",\"东南风\",\"微风\",\"04:45\"],\"night\":[\"1\",\"多云\",\"21\",\"\",\"微风\",\"19:40\"]},\"week\":\"日\",\"nongli\":\"五月初六\"}],\"pm25\":{\"key\":\"Tianjin\",\"show_desc\":0,\"pm25\":{\"curPm\":\"142\",\"pm25\":\"108\",\"pm10\":\"114\",\"level\":3,\"quality\":\"轻度污染\",\"des\":\"轻微污染 易感人群症状有轻度加剧，健康人群出现刺激症状 心脏病和呼吸系统疾病患者应减少体力消耗和户外活动。\"},\"dateTime\":\"2015年06月15日08时\",\"cityName\":\"天津\"},\"jingqu\":\"\",\"date\":null,\"isForeign\":0}},\"error_code\":0}";
		JSONObject ob = JSONObject.parseObject(test);
		System.out.println(0 == Integer.parseInt(ob.get("error_code").toString()));
		String jsonWeather = ob.getJSONObject("result").getJSONObject("data").getJSONObject("realtime").toJSONString();
		WeatherRealtime weatherRealtime = JSONObject.parseObject(jsonWeather,WeatherRealtime.class);
		String jsonInfoWeather = ob.getJSONObject("result").getJSONObject("data").getJSONArray("weather").toJSONString();
		List<WeatherInfo> weas = JSONObject.parseArray(jsonInfoWeather, WeatherInfo.class);
		StringBuffer buffer = new StringBuffer();
		buffer.append(weatherRealtime.getCity_name() + "  " + weatherRealtime.getDate());
		buffer.append("\n");
		buffer.append("  星期" + weatherRealtime.getWeek());
		buffer.append("  农历" + weatherRealtime.getMoon());
		buffer.append("\n");
		buffer.append("  " + weatherRealtime.getWeather().getInfo());
		buffer.append("  气温" + weatherRealtime.getWeather().getTemperature()+"°");
		buffer.append("\n");
		buffer.append("  湿度" + weatherRealtime.getWeather().getHumidity()+"%");
		buffer.append(" " + weatherRealtime.getWind().getDirect()+"  "
				+ weatherRealtime.getWind().getPower());
		buffer.append("\n");
		buffer.append("\n");
		if(null != weas && weas.size() > 0){
			buffer.append("一周气温");
			buffer.append("\n");
			for (int i = 0 ; i < weas.size() ; i++) {
				//buffer.append("  " +weas.get(i).getDate());
				//buffer.append("\n");
				buffer.append("  星期" + weas.get(i).getWeek());
				buffer.append("  农历" + weas.get(i).getNongli());
				buffer.append("\n");
				buffer.append("  白天 " + weas.get(i).getInfo().getDay().get(1)
						+ " 气温" + weas.get(i).getInfo().getDay().get(2)+"%");
				buffer.append("\n");
				buffer.append("  夜间 " + weas.get(i).getInfo().getNight().get(1)
						+ " 气温" + weas.get(i).getInfo().getNight().get(2)+"%");
				buffer.append("\n");
				buffer.append("\n");
			} 
		}
		System.out.println(buffer.toString());*/
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

