package org.zerock.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.log4j.Log4j;

@Log4j
public class CheckLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Cookie[] cks = request.getCookies();
		
		boolean check = false;
		
		if (cks == null || cks.length == 0) {
			return false;
		}
		
		for (Cookie cookie : cks) {
			if(cookie.getName().equals("lcookie")) {
				check = true;
				break;
			}
		}
		log.info("LOGIN CHECK RESULT : " + check);
		if(check == false) {
			response.sendRedirect("/");
		}
		
		return super.preHandle(request, response, handler);
	}
	

}
