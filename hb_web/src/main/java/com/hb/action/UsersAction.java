package com.hb.action;

import java.util.List;
import java.util.Random;

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

import com.alibaba.fastjson.JSON;
import com.hb.common.ChuangLanSmsUtil;
import com.hb.common.HRResult;
import com.hb.common.SmsSendRequest;
import com.hb.common.SmsSendResponse;
import com.hb.entity.Users;
import com.hb.usersService.UsersService;

@Controller
/* @RequestMapping("/user/*") */
public class UsersAction {

	@Autowired
	private UsersService usersService;
	public static final String charset = "utf-8";
	// 用户平台API账号(非登录账号,示例:N1234567)
	public static String account = "N2382077";
	// 用户平台API密码(非登录密码)
	public static String pswd = "zzx123456";

	/**
	 * 注册
	 * 
	 * @author: hebin
	 * @date:2018年3月29日
	 */
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	@ResponseBody
	public HRResult reg(Users users) {
		System.out.println(users.getUsername()+"====================");
		return usersService.reg(users);
	}

	/**
	 * 查询该用户是否被注册
	 * 
	 * @author: hebin
	 * @date:2018年3月30日
	 */
	@RequestMapping(value = "/findUsersName")
	@ResponseBody
	public HRResult findUsersName(@RequestParam String username) {
		return usersService.findUsersName(username);
	}

	/**
	 * 登录
	 * 
	 * @author: hebin
	 * @date:2018年3月30日,method=RequestMethod.POST
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody HRResult login(Users users, HttpSession session) {
		System.out.println(users.getUsername());
		HRResult result = usersService.login(users);
		session.setAttribute("users", result.getData());
		return result;
	}

	// 退出登录
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();// 清除session
		return "login";
	}
	// 短信验证

	@RequestMapping("/proving")
	@ResponseBody
	public  HRResult proving(String phone1) {
			// 请求地址请登录253云通讯自助通平台查看或者询问您的商务负责人获取
			String smsSingleRequestServerUrl = "http://smssh1.253.com/msg/send/json";
			// 返回的验证码
			String proving = String.valueOf(new Random().nextInt(899999) + 100000);
			// 短信内容
			String msg = "【MakeMoney】您好，欢迎使用MakeMoney平台，您的手机验证码是："+ proving+"，若非本人操作，请忽略！" ;
			// 手机号码
			String phone = phone1;
			// 状态报告
			String report = "true";

			SmsSendRequest smsSingleRequest = new SmsSendRequest(account, pswd, msg, phone, report);

			String requestJson = JSON.toJSONString(smsSingleRequest);

			System.out.println("before request string is: " + requestJson);

			String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

			System.out.println("response after request result is :" + response);

			SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

			System.out.println("response  toString is :" + smsSingleResponse);
			if (smsSingleResponse.getCode().equals("0") ) {
				return new HRResult(200, "获取验证码成功", proving);
			} else {
				return new HRResult(204, "获取验证码失败", smsSingleResponse.getErrorMsg());
			}
	}
}
