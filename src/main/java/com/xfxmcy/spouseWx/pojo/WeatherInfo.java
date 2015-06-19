/**
 * WeatherInfo.java
 * com.xfxmcy.spouseWx.pojo
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年6月15日 		cy
 *
 * Copyright (c) 2015, xfxmcy All Rights Reserved.
*/

package com.xfxmcy.spouseWx.pojo;

import java.io.Serializable;

/**
 * ClassName:WeatherInfo
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   cy
 * @version  
 * @since    Ver 1.1
 * @Date	 2015年6月15日		上午11:11:38
 *
 * @see 	 
 */
public class WeatherInfo  implements Serializable{
	public WeatherInfo() {

		// TODO Auto-generated constructor stub

	}
	private String date,week,nongli;
	
	private WearherTimeInfo info;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getNongli() {
		return nongli;
	}

	public void setNongli(String nongli) {
		this.nongli = nongli;
	}

	public WearherTimeInfo getInfo() {
		return info;
	}

	public void setInfo(WearherTimeInfo info) {
		this.info = info;
	}
}

