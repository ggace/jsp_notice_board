<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		RequestDispatcher rd = request.getRequestDispatcher("viewGetAll.do");
		rd.forward(request, response);
	%>
	
	<!-- 
CREATE DATABASE BOARD default CHARACTER SET UTF8; 


CREATE TABLE MEMBER(
	id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
	userid varchar(50) NOT NULL UNIQUE,
	userpw varchar(50) NOT NULL,
	name varchar(32) NOT NULL,
	mail varchar(50) NOT NULL,
  	content TEXT NOT NULL,
  	primary key (id)
);

CREATE TABLE VIEW(
	ID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	TITLE TEXT NOT NULL,
	CONTENT TEXT NOT NULL,
	DAY DATE NOT NULL,
	COUNT BIGINT UNSIGNED NOT NULL DEFAULT 0,
	USERID BIGINT(20) UNSIGNED NOT NULL,
  	primary key (id),
	FOREIGN KEY (USERID)
		REFERENCES MEMBER(ID)
);

INSERT INTO MENBER(USERID, USERPW, NAME, MAIL, CONTENT)
VALUES('SYSTEM', 'ADMINPW', 'ADMIN', 'ADMIN@ADMIN.COM', 'I'M ADMIN');

CREATE TABLE COMMENT(
	ID BIGINT UNSIGNED NOT NULL auto_increment,
	CONTENT TEXT NOT NULL,
	DAY DATE NOT NULL,
	VIEWID BIGINT UNSIGNED NOT NULL,
	USERID BIGINT UNSIGNED NOT NULL,
	PRIMARY KEY(ID),
	FOREIGN KEY(VIEWID)
		REFERENCES VIEW(ID),
	FOREIGN KEY(USERID)
		REFERENCES MEMBER(ID)
	
);
	 -->
</body>
</html>