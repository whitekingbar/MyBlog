<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.ArrayList" %>



<html>
<head>
	<title>博客后台-发表文章</title>
</head>
<body>
    <center>
        <table width="778" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" style="word-break:break-all">
          
            <tr>
                <td align="center" valign="top">
                	<form action="uploadArticleServlet" method="post">
                	<input type="hidden" name="action" value="add">
                	<table border="0" width="100%" cellspacing="0" cellpadding="8">
                		<tr height="50"><td colspan="2">【发表文章】</td></tr>
                		<tr>
                			<td align="center" width="20%">文章类别：</td>
                			<td>
                				<select name="typeId" style="width:100">
                					<option value="1"/>工作</option>
                					<option value="2"/>生活</option>
                					<option value="3"/>学习</option>
                				
                				</select>
                			</td>
                		</tr>
                		<tr>
                			<td align="center">文章标题：</td>
                			<td><input type="text" name="title" size="77"></td>
                		</tr>
                		<tr>
                			<td align="center">文章权限：</td>
                			<td>
                				<select name="visible" style="width:100">
                					<option value="1" >公开</option>
                					<option value="0">私密</option>
                				</select>
                			</td>
                		</tr>
	               		<tr>
                			<td align="center">文章描述：</td>
                			<td><input type="text" name="info" size="77"></td>
                		</tr>
                		<tr>
                			<td align="center" valign="top">文章内容：</td>
                			<td>
                				<textarea name="content" rows="8" cols="65"></textarea>
                			</td>
                		</tr>
                		<tr height="30">
                			<td colspan="2" align="center">
                				<input type="submit" class="btn_bg" value="保存">
                				<input type="reset"  class="btn_bg" value="重置">
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