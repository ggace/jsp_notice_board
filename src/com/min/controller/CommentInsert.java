package com.min.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.service.ViewService;

public class CommentInsert implements controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String content = req.getParameter("content");
		String userid = String.valueOf(req.getSession().getAttribute("id"));
		
		if(content == null || content == "") {
			String path = "ViewShowDetail.do?id=" + id;
			
			HTTPUtil.forward(req, resp, path);
			return;
		}
		
		ViewService service = ViewService.getInstance();
		
		service.CommentInsert(id, content, userid);
		
		String path = "ViewShowDetail.do?id=" + id;
		
		HTTPUtil.forward(req, resp, path);
	}
}
