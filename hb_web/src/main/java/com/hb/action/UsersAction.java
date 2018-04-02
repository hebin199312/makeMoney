package com.hb.action;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	// �û�ƽ̨API�˺�(�ǵ�¼�˺�,ʾ��:N1234567)
	public static String account = "N2382077";
	// �û�ƽ̨API����(�ǵ�¼����)
	public static String pswd = "zzx123456";

	/**
	 * ע��
	 *@author: hebin
	 *@date:2018��3��29��
	 */
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	@ResponseBody
	public HRResult reg(Users users) {
		System.out.println(users.getUsername()+"====================");
		return usersService.reg(users);
	}

	/**
	 * ��ѯ���û��Ƿ�ע��
	 *@author: hebin
	 *@date:2018��3��30��
	 */
	@RequestMapping(value = "/findUsersName")
	@ResponseBody
	public HRResult findUsersName(@RequestParam String username) {
		return usersService.findUsersName(username);
	}

	/**

	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody HRResult login(Users users, HttpSession session) {
		System.out.println(users.getUsername());
		HRResult result = usersService.login(users);
		session.setAttribute("users", result.getData());
		return result;
	}


	@RequestMapping("/proving")
	@ResponseBody
	public  HRResult proving(String phone1) {
			// �����ַ���¼253��ͨѶ����ͨƽ̨�鿴����ѯ�������������˻�ȡ
			String smsSingleRequestServerUrl = "http://smssh1.253.com/msg/send/json";
			// ���ص���֤��
			String proving = String.valueOf(new Random().nextInt(899999) + 100000);
			// ��������
			String msg = "��MakeMoney�����ã���ӭʹ��MakeMoneyƽ̨�������ֻ���֤���ǣ�"+ proving+"�����Ǳ��˲���������ԣ�" ;
			// �ֻ�����
			String phone = phone1;
			// ״̬����
			String report = "true";

			SmsSendRequest smsSingleRequest = new SmsSendRequest(account, pswd, msg, phone, report);

			String requestJson = JSON.toJSONString(smsSingleRequest);

			System.out.println("before request string is: " + requestJson);

			String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

			System.out.println("response after request result is :" + response);

			SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

			System.out.println("response  toString is :" + smsSingleResponse);
			if (smsSingleResponse.getCode().equals("0") ) {
				return new HRResult(200, "��ȡ��֤��ɹ�", proving);
			} else {
				return new HRResult(204, "��ȡ��֤��ʧ��", smsSingleResponse.getErrorMsg());
			}
	}
}
