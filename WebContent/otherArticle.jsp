<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="blog.bean.articleBean" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>博客后台-他人文章</title>
</head>
<body>
    <center>
        <table width="778" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" style="word-break:break-all">
            <tr>
                <td align="center" valign="top">
                	<table width="560" border="0" cellspacing="0" cellpadding="0" rules="none">
						<tr height="60"><td colspan="4">【浏览好友文章】</td></tr>
						<tr>
							<td align="right" colspan="4">
								<form action="" method="post">
									<input type="hidden" name="action" value="adminSelectList">
									文章类别：
									<select name="typeId">
										<option value="1">工作</option>
        		        	        	<option value="2">生活</option>
        		        	        	<option value="3">学习</option>
									</select>
									<input type="submit" value="显示" class="btn_bg">	
								</form>
							</td>
						</tr>
						<tr height="30" bgcolor="#F5F4F4">
							<td width="55%" style="text-indent:20">文章标题</td>
							<td align="center" width="30%">是否可见</td>
						</tr>
						<%
							ArrayList articlelist=(ArrayList)session.getAttribute("otherArticles");
							if(articlelist==null||articlelist.size()==0){
						%>
						<tr height="80"><td colspan="4" align="center"><li>没有文章可显示！</li></td></tr>
						<%	
							} 
							else{
    							for(int i=0;i<articlelist.size();i++){
    								articleBean single=(articleBean)articlelist.get(i);    							
						%>
						<tr height="35">
							<td style="text-indent:20"><a href="showOtherArticleServlet?title=<%=single.getTitle() %>&typeId=<%=single.getTypeId() %>" class="word_purple "><%=single.getTitle()%></a></td>
							<td  align="center"><%int visible=single.getVisible();
                						switch(visible)
                						{
                						case 1:out.print("公开");break;
                						case 0:out.print("私密");break;
                						}
                					
                					%></td>
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