package com.hb.usersService;

import com.hb.common.HRResult;
import com.hb.entity.Users;

/**
 * �û��ӿ�
 * 
 * @author hebin
 * @date 2018��3��29��
 */
public interface UsersService {
	/**
	 * ע��
	 *@author: hebin
	 *@date:2018��3��29��
	 */
	HRResult reg(Users users);
	
	/**
	 * ע��ʱ�ж��û��治����
	 *@author: hebin
	 *@date:2018��3��29��
	 */
	HRResult findUsersName(String usersName);
	
	/**
	 * ��¼
	 *@author: hebin
	 *@date:2018��3��30��
	 */
	HRResult login(Users users);
}
