<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%if(request.getSession().getAttribute("id") != null) {%>
	<a id="tab" style="position: absolute;right: 5%;;" href="logout.do">logout</a>
<%}else{ %>
	<a id="tab" style="position: absolute;right: 5%;" href="login.jsp">login</a>
	
<%} %>
<h1 id="title" ><a href="index.jsp">SBS Cafe</a></h1>
