<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/BOARD/resources/style/login.css" />
<script src='/JSP_D-2/resources/script/script.js'></script>
<title>Form Test</title>
</head>
<body>
	
	<div id="memberWrap">
		
		<div id="memberInfo">
			<h2 class='siteTitle'>로그인</h2>
			<form action="login.do" method='post' id='block'>
				${error }
				<div id='content'>ID</div> <input id='inputs' type="text" name="id"><br />
				<div id='content'>PW</div> <input id='inputs' type="password" name='pw'/><br />
				
				<input id='submit' type="submit" value='전송'/>
				<input id='reset' type="reset" value='초기화'/>
			</form>
		</div>
	
	
		
		
	</div>

	
	
	
</body>
</html>