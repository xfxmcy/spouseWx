/**
 * WearherTimeInfo.java
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
import java.util.List;

/**
 * ClassName:WearherTimeInfo
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   cy
 * @version  
 * @since    Ver 1.1
 * @Date	 2015年6月15日		上午11:15:38
 *
 * @see 	 
 */
public class WearherTimeInfo  implements Serializable{
	
	private List<String> dawn,day,night;
	
	public List<String> getNight() {
		return night;
	}

	public void setNight(List<String> night) {
		this.night = night;
	}

	public WearherTimeInfo() {

		// TODO Auto-generated constructor stub

	}

	public List<String> getDawn() {
		return dawn;
	}

	public void setDawn(List<String> dawn) {
		this.dawn = dawn;
	}

	public List<String> getDay() {
		return day;
	}

	public void setDay(List<String> day) {
		this.day = day;
	}
	
	
}

