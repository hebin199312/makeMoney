package com.hb.common;
/**
 * 
 * @author tianyh 
 * @Description:æ®é?ç­ä¿¡åéååºå®ä½ç±»
 */
public class SmsSendResponse {
	/**
	 * ååºæ¶é´
	 */
	private String time;
	/**
	 * æ¶æ¯id
	 */
	private String msgId;
	/**
	 * ç¶æ?ç è¯´æï¼æåè¿åç©ºï¼?
	 */
	private String errorMsg;
	/**
	 * ç¶æ?ç ï¼è¯¦ç»åèæäº¤ååºç¶æç ï¼?
	 */
	private String code;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "SmsSingleResponse [time=" + time + ", msgId=" + msgId + ", errorMsg=" + errorMsg + ", code=" + code
				+ "]";
	}
	
	
	

}
