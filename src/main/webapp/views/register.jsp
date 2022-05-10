<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Register-Noobs Codeshare</title>
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<form action="LoginService" method="post">
		<div class="mb-3">
			<label for="name" class="form-label">Name</label> <input
				type="text" class="form-control" id="name" name="name"
				required>
		</div>
		<div class="mb-3">
			<label for="username" class="form-label">Username</label> <input
				type="text" class="form-control" id="username" name="username"
				required>
		</div>
		<div class="mb-3">
			<label for="email" class="form-label">Email</label> <input
				type="email" class="form-control" id="email" name="email"
				required>
		</div>
		<div class="mb-3">
			<label for="password1" class="form-label">Password</label> <input
				type="password" class="form-control" id="password1" name="password1"
				required>
		</div>
		<div class="mb-3">
			<label for="password2" class="form-label">Re Enter Password</label> <input
				type="password" class="form-control" id="password2" name="password2"
				required>
		</div>
		<input type="submit" class="btn btn-primary" value="Register" />
	</form>
</body>

<script src="../assets/js/bootstrap.bundle.min.js"></script>
<script src="../assets/js/jquery-3.6.0.min.js"></script>

</html>
