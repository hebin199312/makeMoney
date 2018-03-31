package com.hb.usersService.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.common.HRResult;
import com.hb.entity.Users;
import com.hb.entity.UsersExample;
import com.hb.entity.UsersExample.Criteria;
import com.hb.mapper.UsersMapper;
import com.hb.usersService.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersMapper mapper;
	
	/**
	 *  注册
	 *@author: hebin
	 *@date:2018年3月29日
	 */
	public HRResult reg(Users users) {
		//补全属性
		users.setStatus(0); //用户状态 0 正常 1冻结
		Date date=new Date();
		users.setStarttime(date); //注册时间
		users.setMoney(0.0);//余额
		users.setUserip("192.168.1.1");//用户ip
		int count= mapper.insertSelective(users);
		if (count!=1) {
			return new HRResult(201,"注册失败",null);
		}
		return	new HRResult(200, "注册成功", users);
	}
	
	/**
	 * 注册时查询用户是否已被注册
	 * @author hebin
	 * @date 2018年3月30日
	 */
	public HRResult findUsersName(String usersName) {
		UsersExample example=new UsersExample();
		Criteria ct=example.createCriteria();
		ct.andUsernameEqualTo(usersName);
		List<Users> list=mapper.selectByExample(example);
		if (list.size()>0) {
			return	new HRResult(202, "该用户已被注册", null);
		}
		return	new HRResult(200, "用户名正确", null);
	}
	
	/**
	 * 登录
	 * @author hebin
	 * @date 2018年3月30日
	 */
	@Override
	public HRResult login(Users users) {
		UsersExample example =new UsersExample();
		Criteria ct=example.createCriteria();
		ct.andUsernameEqualTo(users.getUsername());
		ct.andPasswordEqualTo(users.getPassword());
		List<Users> list=mapper.selectByExample(example);
		if (list.size()>0) {
			return new HRResult(200, "登录成功", users);
		}
		return new HRResult(203, "用户名或密码错误", null);
	}
}
