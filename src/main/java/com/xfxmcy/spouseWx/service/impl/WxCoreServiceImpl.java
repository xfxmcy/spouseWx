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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xfxmcy.spouseWx.message.util.Article;
import com.xfxmcy.spouseWx.message.util.NewsMessage;
import com.xfxmcy.spouseWx.message.util.TextMessage;
import com.xfxmcy.spouseWx.service.WxCoreService;
import com.xfxmcy.spouseWx.util.LoggerWx;
import com.xfxmcy.spouseWx.util.MessageTemplate;
import com.xfxmcy.spouseWx.util.MessageUtil;

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
				textMessage.setContent("您好，欢迎关注xfxmcy！我们的官网  xfxmcy.com");
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
			textMessage.setContent(MessageTemplate.getMainMenu());
			respXml = MessageUtil.messageToXml(textMessage);
			return respXml;
		}
		// 将消息对象转换成xml
		respXml = MessageUtil.messageToXml(textMessage);
		return respXml;

	}

}

