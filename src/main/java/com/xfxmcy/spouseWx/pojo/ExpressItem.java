/**
 * ExpressItem.java
 * com.xfxmcy.spouseWx.pojo
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年6月12日 		cy
 *
 * Copyright (c) 2015, xfxmcy All Rights Reserved.
*/

package com.xfxmcy.spouseWx.pojo;
/**
 * ClassName:ExpressItem
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   cy
 * @version  
 * @since    Ver 1.1
 * @Date	 2015年6月12日		上午9:59:27
 *
 * @see 	 
 */
public class ExpressItem {
	
	private String datetime ;
	
	private String remark;
	
	private String zone ;
	
	@Override
	public String toString() {
		return "ExpressItem [datetime=" + datetime + ", remark=" + remark
				+ ", zone=" + zone + "]";
	}
	public ExpressItem() {

		// TODO Auto-generated constructor stub

	}
	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
	
	
}

