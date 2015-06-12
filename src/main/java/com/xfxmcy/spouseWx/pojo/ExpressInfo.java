/**
 * ExpressItem.java
 * com.xfxmcy.spouseWx.pojo
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年6月11日 		cy
 *
 * Copyright (c) 2015, xfxmcy All Rights Reserved.
*/

package com.xfxmcy.spouseWx.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName:ExpressItem
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   cy
 * @version  
 * @since    Ver 1.1
 * @Date	 2015年6月11日		下午5:28:05
 *
 * @see 	 
 */
public class ExpressInfo implements Serializable{

	private String company;
	private String com;
	private String  no ;
	private String status ;
	private List<ExpressItem> list ;
	
	@Override
	public String toString() {
		return "ExpressInfo [company=" + company + ", com=" + com + ", no="
				+ no + ", status=" + status + ", list=" + list + "]";
	}

	public ExpressInfo() {

		// TODO Auto-generated constructor stub

	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ExpressItem> getList() {
		return list;
	}

	public void setList(List<ExpressItem> list) {
		this.list = list;
	}
	
	
}

