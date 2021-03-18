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
			req.setAttribute("error", "��� ���� �ۼ����ּ���");
			HTTPUtil.forward(req, resp, "login.jsp");
			return;
		}
		
		ViewService service = ViewService.getInstance();
		
		memberVo member = new memberVo();
		
		member.setUserid(id);
		member.setUserpw(pw);
		
		ArrayList<memberVo> list = service.login(member);
		
		if(list.isEmpty()) {
			req.setAttribute("error", "���� ���̵� �Ǵ� ��й�ȣ �Դϴ�.");
			HTTPUtil.forward(req, resp, "login.jsp");
			return;
		}
		
		
		
		HttpSession session = req.getSession();
		
		if(session.isNew() || session.getAttribute("id") == null) {
			session.setAttribute("id", list.get(0).getId());
		}
		else {
			System.out.println("�̹� �α��� �����Դϴ�.");
		}
		
		
		HTTPUtil.forward(req, resp, "index.jsp");
	}
}
