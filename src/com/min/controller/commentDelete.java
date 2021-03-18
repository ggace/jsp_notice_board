package com.min.controller;

import com.min.service.ViewService;
import com.mysql.cj.protocol.Resultset;

public class commentDelete implements controller{
	public void execute(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) {
		String id = req.getParameter("id");
		String viewid = req.getParameter("viewid");
		String uesrid = String.valueOf(req.getSession().getAttribute("id"));
		
		ViewService service = ViewService.getInstance();
		
		service.commentDelete(id);
		
		
		
		HTTPUtil.forward(req, resp, "ViewShowDetail.do?id=" + viewid);
	};
}
