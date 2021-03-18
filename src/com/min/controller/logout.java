package com.min.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logout implements controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		
		if(session.isNew() || session.getAttribute("id") == null) {
			System.out.println("현재 로그인 상태가 아닙니다.");
		}
		else {
			session.removeAttribute("id");
		}
		
		
		HTTPUtil.forward(req, resp, "index.jsp");
	}
}
