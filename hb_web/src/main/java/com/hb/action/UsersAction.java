package com.hb.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.common.HRResult;
import com.hb.entity.Users;
import com.hb.usersService.UsersService;

@Controller
/*@RequestMapping("/user/*")*/
public class UsersAction {
	
	@Autowired
	private UsersService usersService;
	
	/**
	 * 注册
	 *@author: hebin
	 *@date:2018年3月29日
	 */
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	@ResponseBody
	public HRResult reg(Users users) {
		return usersService.reg(users);
	}
	
	/**
	 * 查询该用户是否被注册
	 *@author: hebin
	 *@date:2018年3月30日
	 */
	@RequestMapping(value="/findUsersName")
	@ResponseBody
	public HRResult findUsersName(@RequestParam String username) {
		return usersService.findUsersName(username);
	}
	
	/**
	 * 登录
	 *@author: hebin
	 *@date:2018年3月30日,method=RequestMethod.POST
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody HRResult login(Users users,HttpSession session) {
		System.out.println(users.getUsername());
		HRResult result=usersService.login(users);
		session.setAttribute("users", result.getData());
		return result;
	}
}
