<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page import="blog.bean.articleBean" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>博客后台-查看文章</title>
</head>
<body>
<% articleBean art=(articleBean)request.getAttribute("article") ;
%> <center>
        <table width="778" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" style="word-break:break-all">
          
            <tr>
                <td align="center" valign="top">
                	<form action="otherArticle.jsp" method="post">
                	<input type="hidden" name="action" value="add">
                	<table border="0" width="100%" cellspacing="0" cellpadding="8">
                		<tr height="50"><td colspan="2">【查看】</td></tr>
                		<tr>
                			<td align="center" width="20%">文章类别：</td>
                			<td>
                					<%int type=art.getTypeId();
                						switch(type)
                						{
                						case 1:out.print("工作");break;
                						case 2:out.print("生活");break;
                						case 3:out.print("学习");break;
                						
                						}
                					
                					%>
                			</td>
                		</tr>
                		<tr>
                			<td align="center">文章标题：</td>
                			<td><%=art.getTitle() %></td>
                		</tr>
                		<tr>
                			<td align="center">文章权限：</td>
                			<td>
                				<%int visible=art.getVisible();
                						switch(visible)
                						{
                						case 1:out.print("公开");break;
                						case 0:out.print("私密");break;
                						}
                					
                					%>
                			</td>
                		</tr>
	               		<tr>
                			<td align="center">文章描述：</td>
                			<td><%=art.getDescrip() %></td>
                		</tr>
                		<tr>
                			<td align="center" valign="top">文章内容：</td>
                			<td>
                				<textarea name="content" rows="8" cols="65"  readonly="readonly"><%=art.getContent() %></textarea>
                			</td>
                		</tr>
                		<tr height="30">
                			<td colspan="2" align="center">
                				<input type="submit" class="btn_bg" value="返回">
                			</td>
                		</tr>
                	</table>
                	</form>
                </td>
            </tr>
        
        </table>
    </center>
</body>
</html>