package com.gkhn.wms.util;

public class JsonResult {

	private static final long serialVersionUID = 812376774103405857L;
	public static final int SUCCESS=0;
	public static final int ERROR=1;
	 
	private int state;
	 
	private Object data;
	 
	private String message;	
	
	private int count;
	
	private  int  code;
	
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public JsonResult() {
	
	}
	public JsonResult(int state, Object data, String message) {		
		this.state = state;
		this.data = data;
		this.message = message;
	}
	public JsonResult(Throwable e) {
		state=ERROR;
		data="";
		message=e.getMessage();
	}
	public JsonResult(Object data){
		state=SUCCESS;
		this.data = data;
		message="";
	}
	public JsonResult(int state,Throwable e){
		this.state=state;
		data=null;
		message=e.getMessage();
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", data=" + data + ", message=" + message + "]";
	}
	
}
