<%@page import="com.min.vo.ViewVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/BOARD/common/home.css" />
<link rel="stylesheet" href="/BOARD/resources/style/index.css" />

</head>
<body>
	<%@ page import="java.util.*" %>
	<div id="home">
		<%@ include file="/common/home.jsp" %>
	</div>
	
	<%ArrayList<ViewVo> rs=(ArrayList<ViewVo>)request.getAttribute("result");%>
	<%int pageNo = (int)request.getAttribute("page"); %>
	
	
	<ul id="table">
	
	<form align="right" action="ViewSearch.do" id="search" method="post">
		<select name="searchType" id="">
			<option value="tc">제목+내용</option>
			<option value="t">제목</option>
			<option value="c">내용</option>
		</select>
		<input id="item" type="text" name="item"/>
		<input type="submit" />
	</form>
	
	<br />
	
	<% for(int i = 0; i < rs.size(); i++){ %>
		<% if(i >= (pageNo-1)*10 && i < pageNo*10){ %>
		<a href="ViewShowDetail.do?id=<%=rs.get(i).getId() %>">
			<ul id="each">
				<li class="col"><%=rs.get(i).getTitle() %></li>
				<li class="day"><%=rs.get(i).getDay() %></li>
				<li class="count">조회 <%=rs.get(i).getCount() %></li>
			</ul>
		</a>
			
		<% } %>
		
	<% } %>
	<ul id="each"></ul>
	
	<form id="write" action="ViewInsert.jsp">
		<button type="submit">글쓰기</button>
	</form>
	
	</ul>
	<div id="pageTag">
		<% for(int i = 0; i < Math.ceil(rs.size()/10.); i++) { %>
			<form  id="page" action="viewGetAll.do" method="post">
				<button name="page" value="<%=i+1%>"><%=i+1 %></button>
			</form>
		<% } %>
	</div>
	<div id="footer">
		.
	</div>
	
	
</body>
</html>