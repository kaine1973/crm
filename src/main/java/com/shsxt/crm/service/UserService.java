package com.shsxt.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shsxt.crm.dao.UserDao;
import com.shsxt.crm.model.UserModel;
import com.shsxt.crm.util.AssertUtil;
import com.shsxt.crm.util.Md5Util;
import com.shsxt.crm.vo.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	
	public UserModel userLogin(String userName, String userPwd) {
		AssertUtil.isTrue(StringUtils.isEmpty(userName), "用户名不能为空");
		AssertUtil.isTrue(StringUtils.isEmpty(userPwd), "密码不能为空");
		User user = userDao.queryUserByName(userName);
		AssertUtil.isTrue(user==null, "该用户不存在");
		AssertUtil.isTrue("0".equals(user.getIsValid()), "用户已被冻结");
		String encypt = Md5Util.encypt(userPwd);
		AssertUtil.isTrue(user.getUserPwd()!=encypt, "密码错误");
		return createUserModel(user);
		
	}
	
	public UserModel createUserModel(User user) {
		UserModel um = new UserModel();
		um.setUserId(user.getId());
		um.setUserName(user.getUserName());
		um.setTrueName(user.getTrueName());
		return um;
	}

}
