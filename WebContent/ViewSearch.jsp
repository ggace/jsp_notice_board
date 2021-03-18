<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ViewSearch.do" method="post">
		<select name="searchType" id="">
			<option value="tc">제목+내용</option>
			<option value="t">제목</option>
			<option value="c">내용</option>
		</select>
		<input type="text" name="item" />
		<input type="submit" />
	</form>
</body>
</html>