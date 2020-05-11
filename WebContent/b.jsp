<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
</head>
<body>
<%
String	flag=(String)request.getAttribute("log");
	out.print(flag);
	if(flag.equals("rgtrue"))
	out.print("rgsuccess");
	else
		out.print("failed");


%>
</body>
</html>
