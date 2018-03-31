package com.hb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		//1
		HttpServletRequest request = (HttpServletRequest) arg0;
		
		//2 判断
		if(request.getSession().getAttribute("users")==null){
			/*request.setAttribute("message", "必须先登录再使用");*/
			System.out.println(request.getContextPath());
			request.getRequestDispatcher("/").forward(arg0, arg1);
		}else{
			System.out.println(request.getContextPath());
			arg2.doFilter(arg0, arg1);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
