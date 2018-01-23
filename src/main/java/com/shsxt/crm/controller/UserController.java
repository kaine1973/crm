package com.shsxt.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.crm.base.CrmConstant;
import com.shsxt.crm.base.exceptions.ParamsException;
import com.shsxt.crm.model.MessageModel;
import com.shsxt.crm.model.UserModel;
import com.shsxt.crm.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/userLogin")
	@ResponseBody
	public MessageModel userLogin(String userName,String userPwd) {
		MessageModel mm = new MessageModel();
		try {
		UserModel um = userService.userLogin(userName,userPwd);
		mm.setCode(CrmConstant.DEFAULT_SUCCESS_CODE);
		}catch(ParamsException e) {
			mm.setCode(e.getCode());
			mm.setMsg(e.getMsg());
			System.out.println(e.getMessage()+e.getStackTrace());
		}catch(Exception e) {
			mm.setCode(CrmConstant.DEFAULT_FAIL_CODE);
			mm.setMsg(CrmConstant.DEFAULT_FAIL_MSG);
			System.out.println(e.getMessage()+e.getStackTrace());
		}
		return mm;
	}
	
	
	
	
	
}
