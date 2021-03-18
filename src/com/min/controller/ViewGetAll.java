package com.min.controller;



import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.service.ViewService;
import com.min.vo.ViewVo;

public class ViewGetAll implements controller{
	 @Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
		String page_parm = req.getParameter("page");
		
		int page;
		
		if(page_parm == null) {
			page = 1;
		}
		else {
			page = Integer.parseInt(page_parm);
		}
		 
		ViewService service = ViewService.getInstance();
		
		ArrayList<ViewVo> rs = service.ViewGetAll();
		
		
		
		
		
		
		
		req.setAttribute("result", rs);
		req.setAttribute("page", page);
		
		
		
		
		HTTPUtil.forward(req, resp, "result/ViewGetAll.jsp");
	}
}
