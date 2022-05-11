<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.noobs.codeshare.model.Language"%>
<%@page import="com.noobs.codeshare.model.SourceCode"%>

<%
SourceCode details = (SourceCode) request.getAttribute("details");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Login-Noobs Codeshare</title>
<link href="./assets/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<div class="container-fluid px-lg-5 py-2">
		<textarea class="form-control" rows="30" cols="" readonly="readonly"><%=details.getSource_code()%></textarea>
	</div>
</body>

<script src="./assets/js/bootstrap.bundle.min.js"></script>
<script src="./assets/js/jquery-3.6.0.min.js"></script>

</html>
