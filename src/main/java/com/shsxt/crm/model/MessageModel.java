package com.shsxt.crm.model;

import com.shsxt.crm.base.CrmConstant;

public class MessageModel {
	
	public Integer code = CrmConstant.DEFAULT_SUCCESS_CODE;
	public String msg = CrmConstant.DEFAULT_SUCCESS_MSG;
	
	public Object result;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public MessageModel() {
	}

	public MessageModel(Integer code, String msg, Object result) {
		this.code = code;
		this.msg = msg;
		this.result = result;
	}
	
	
	
	
	
}
