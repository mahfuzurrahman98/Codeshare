<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.noobs.codeshare.model.Language"%>
<%@page import="com.noobs.codeshare.model.SourceCode"%>

<%
SourceCode details = (SourceCode) request.getAttribute("detials");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Login-Noobs Codeshare</title>
<link href="./assets/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<div class="container-fluid">
		<textarea rows="50" cols="" readonly="readonly">
			<%=details.getSource_code()%>
		</textarea>
	</div>
</body>

<script src="./assets/js/bootstrap.bundle.min.js"></script>
<script src="./assets/js/jquery-3.6.0.min.js"></script>

<script>
	$("#login_form").submit(function(e) {
		e.preventDefault();
		$("#submit_btn").prop("disabled", true);
		$.ajax({
			type : $(this).attr('method'),
			url : $(this).attr('action'),
			data : $(this).serialize(),
			cache : false,
			timeout : 800000,
			success : function(data) {
				let res = JSON.parse(data);
				if (res.login) {
					window.location.reload();
				}
			},
			error : function(e) {
			}
		});
	});
</script>
</html>
