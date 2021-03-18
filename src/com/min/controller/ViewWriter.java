package com.min.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.service.ViewService;
import com.min.vo.ViewVo;

public class ViewWriter implements controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String uesrid = String.valueOf(req.getSession().getAttribute("id"));
		
		if(title == null || content == null) {
			HTTPUtil.forward(req, resp, "http://localhost:8007/BOARD/ViewInsert.jsp");
			return;
		}
		
		ViewService service = ViewService.getInstance();
		
		ViewVo view = new ViewVo();
		
		view.setTitle(title);
		view.setContent(content);
		view.setUserid(Integer.parseInt(uesrid));
		
		service.ViewInsert(view);
		
		HTTPUtil.forward(req, resp, "index.jsp");
		
		
	}
}
