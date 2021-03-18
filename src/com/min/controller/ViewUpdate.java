package com.min.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.service.ViewService;
import com.min.vo.ViewVo;

public class ViewUpdate implements controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String ined_id = req.getParameter("id");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		if(ined_id == null || title == null || content == null) {
			HTTPUtil.forward(req, resp, "http://localhost:8007/BOARD/ViewInsert.jsp");
			return;
		}
		
		int id = Integer.parseInt(ined_id);
		
		ViewVo view = new ViewVo();
		view.setTitle(title);
		view.setContent(content);
		
		ViewService service = ViewService.getInstance();
		
		service.ViewUpdate(id, view);
		
		HTTPUtil.forward(req, resp, "index.jsp");
		
		
		
		
	}
}
