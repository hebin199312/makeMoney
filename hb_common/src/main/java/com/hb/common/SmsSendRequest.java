package com.hb.common;
/**
 * 
 * @author tianyh 
 * @Description:普�?�短信发送实体类
 */
public class SmsSendRequest {
	/**
	 * 用户账号，必�?
	 */
	private String account;
	/**
	 * 用户密码，必�?
	 */
	private String password;
	/**
	 * 短信内容。长度不能超�?536个字符，必填
	 */
	private String msg;
	/**
	 * 机号码�?�多个手机号码使用英文�?�号分隔，必�?
	 */
	private String phone;
	
	
	/**
	 * 定时发�?�短信时间�?�格式为yyyyMMddHHmm，�?�小于或等于当前时间则立即发送，默认立即发�?�，选填
	 */
	private String sendtime;
	/**
	 * 是否�?要状态报告（默认false），选填
	 */
	private String report;
	/**
	 * 下发短信号码扩展码，纯数字，建议1-3位，选填
	 */
	private String extend;
	/**
	 * 该条短信在您业务系统内的ID，如订单号或者短信发送记录流水号，�?�填
	 */
	private String uid;
	
	public SmsSendRequest() {
		
	}
	public SmsSendRequest(String account, String password, String msg, String phone) {
		super();
		this.account = account;
		this.password = password;
		this.msg = msg;
		this.phone = phone;
	}
	public SmsSendRequest(String account, String password, String msg, String phone, String report) {
		super();
		this.account = account;
		this.password = password;
		this.msg = msg;
		this.phone = phone;
		this.report=report;
	}
	
	public SmsSendRequest(String account, String password, String msg, String phone, String report,String sendtime) {
		super();
		this.account = account;
		this.password = password;
		this.msg = msg;
		this.phone = phone;
		this.sendtime=sendtime;
		this.report=report;
	}
	public SmsSendRequest(String account, String password, String msg, String phone, String sendtime,String report,String uid) {
		super();
		this.account = account;
		this.password = password;
		this.msg = msg;
		this.phone = phone;
		this.sendtime=sendtime;
		this.report=report;
		this.uid=uid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public String getExtend() {
		return extend;
	}
	public void setExtend(String extend) {
		this.extend = extend;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	
}
