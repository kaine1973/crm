package com.shsxt.crm.util;

import com.shsxt.crm.base.CrmConstant;
import com.shsxt.crm.base.exceptions.ParamsException;

public class AssertUtil {

	public static void isTrue(Boolean flag,Integer code,String msg) {
		if(flag) {
			throw new ParamsException(code, msg);
		}
	}
	public static void isTrue(Boolean flag,String msg) {
		if(flag) {
			throw new ParamsException(CrmConstant.DEFAULT_FAIL_CODE,msg);
		}
	}
	
}
