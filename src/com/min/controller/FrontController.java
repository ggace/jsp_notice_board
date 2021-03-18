package com.min.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	HashMap<String, controller> controllers;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		controllers = new HashMap<String, controller>();
		
		controllers.put("/viewInsert.do", new ViewWriter());
		controllers.put("/viewUpdate.do", new ViewUpdate());
		controllers.put("/viewDelete.do", new ViewDelete());
		controllers.put("/viewGetAll.do", new ViewGetAll());
		controllers.put("/ViewShowDetail.do", new ViewShowDetail());
		controllers.put("/ViewSearch.do", new ViewSearch());
		controllers.put("/commentInsert.do", new CommentInsert());
		controllers.put("/commentGetAll.do", new CommentGetAll());
		controllers.put("/commentDelete.do", new commentDelete());
		controllers.put("/signup.do", new memberInsert());
		controllers.put("/login.do", new login());
		controllers.put("/logout.do", new logout());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		String path = req.getContextPath();
		
		String file = uri.substring(path.length());
		
		System.out.println(file);
		System.out.println(req.getSession().getAttribute("id"));
		
		
		
		controllers.get(file).execute(req, resp);
	}
	
	
	
}
