package com.min.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/image")
public class image extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("image/gif");
		
		byte[] by = new byte[1024];
		
		ServletOutputStream out = resp.getOutputStream();
		
		String imgPath = "C:\\users\\김민서\\eclipse-workspace\\BOARD\\WebContent\\images\\aa.jpg";
		
		BufferedInputStream	in = new BufferedInputStream(new FileInputStream(imgPath));
		
		while(in.read(by) != 0) {
			out.write(by);
		}
		
		in.close();
		out.close();
		
		System.out.println("이미지 출력");
	}
}
