/**
 * WeatherRealtime.java
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
 * ClassName:WeatherRealtime
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   cy
 * @version  
 * @since    Ver 1.1
 * @Date	 2015年6月15日		上午10:57:31
 *
 * @see 	 
 */
public class WeatherRealtime  implements Serializable {
	
	public WeatherRealtime() {

		// TODO Auto-generated constructor stub

	}
	private String city_code,city_name,date,time,week,moon,dataUptime;
	
	private WeatherRealtime_weather weather ;
	
	private WeatherRealtime_wind wind ;

	public String getCity_code() {
		return city_code;
	}

	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getMoon() {
		return moon;
	}

	public void setMoon(String moon) {
		this.moon = moon;
	}

	public String getDataUptime() {
		return dataUptime;
	}

	public void setDataUptime(String dataUptime) {
		this.dataUptime = dataUptime;
	}

	public WeatherRealtime_weather getWeather() {
		return weather;
	}

	public void setWeather(WeatherRealtime_weather weather) {
		this.weather = weather;
	}

	public WeatherRealtime_wind getWind() {
		return wind;
	}

	public void setWind(WeatherRealtime_wind wind) {
		this.wind = wind;
	}
	
}

