<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- jsp修改不用重启 --%>
	Hello Jsp
	
	<%! public String str1 = "Hello jsp";  %>	
	<%! public String test(){
			return "hello";
	} %>
	
	<!-- HTML注释:会带到客户端  -->
	<%-- Jsp注释:不会带到客户端 --%>
	<%
		int num = 100;
		int num2 = 200;
		int result = num + num2;
	%>
	
	<%-- jsp输出的话,在源码中是使用out.print() --%>
	<%= result %>
	
	<%--输出1~10 --%>
	<%--没一行都用>百分号包裹 --%>
	<%for(int i=1; i<=10; i++){%>
		<h1><%=i %></h1>
	<%}%>
	
	<%=config.getInitParameter("name") %>
	<%=config.getInitParameter("age") %>
</body>
</html>