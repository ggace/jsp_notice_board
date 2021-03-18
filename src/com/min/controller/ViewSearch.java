package com.min.controller;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.service.ViewService;
import com.min.vo.ViewVo;

public class ViewSearch implements controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String type = req.getParameter("searchType");
		String item = req.getParameter("item");
		
		System.out.println(type);
		
		if(item == null) {
			HTTPUtil.forward(req, resp, "http://localhost:8007/BOARD/ViewSearch.jsp");
			return;
		}
		
		ViewService service = ViewService.getInstance();
		
		ArrayList<ViewVo> rs = service.SearchView(type, item);
		
		
		if(rs == null) {
			req.setAttribute("error", "Not Found");
			HTTPUtil.forward(req, resp, "http://localhost:8007/BOARD/ViewSearch.jsp");
			return;
		}
		
		req.setAttribute("result", rs);
		
		req.setAttribute("page", 1);
		req.setAttribute("type", type);
		req.setAttribute("item", item);
		
		
		
		HTTPUtil.forward(req, resp, "result/ViewSearch.jsp");
	}
}
