<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/BOARD/common/home.css" />
<link rel="stylesheet" href="/BOARD/resources/style/insert.css" />
</head>
<body>
	<div id="home">
		<%@ include file="common/home.jsp" %>
	</div>
	<br />
	<div id="main" >
		<div id="subtitle">글쓰기</div>
		<br />
		<form action="viewInsert.do" method="post">
			<input id="viewTitle" placeholder="제목" name="title" type="text" /><br />
			<br />
			<textarea id="content" placeholder="내용을 입력하세요" name="content" id="" cols="100%" rows="20"></textarea>
			<input type="submit" />
			<input type="reset" />
		</form>
	</div>
	
	
</body>
</html>