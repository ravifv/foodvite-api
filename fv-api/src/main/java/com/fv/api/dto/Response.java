package com.fv.api.dto;

public class Response {
	private boolean isSuccess; 
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	private String resultCode; 
	private String msg; 
	private String title; 
	
    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
