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
	 *  ע��
	 *@author: hebin
	 *@date:2018��3��29��
	 */
	public HRResult reg(Users users) {
		//��ȫ����
		users.setStatus(0); //�û�״̬ 0 ���� 1����
		Date date=new Date();
		users.setStarttime(date); //ע��ʱ��
		users.setMoney(0.0);//���
		users.setUserip("192.168.1.1");//�û�ip
		int count= mapper.insertSelective(users);
		if (count!=1) {
			return new HRResult(201,"ע��ʧ��",null);
		}
		return	new HRResult(200, "ע��ɹ�", users);
	}
	
	/**
	 * ע��ʱ��ѯ�û��Ƿ��ѱ�ע��
	 * @author hebin
	 * @date 2018��3��30��
	 */
	public HRResult findUsersName(String usersName) {
		UsersExample example=new UsersExample();
		Criteria ct=example.createCriteria();
		ct.andUsernameEqualTo(usersName);
		List<Users> list=mapper.selectByExample(example);
		if (list.size()>0) {
			return	new HRResult(202, "���û��ѱ�ע��", null);
		}
		return	new HRResult(200, "�û�����ȷ", null);
	}
	
	/**
	 * ��¼
	 * @author hebin
	 * @date 2018��3��30��
	 */
	@Override
	public HRResult login(Users users) {
		UsersExample example =new UsersExample();
		Criteria ct=example.createCriteria();
		ct.andUsernameEqualTo(users.getUsername());
		ct.andPasswordEqualTo(users.getPassword());
		List<Users> list=mapper.selectByExample(example);
		if (list.size()>0) {
			return new HRResult(200, "��¼�ɹ�", users);
		}
		return new HRResult(203, "�û������������", null);
	}
}
