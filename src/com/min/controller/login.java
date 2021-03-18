package com.min.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.service.ViewService;
import com.min.vo.memberVo;
import com.mysql.cj.Session;

public class login implements controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		if(id == "" || pw == "") {
			req.setAttribute("error", "모든 값을 작성해주세요");
			HTTPUtil.forward(req, resp, "login.jsp");
			return;
		}
		
		ViewService service = ViewService.getInstance();
		
		memberVo member = new memberVo();
		
		member.setUserid(id);
		member.setUserpw(pw);
		
		ArrayList<memberVo> list = service.login(member);
		
		if(list.isEmpty()) {
			req.setAttribute("error", "없는 아이디 또는 비밀번호 입니다.");
			HTTPUtil.forward(req, resp, "login.jsp");
			return;
		}
		
		
		
		HttpSession session = req.getSession();
		
		if(session.isNew() || session.getAttribute("id") == null) {
			session.setAttribute("id", list.get(0).getId());
		}
		else {
			System.out.println("이미 로그인 상태입니다.");
		}
		
		
		HTTPUtil.forward(req, resp, "index.jsp");
	}
}
