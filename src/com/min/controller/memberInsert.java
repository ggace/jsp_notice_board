package com.min.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.service.ViewService;
import com.min.vo.memberVo;

public class memberInsert implements controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		String content = req.getParameter("content");
		
		String uesrid = String.valueOf(req.getSession().getAttribute("id"));
		
		if(id == "" || pw == "" || name=="" || mail == "" || content=="" ) {
			req.setAttribute("error", "모든 값을 작성해주세요");
			HTTPUtil.forward(req, resp, "signup.jsp");
			return;
		}
		
		ViewService service = ViewService.getInstance();
		
		memberVo member = new memberVo();
		
		member.setUserid(id);
		member.setUserpw(pw);
		member.setName(name);
		member.setMail(mail);
		member.setContent(content);
		
		int b = service.memberInsert(member);
		
		if(b == 1) {
			req.setAttribute("error", "이미 있는 아이디 입니다.");
			HTTPUtil.forward(req, resp, "signup.jsp");
			
			return;
		}
		
		HTTPUtil.forward(req, resp, "index.jsp");
	}
}
