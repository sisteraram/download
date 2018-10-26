package org.zerock.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.zerock.domain.MemberVO;

public class AfterLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Object result = modelAndView.getModel().get("member");
		
		if(result == null) {
			return;
		}
		
		MemberVO memberVo = (MemberVO) result;
		 Cookie loginCoolie = new Cookie("lcookie", URLEncoder.encode(memberVo.getName(), "UTF-8"));
	}
	
	
}
