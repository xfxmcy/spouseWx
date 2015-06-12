/**
 * WxCoreController.java
 * com.xfxmcy.spouseWx.controller
 *
 * Function： wx core controller 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年5月8日 		cy
 *
 * Copyright (c) 2015, xfxmcy All Rights Reserved.
*/

package com.xfxmcy.spouseWx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xfxmcy.spouseWx.service.WxCoreService;
import com.xfxmcy.spouseWx.util.LoggerWx;
import com.xfxmcy.spouseWx.util.MessageUtil;
import com.xfxmcy.spouseWx.util.WxValidateTool;


/**
 * ClassName:WxCoreController
 * Function: wx core controller
 * Reason:	 wx core controller
 *
 * @author   cy
 * @version  
 * @since    Ver 1.1
 * @Date	 2015年5月8日		上午11:02:03
 *
 * @see 	 
 */
@Controller
@RequestMapping("/wxCore")
public class WxCoreController {
	
	
	@Resource       
	private WxValidateTool wxValidateTool;
	
	@Resource
	private WxCoreService wxCoreServiceImpl;
	/**
	 * 
	 * validateWxCore:微信接入认证
	 *
	 * @param request
	 * @param response
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2015年5月8日 		cy
	 */
	@RequestMapping(value = "/wxCore",method = RequestMethod.GET)
	public void validateWxCore(HttpServletRequest request ,HttpServletResponse response ,
			String timestamp , String nonce , String echostr , String signature) {
		/*
		 *  1. 将token、timestamp、nonce三个参数进行字典序排序
			2. 将三个参数字符串拼接成一个字符串进行sha1加密
			3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		 * */
		/*String timeStamp = request.getParameter("timestamp");
		String nonece = request.getParameter("nonce");
		String echoStr = request.getParameter("echostr");
		String signature = request.getParameter("signature");*/
		if(null == timestamp || "".equals(timestamp.trim()) ||
				null == nonce || "".equals(nonce.trim()) ||
				null == echostr || "".equals(echostr.trim()) ||
				null == signature || "".equals(signature.trim()))
			return ;
		PrintWriter out = null ;
		try {
			out = response.getWriter();
			if(wxValidateTool.validateRequest(signature,timestamp,nonce))
				out.print(echostr);
		} catch (IOException e) {
			LoggerWx.loggingWx(e);
		}finally{
			if(null != out)
				out.close();
		}
		
	}
	/**
	 * 
	 * xfxmcyWxCore: 业务核心处理
	 *
	 * @param request
	 * @param response
	 *   ver     date      		author
	 * ──────────────────────────────────
	 *   		 2015年5月8日 		cy
	 */
	@RequestMapping(value = "/wxCore",method = RequestMethod.POST)
	public void xfxmcyWxCore(HttpServletRequest request ,HttpServletResponse response) {
		PrintWriter out = null ;
		try {
			out = response.getWriter();
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			String result = wxCoreServiceImpl.disposeWxBusiness(requestMap);
			if(null != result && !"".equals(result))
				out.print(result);
		} catch (Exception e) {
			LoggerWx.loggingWx(e);
		}finally{
			if(null != out)
				out.close();
		}
		
	}
	
}

