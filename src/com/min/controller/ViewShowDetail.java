package com.min.controller;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.service.ViewService;
import com.min.vo.ViewVo;

public class ViewShowDetail implements controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));
		
		ViewService service = ViewService.getInstance();
		
		ArrayList<ViewVo> rs = service.ViewShowDetail(id);
		
		req.setAttribute("rs", rs);
		
		HTTPUtil.forward(req, resp, "result/ViewShowDetail.jsp");
	}
}
