<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result Page</title>
</head>
<body>
<%
	int result = (int)request.getAttribute("result");
	out.println("average of the two number is "+result);
%>
</body>
</html>