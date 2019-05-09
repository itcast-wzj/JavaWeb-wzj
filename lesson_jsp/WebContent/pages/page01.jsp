<%--jsp中的三大指令: page,include,taglib --%>
<%--1.page指令 --%>
<%@page import="com.bean.User"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" errorPage="/WEB-INF/error.jsp"
	extends="com.servlet.MyJsp"
	info="this is page01"    
 %>

<%--主要用来初始化一些信息,不会生成.java文件 --%>
<%@include file="./base.jsp" %>
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- jsp模板引擎修改完后是不用重启的,web.xml修改后修改重启 --%>
	<%--jsp中java代码不是很方便,这是因为实际上jsp不推荐写java代码,后来就产生了一些el标签代替他们 --%>
	<% 
		Random random = new Random();
		int num = random.nextInt(10);
	%>
	<!-- java表达式对应jsp '真身' out.print(num)  其中\r\n是换行的意思,\t是制表符的作用 -->
	<%=num%>
	<!-- java语句中的代码是直接显示在jsp '真身'中   -->
	<%
		/*errorPage="error.jsp" 发生异常后,直接跳到指定的页面,转发到web-inf下  */
		/* int i =  10 / 0;  */
	%>
	
	<%--
		session是jsp中的内置对象
		session可以用取决于page指令中的session = 值,值等于true可以用,false不能用
		但可以通过pageContext(jsp中的page域 ),来获取session
		一个page域对象  = 9个内置对象,因为他都能获取到
	 --%>
	<%
		HttpSession s = pageContext.getSession();
	%>
	
	<%-- 输出的className属性其实是继承于父类(com.servlet.MyJsp)中
		 因为page指定上,指明了extends = com.servlet.Myjsp,记住私有是继承不过来的
		 这样可以更加让我们理解jsp本质上就是一个servlet
	 --%>
	<%=className%>
	
	<%--
		这是page指令中的info = "this is  page01"
		对应jsp '真身' 是一个
		public java.lang.String getServletInfo() {
    		return "this is page01";
  		}
	 --%>
	<%=getServletInfo()%>
	
	<%=path %>
	
	<a href=<%=path%>/Servlet01>Servlet01</a>
	
	
	<%-- 下面的看看就行 --%>
	
	<!--这个是做布局,会生成.java文件 -->
	<jsp:include page="./top.jsp"></jsp:include>
	
	<%--设定对象属性,保存对象到指定作用域 --%>
	<%
		/* User user = new User(); */
	%>
	
	<jsp:useBean id="u1" class="com.bean.User" scope="request"></jsp:useBean>
	<jsp:setProperty property="username" name="u1" value="tom"/>
	<jsp:setProperty property="password" name="u1" value="123"/>
	
	<jsp:forward page="./page02.jsp"></jsp:forward>
</body>
</html>