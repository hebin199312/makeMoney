package com.hb.common;
/**
 * 
 * @author tianyh 
 * @Description:普�?�短信发送响应实体类
 */
public class SmsSendResponse {
	/**
	 * 响应时间
	 */
	private String time;
	/**
	 * 消息id
	 */
	private String msgId;
	/**
	 * 状�?�码说明（成功返回空�?
	 */
	private String errorMsg;
	/**
	 * 状�?�码（详细参考提交响应状态码�?
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
