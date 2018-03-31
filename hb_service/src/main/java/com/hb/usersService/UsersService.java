package com.hb.usersService;

import com.hb.common.HRResult;
import com.hb.entity.Users;

/**
 * 用户接口
 * 
 * @author hebin
 * @date 2018年3月29日
 */
public interface UsersService {
	/**
	 * 注册
	 *@author: hebin
	 *@date:2018年3月29日
	 */
	HRResult reg(Users users);
	
	/**
	 * 注册时判断用户存不存在
	 *@author: hebin
	 *@date:2018年3月29日
	 */
	HRResult findUsersName(String usersName);
	
	/**
	 * 登录
	 *@author: hebin
	 *@date:2018年3月30日
	 */
	HRResult login(Users users);
}
