<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Login-Noobs Codeshare</title>
<link href="./assets/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<form id="login_form" action="LoginService" method="post">
		<div class="mb-3">
			<label for="username" class="form-label">Username</label> <input
				type="text" class="form-control" id="username" name="username"
				required>
		</div>
		<div class="mb-3">
			<label for="password" class="form-label">Password</label> <input
				type="password" class="form-control" id="password" name="password"
				required>
		</div>
		<input type="submit" class="btn btn-primary" id="submit_btn"
			value="Login" />
	</form>
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
