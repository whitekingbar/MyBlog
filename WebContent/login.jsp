<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<style type="text/css"><!-- 内部样式-->
		div
		{
			padding-left:400px;
		}
		body
		{
			background:url(back.jpg);
		}
		div form span
		{
			color:#abc;
		}


	</style>
	<% String flag=(String)request.getAttribute("login");
	String rg=(String)request.getAttribute("regis");
		if(flag!=null)
		{
			%>
			<script type="text/javascript"> alert("用户名或密码不正确！")</script>
			<% }
		if(rg!=null)
		{
			%>
			<script type="text/javascript"> alert("注册成功！")</script>
			<%
		}
		
		
	%>
	
		<meta charset="UTF-8">
		<title>登录</title>
		<link rel="stylesheet" type="text/css" href="login.css" />
 </head>
<body>
<div style="width:100%;text-align:center">
	<form action="loginServlet" method="post" style="display: inline">
		<span>邮箱</span>:&nbsp<input type="text" name="uemail"   placeholder="请输入邮箱" 	/><br/>
		<span>密码:</span>&nbsp<input type="password" name="upwd"  placeholder="请输入密码" 	/><br/>&nbsp&nbsp
			<br/><input type="submit" value="登录"/>  &nbsp 
	</form>
	<a href="register.jsp"> <button value="1">注册</button></a>
		
</div>


</body>   
</html>

