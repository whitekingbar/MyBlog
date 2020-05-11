<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" import="java.util.*" %>
<%@page import="blog.bean.User" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
   <style type="text/css">
     .divForm{
			position: absolute;/*绝对定位*/
			width: 300px;
			height: 200px;

			border: 1px none red;
			text-align: center;/*(让div中的内容居中)*/
			top: 30%;
			left: 50%;
			margin-top: -200px;
			margin-left: -150px;
				}
    </style>
</head>
<body>
	 <center>
        <table width="778" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" style="word-break:break-all">
            <tr>
                <td align="center" valign="top">
                	<table width="560" border="0" cellspacing="0" cellpadding="0" rules="none">
						<tr height="60"><td colspan="4">【查询好友】</td></tr>
						<tr>
							<td align="right" colspan="4">
								<form action="searchPeole"  method="post">
									<input  type="text"  placeholder="请输入用户名称或邮箱" name="uinfo"/>
									<input type="submit" value="查询" class="btn_bg">	
								</form>
							
							</td>
						</tr>
						<tr height="30" bgcolor="#F5F4F4">
							<td width="55%" style="text-indent:20">用户名</td>
							<td align="center" width="30%">邮箱</td>
						</tr>
						<%
							ArrayList userlist=(ArrayList)request.getAttribute("users");
							if(userlist==null||userlist.size()==0){
						%>
						<tr height="80"><td colspan="4" align="center"><li>无此用户！</li></td></tr>
						<%	
							} 
							else{
    							for(int i=0;i<userlist.size();i++){
    								User user=(User)userlist.get(i);;    							
						%>
						<tr height="35">
							<td style="text-indent:20"><a href="friendArticleServlet?email=<%= user.getEmail() %>" class="word_purple "><%=user.getUname()%></a></td>	
							<td style="text-indent:20"><%=user.getEmail()%></td>							
						</tr>

						<%
    							}
							}
						%>
						
                	</table>
                </td>
            </tr>
        
        </table>
    </center>
</body>
</html>
