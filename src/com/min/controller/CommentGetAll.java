package com.min.controller;


import java.io.IOException;
import java.io.PrintWriter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.simple.JSONObject;

import com.min.service.ViewService;
import com.min.vo.CommentVo;


public class CommentGetAll implements controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
		String id = req.getParameter("id");
		
		ViewService service = ViewService.getInstance();
		
		ArrayList<CommentVo> rs = service.CommentGetAll(id);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		
		PrintWriter out = null;
		
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		
		for(int i = 0; i < rs.size(); i++) {
			JSONObject obj = new JSONObject();
			
		
			
			obj.put("id", String.valueOf(rs.get(i).getId()));
			obj.put("content", rs.get(i).getContent());
			obj.put("day", '"' + dateFormat.format(rs.get(i).getDay()) + '"');
			obj.put("userid", String.valueOf(rs.get(i).getUserid()));
			obj.put("viewid", String.valueOf(rs.get(i).getViewid()));
			
			list.add(obj);
		}
		
		out.print(list);
	}
}
