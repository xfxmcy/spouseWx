/**
 * WxCoreServiceImpl.java
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

package com.xfxmcy.spouseWx.service.impl;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.xfxmcy.spouseWx.message.util.Article;
import com.xfxmcy.spouseWx.message.util.NewsMessage;
import com.xfxmcy.spouseWx.message.util.TextMessage;
import com.xfxmcy.spouseWx.pojo.Express;
import com.xfxmcy.spouseWx.pojo.ExpressInfo;
import com.xfxmcy.spouseWx.pojo.ExpressItem;
import com.xfxmcy.spouseWx.pojo.WeatherInfo;
import com.xfxmcy.spouseWx.pojo.WeatherRealtime;
import com.xfxmcy.spouseWx.service.WxCoreService;
import com.xfxmcy.spouseWx.util.HttpRequestUtil;
import com.xfxmcy.spouseWx.util.LoggerWx;
import com.xfxmcy.spouseWx.util.MessageTemplate;
import com.xfxmcy.spouseWx.util.MessageUtil;
import com.xfxmcy.spouseWx.util.ResourceUtil;
import com.xfxmcy.spouseWx.wsdl.photo.PhotoWService;
import com.xfxmcy.spouseWx.wsdl.photo.QueryParam;
import com.xfxmcy.spouseWx.wsdl.photo.SmPhotoArray;

/**
 * ClassName:WxCoreServiceImpl
 * Function: implement of coreService
 * Reason:	 implement of coreService
 *
 * @author   cy
 * @version  
 * @since    Ver 1.1
 * @Date	 2015年5月8日		下午2:17:36
 *
 * @see 	 
 */
@Service
public class WxCoreServiceImpl implements WxCoreService {

	@Resource	
	private PhotoWService photoWService ;
	
	@Override
	public String disposeWxBusiness(Map<String, String> requestMap) {
		// xml格式的返回消息数据
		String respXml = null;
		// 接受信息
		TextMessage textMessage = null;
		// 发送方帐号
		String fromUserName = requestMap.get("FromUserName");
		// 开发者微信号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");
		LoggerWx.debugInfo("发送方  openId___" + fromUserName);
		textMessage = new TextMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		// 事件推送
		if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
			// 事件类型
			String eventType = requestMap.get("Event");
			// 订阅
			if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
				textMessage.setContent("您好，欢迎关注xfxmcy！我们的官网  xfxmcy.com \n"
						+ "请输入 ? 查看帮助");
			}
			// 取消订阅
			else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
				// TODO 暂不做处理
			}
			// 自定义菜单点击事件
			else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
				// 事件KEY值，与创建菜单时的key值对应
				String eventKey = requestMap.get("EventKey");
				// 根据key值判断用户点击的按钮
				if (eventKey.equals("oschina")) {
					
				} else if (eventKey.equals("iteye")) {
					
				}
			}
		
		
		}
		// 当用户发消息
		else {
			String content = requestMap.get("Content").trim();
			/*主菜单*/	
			if(null != content && ("?".equals(content.trim()) || "？".equals(content.trim())) ){
				//o6zxSt8G_DbKZZo7QS1fBd4MVJ2g  cy
				textMessage.setContent(MessageTemplate.getMainMenu());
			}
			/*空输入*/
			else if(null == content || "".equals(content.trim())){
				textMessage.setContent("您什么都没有输入啊... 可输入 	 ?  查看帮助");
			}
			/*天气预报*/
			else if(null != content && "1".equals(content.trim())){
				textMessage.setContent("请输入  天气 ,城市！\n"
						+ "eg : 天气,天津");
			}
			/*快递查询*/
			else if(null != content && "0".equals(content.trim())){
				textMessage.setContent("请输入  快递 ,快递公司,快递单号！\n"
						+ "目前支持  EMS、圆通、顺丰、申通、中通、韵达、天天 \n"
						+ "eg : 快递,顺丰,892793871298");
			}
			/*照片查询*/
			else if(null != content && "3".equals(content.trim())){
				
				return photoWeb(content,fromUserName,toUserName);
			}
			else if("主页".equals(content)){
				return indexWeb(content,fromUserName,toUserName);
			}
			
			else{
				String[] orders = content.split(",");
				String[] ordersSecond = content.split("，");
				if(orders.length == 3 && "快递".equals(orders[0])){
					String message = expressWeb(orders,fromUserName,toUserName);
					textMessage.setContent(message);
				}
				else if(ordersSecond.length == 3 && "快递".equals(ordersSecond[0])){
					String message = expressWeb(ordersSecond,fromUserName,toUserName);
					textMessage.setContent(message);
				}
				else if(orders.length == 2 && "天气".equals(orders[0])){
					String message = expressWeb(orders,fromUserName,toUserName);
					textMessage.setContent(message);
				}
				else if(ordersSecond.length == 2 && "天气".equals(ordersSecond[0])){
					String message = weatherWeb(ordersSecond,fromUserName,toUserName);
					textMessage.setContent(message);
				}
				else
					textMessage.setContent(content + "输入错误 	 可输入 	 ?  查看帮助 ");
			}
			respXml = MessageUtil.messageToXml(textMessage);
			return respXml;
		}
		// 将消息对象转换成xml
		respXml = MessageUtil.messageToXml(textMessage);
		return respXml;

	}
	
	/**
	 * 
	 * photoWeb:(这里用一句话描述这个方法的作用)
	 *
	 * @param content
	 * @param fromUserName
	 * @param toUserName
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2015年6月19日 		cy
	 */
	private String photoWeb(String content, String fromUserName,
			String toUserName) {
		QueryParam param = new QueryParam();
		param.setQueryType("queryOnBG");
		param.setOwner("cy");
		SmPhotoArray list = photoWService.queryMyPhotos(param);
		if(null != list && !list.getItem().isEmpty()){
			LoggerWx.debugInfo("changdu  wei ___" + list.getItem().size());
			Article article = null ;
			List<Article> articleList = new ArrayList<Article>();
			/*list.getItem()*/
			for (int i = 0; i < list.getItem().size(); i++) {
				article = new Article();
				article.setTitle(list.getItem().get(i).getTitle());
				article.setDescription(list.getItem().get(i).getTitle());
				article.setPicUrl(ResourceUtil.getXfxmcyPhotoPrefix() + list.getItem().get(i).getUrl());
				//article.setUrl("http://resource.tjise.edu.cn/spouseWx/index.jsp");
				article.setUrl("http://xfxmcy.com/spouse/managerment/cyPhoto.do");
				articleList.add(article);
			}
			
			
			
			
			
			
			
			// 创建图文消息
			NewsMessage newsMessage = new NewsMessage();
			newsMessage.setToUserName(fromUserName);
			newsMessage.setFromUserName(toUserName);
			newsMessage.setCreateTime(new Date().getTime());
			newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
			newsMessage.setArticleCount(articleList.size());
			newsMessage.setArticles(articleList);
			return  MessageUtil.messageToXml(newsMessage);
		}else{
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setContent("暂无图片...");
			return  MessageUtil.messageToXml(textMessage);
		}
		
	}
	/*String content = requestMap.get("Content").trim();
	LoggerWx.debugInfo("发送方__"+ fromUserName + "开发方__" +toUserName + "发送内容__" + content);
	Article article = new Article();
	article.setTitle("xfxmcy");
	article.setDescription("xfxmcy.com  一个家庭网站" + content);
	article.setPicUrl("http://xfxmcy.com/images/lin.jpg");
	article.setUrl("http://xfxmcy.com");
	List<Article> articleList = new ArrayList<Article>();
	articleList.add(article);
	// 创建图文消息
	NewsMessage newsMessage = new NewsMessage();
	newsMessage.setToUserName(fromUserName);
	newsMessage.setFromUserName(toUserName);
	newsMessage.setCreateTime(new Date().getTime());
	newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
	newsMessage.setArticleCount(articleList.size());
	newsMessage.setArticles(articleList);
	respXml = MessageUtil.messageToXml(newsMessage);*/
	/**
	 * 
	 * expressWeb:快递业务处理
	 *
	 * @param orders
	 * @param fromUserName
	 * @param toUserName
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2015年6月11日 		cy
	 */
	private String expressWeb(String[] orders, String fromUserName,
			String toUserName) {
		String company = orders[1].trim();
		if("EMS".equalsIgnoreCase(company))
			company = "EMS" ;
		String companyCode = ResourceUtil.getExpressCompanyCode(company);
		if(company == null && null == companyCode){
			return "请输入我们支持的快递公司...\n目前支持  EMS、圆通、顺丰、申通、中通、韵达、天天 ";
		}
		StringBuffer buffer = new StringBuffer();
		String waybillNumber = orders[2].trim();
		StringBuffer sb = new StringBuffer(HttpRequestUtil.EXPRESS_URL_JUHE);
		sb.append("&com=" + companyCode);
		sb.append("&no=" + waybillNumber);
		try{ 
			String result = HttpRequestUtil.httpRequest(sb.toString());
			Express express = JSONObject.parseObject(result, Express.class);
			if("200".equals(express.getResultcode())){
				buffer = new StringBuffer();
				ExpressInfo info = express.getResult();
				if(null != info){
					List<ExpressItem> items = info.getList();
					Collections.reverse(items);			
					if(null != items && items.size() > 0){
						
						for (int i = 0; i < items.size(); i++) {
							buffer.append(  items.get(i).getDatetime());
							buffer.append("\n");
							buffer.append("" + items.get(i).getRemark());
							buffer.append("\n\n");
						}
					}
					else
						return "暂无信息...请稍后查询";
						
				}else
					return "暂无信息...请稍后查询";
			}
			else {
				return "系统访问异常...请稍后查询\n"
						+ "请查看输入信息是否正确 如运单号";
			}
			
		}catch(Exception e){
			LoggerWx.loggingWx(e);
			return "系统暂停服务...请联系管理员";
		}
		return buffer.toString();
		
	}
	/**
	 * 
	 * expressWeb:天气预报
	 *
	 * @param orders
	 * @param fromUserName
	 * @param toUserName
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2015年6月15日 		cy
	 */
	private String weatherWeb(String[] orders, String fromUserName,
			String toUserName) {
		String city = orders[1].trim();
		StringBuffer buffer = new StringBuffer();
		StringBuffer sb = new StringBuffer(HttpRequestUtil.WEATHER_URL_JUHE);
		
		try{ 
			city = URLEncoder.encode(city, "utf-8");
			sb.append("&cityname=" + city);
			String result = HttpRequestUtil.httpRequest(sb.toString());
			JSONObject obResult = JSONObject.parseObject(result);
			if("0".equals(obResult.get("error_code")) || 0 == Integer.parseInt(obResult.get("error_code").toString())){
				buffer = new StringBuffer();
				String jsonWeather = obResult.getJSONObject("result").getJSONObject("data").getJSONObject("realtime").toJSONString();
				WeatherRealtime weatherRealtime = JSONObject.parseObject(jsonWeather,WeatherRealtime.class);
				String jsonInfoWeather = obResult.getJSONObject("result").getJSONObject("data").getJSONArray("weather").toJSONString();
				List<WeatherInfo> weas = JSONObject.parseArray(jsonInfoWeather, WeatherInfo.class);
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
			}
			else {
				return "系统访问异常...\n"
						+ obResult.get("reason");
			}
			
		}catch(Exception e){
			LoggerWx.loggingWx(e);
			return "系统暂停服务...请联系管理员";
		}
		return buffer.toString();
		
	}
	/**
	 * 
	 * indexWeb: introduce index web
	 *
	 * @param content
	 * @return
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2015年6月11日 		cy
	 */
	private String indexWeb(String content,String fromUserName,String toUserName){
		Article article = new Article();
		article.setTitle("xfxmcy");
		article.setDescription("xfxmcy.com  一个家庭网站" + content);
		article.setPicUrl("http://xfxmcy.com/images/lin.jpg");
		//article.setUrl("http://resource.tjise.edu.cn/spouseWx/index.jsp");
		article.setUrl("http://xfxmcy.com/");
		List<Article> articleList = new ArrayList<Article>();
		articleList.add(article);
		// 创建图文消息
		NewsMessage newsMessage = new NewsMessage();
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
		newsMessage.setArticleCount(articleList.size());
		newsMessage.setArticles(articleList);
		return  MessageUtil.messageToXml(newsMessage);
		//response.sendRedirect("http://resource.tjise.edu.cn/spouseWx/index.jsp");
	}
}

