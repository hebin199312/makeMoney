package com.hb.common;

//ajax �쳣�����ؽ����
public class HRResult {
	//������ 200��ȷ ��������
	private int resultCode;	
	//������Ϣ
	private String resultMsg;
	//���صĽ����
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
