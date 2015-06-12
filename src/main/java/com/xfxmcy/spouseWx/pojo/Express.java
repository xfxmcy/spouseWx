/**
 * Express.java
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
 * ClassName:Express
 * Function: express
 * Reason:	 express
 *
 * @author   cy
 * @version  
 * @since    Ver 1.1
 * @Date	 2015年6月11日		下午4:50:26
 *
 * @see 	 
 */
public class Express implements Serializable{
	
	public Express() {

		// TODO Auto-generated constructor stub

	}
	
	@Override
	public String toString() {
		return "Express [resultcode=" + resultcode + ", reason=" + reason
				+ ", result=" + result + ", error_code=" + error_code + "]";
	}

	private String resultcode = null ;
	
	private String reason  = null  ;
	
	private ExpressInfo  result ;
	
	private String error_code = null ;

	public String getResultcode() {
		return resultcode;
	}

	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public ExpressInfo getResult() {
		return result;
	}

	public void setResult(ExpressInfo result) {
		this.result = result;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	
}

