<%@page import="com.min.vo.ViewVo"%>
<%@page import="java.lang.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/BOARD/common/home.css" />
<link rel="stylesheet" href="/BOARD/resources/style/detail.css" />
<script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
</head>
<body>
	<%@ page import="java.util.*" %>
	<div id="home">
		<%@ include file="/common/home.jsp" %>
	</div>
	
	<%ArrayList<ViewVo> rs=(ArrayList<ViewVo>)request.getAttribute("rs");%>
	<%String id = null;
		id = String.valueOf(request.getSession().getAttribute("id")); 
	
	
	%>
	
	<div id="main">
		<ul id="each">
			<li id="viewTitle"><%= rs.get(0).getTitle() %></li>
			<li id="day"><%=rs.get(0).getDay() %></li>
			<li id="count">조회 <%=rs.get(0).getCount() %></li>
			
		</ul>
		<ul id="each">
			
			<li id="content"><%= rs.get(0).getContent() %> </li>
			
		</ul>
		<div id="height"></div>
		<ul id="each"></ul>
		
		
		<%if(id.equals(Integer.toString(rs.get(0).getUserid())) ){ %>
			<form id="update" action="ViewUpdate.jsp">
				<input type="hidden" name="id" value="<%=rs.get(0).getId() %>"/>
				<input type="hidden" name="title" value="<%=rs.get(0).getTitle() %>"/>
				<input type="hidden" name="content" value="<%=rs.get(0).getContent() %>"/>
				<input type="submit" value="수정"/>
			</form>
			<form id="delete" action="viewDelete.do" method="post">
				<input type="hidden" name="id" value="<%=rs.get(0).getId() %>"/>
				<input type="submit"  value="삭제"/>
			</form>
		<%} %>
		<form action="commentInsert.do" method="post">
			<input type="hidden" name="id" value="<%=rs.get(0).getId() %>"/>
			<input type="text" name="content"/>
			<input type="submit" />
		</form>
		
		
		<div id="ajax" style="margin-top: 15px;"></div>
		
		
		<script>
		setInterval(function(){
			ajax();
		}, 1000);
		
		
		
		function ajax(){
			
			$.ajax({
			    url: "http://localhost:8007/BOARD/commentGetAll.do",
			    dataType: "text",
			    data: {
			        id: "<%=rs.get(0).getId() %>"
			    },
			    success: function(data){
			        
			        
			        
			        var t = "";
			        for(var i = 0; i < data.length; i++){
			            if(!(data[i] == "[" || data[i] == "]")){
			                t += data[i];
			            }
			        }
			        
			        
			        
			        array = t.split(', ')
			        
			        list = []
			        
			        for(var i = 0; i < array.length; i++){
			        	list.push(JSON.parse(array[i]));
			        }
			        
			        console.log(list);
			        
			        comment = document.getElementById("ajax");
			        
			        arrays = list;
			        
			        innerText = "";
			        
			        console.log(list);
			        
			        innerText += "<h5 style='margin:0;'>댓글</h5>"
			        
			        for(var i = list.length-1; i >= 0 ; i--){
			        	innerText += "<ul style='margin: 0; list-style: none; padding-left: 15px; display: inline' id='comments'>";
			        	innerText += 	"<li style='font-size: 90%;margin: 0; padding 10px;'>" + list[i].content + "</li>";
			        	innerText += 	"<li style='font-size: 40%;margin: 0; padding 10px; margin-bottom: 5px;' id='date'>" + list[i].day + "</li>";
			        	
			        	if(list[i].userid == <%=id%>){
			        		
			        		innerText += 	"<form action='commentDelete.do' style=' position: absolute; right: 15%;'>";
				        	innerText += 		"<input type='hidden' name='id' value=" + list[i].id + " />";
				        	innerText += 		"<input type='hidden' name='viewid' value=" + <%=rs.get(0).getId()%> + " />";
				        	innerText += 		"<input type='submit' value='삭제' style=' border: 0; color: red; background-color: white;'/>";
			        		innerText += 	"</form>";
			        	}
				        	
			        	
			        	innerText += "</ul>";
			        	
			        }
			        
			        comment.innerHTML =innerText; 
			    }
			});
			
		}
		
		
		</script>			
	
		 
	</div>
	
</body>
</html>