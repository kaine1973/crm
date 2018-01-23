package com.shsxt.crm.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {

	@ModelAttribute
	public void preMethod(HttpServletRequest request) {
		request.setAttribute("ctx", request.getContextPath());
	}
	
}
