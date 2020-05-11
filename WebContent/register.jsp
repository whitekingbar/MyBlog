<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
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
		<% 
	String rg=(String)request.getAttribute("regis");
		if(rg!=null){
			%>
			<script type="text/javascript"> alert("注册失败，用户已存在！")</script>
			<%
		}
	%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>注册</title>

</head>
<body>
<div style="width:100%;text-align:center">
	<form action="regisServlet" method="post">
	<span>用户名: </span><input type="text" name="uname" size="19" placeholder="请输入用户名"/><br/>
	<span>邮箱: &nbsp</span><input type="email" name="email" size="20" placeholder="请输入邮箱"	/><br/>
	<span>	密码: &nbsp</span><input type="password" name="upwd" size="20" placeholder="请输入密码" 	/><br/>&nbsp&nbsp
	<br/><input type="submit" value="注册"/>  &nbsp
	</form>
	</div>
</body>
</html>
