package com.hb.common;

//ajax 异常处理返回结果集
public class HRResult {
	//错误码 200正确 其他错误
	private int resultCode;	
	//错误信息
	private String resultMsg;
	//返回的结果集
	private Object data;
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public HRResult() {
		// TODO Auto-generated constructor stub
	}
	public HRResult(int resultCode, String resultMsg, Object data) {
		super();
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.data = data;
	}
	
}
