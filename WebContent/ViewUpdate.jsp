<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/BOARD/resources/style/insert.css" />
<link rel="stylesheet" href="/BOARD/common/home.css" />
</head>
<body>
	<%
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
	%>
	
	<div id="home">
		<%@ include file="common/home.jsp" %>
	</div>
	<br />
	<div id="main" >
		<div id="subtitle">수정</div>
		
		<form action="viewUpdate.do" method="post">
			<input type="hidden" name="id" value="<%=id %>"/><br />
			<br />
			<input id="viewTitle" placeholder="제목" name="title" type="text" value="<%=title %>"/><br />
			<br />
			<textarea id="content" placeholder="내용을 입력하세요" name="content" id="" cols="100%" rows="20" ></textarea>
			<input type="submit" />
			<input type="reset" />
		</form>
	</div>
	
	<script>
	
		var text = document.getElementById("content");
		text.value = "<%=content %>";
	</script>
</body>
</html>