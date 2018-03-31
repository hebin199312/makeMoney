package com.hb.common;

public class AppException extends RuntimeException {

	//200 正常  200以外不正常
		private int resultCode;
		private String resultMsg;
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
		
		public AppException() {
			// TODO Auto-generated constructor stub
		}
		public AppException(int resultCode, String resultMsg, Object data) {
			super();
			this.resultCode = resultCode;
			this.resultMsg = resultMsg;
			this.data = data;
		}
		
		
		
		
	
	
}
