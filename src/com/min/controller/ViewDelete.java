package com.min.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.service.ViewService;

public class ViewDelete implements controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String ined_id = req.getParameter("id");
		
		if(ined_id == null) {
			HTTPUtil.forward(req, resp, "http://localhost:8007/BOARD/ViewDelete.jsp");
			return;
		}
		
		int id = Integer.parseInt(ined_id);
		
		ViewService service = ViewService.getInstance();
		
		service.ViewDelete(id);
		
		HTTPUtil.forward(req, resp, "index.jsp");
	}
}
