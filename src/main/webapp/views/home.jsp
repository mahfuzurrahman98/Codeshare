<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.noobs.codeshare.model.Language"%>
<%@page import="com.noobs.codeshare.model.User"%>

<%
ArrayList<Language> languages = (ArrayList<Language>) request.getAttribute("languages");
String poster_name = (String) request.getAttribute("poster");
int cur_user = (int) request.getAttribute("cur_user");
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Home-Noobs Codeshare</title>
<link href="./assets/css/bootstrap.min.css" rel="stylesheet">
<link href="./assets/css/bootstrap-multiselect.min.css" rel="stylesheet">
</head>

<body>
	<div class="container-fluid ">
		<form id="paste_form" action="SourceCodeService" method="post"
			class="row">
			<div
				class="col-12 col-md-6 <%=cur_user == 0 ? " col-lg-4" : "col-lg-3"%>">
				<label for="language" class="form-label">Language</label> <select
					class="form-control" id="language" name="language" required>
					<option value="">Select Language</option>
					<%
					for (Language lang : languages) {
					%>
					<option value="<%=lang.getId()%>">
						<%=lang.getName()%>
					</option>
					<%
					}
					%>
				</select>
			</div>
			<input type="hidden" name="poster" id="poster" value="<%=cur_user%>" />
			<div
				class="col-12 col-md-6 <%=cur_user == 0 ? " col-lg-4" : "col-lg-3"%>">
				<label for="poster_name" class="form-label">Poster</label> <input
					type="text" class="form-control" id="poster_name"
					name="poster_name" value="<%=cur_user == 0 ? "" : poster_name%>"
					<%=cur_user > 0 ? "readonly='readonly'" : "required"%>>
			</div>
			<div
				class="col-12 col-md-6 <%=cur_user == 0 ? " col-lg-4" : "col-lg-3"%>">
				<label for="language" class="form-label">Expire</label> <select
					class="form-control" id="expire" name="expire" required>
					<option value="">Select Expire</option>
					<option value="1">1 Hour</option>
					<option value="2">1 Day</option>
					<option value="3">1 Week</option>
					<option value="4">1 Month</option>
					<option value="5">Unlimited</option>
				</select>
			</div>
			<%
			if (cur_user > 0) {
				ArrayList<User> users = (ArrayList<User>) request.getAttribute("share_users");
			%>
			<div class="col-12 col-md-6 col-lg-3">
				<label for="visibility" class="form-label">Visibility</label> <select
					class="form-control" id="visibility" name="visibility" required>
					<option value="">Select Visibility</option>
					<option value="1">Public</option>
					<option value="2">Private</option>
					<option value="3">Protected</option>
				</select>
			</div>
			<div id="share_with_div" class="col-12 d-none">
				<label for="share_with" class="form-label">Share With</label> <select
					class="form-control selectpicker" id="share_with" name="share_with"
					multiple>
					<%
					for (User user : users) {
					%>
					<option value="<%=user.getId()%>">
						<%=user.getUsername()%>
					</option>
					<%
					}
					%>
				</select>
			</div>
			<%
			}
			%>
			<div class="">
				<label for="source">Source Code</label>
				<textarea class="form-control" id="source" name="source" required></textarea>
			</div>
			<div class="col-12 col-md-6 col-lg-3">
				<button id="submit_btn" type="submit" class="btn btn-success">Paste</button>
			</div>
		</form>
	</div>
</body>

<script src="./assets/js/bootstrap.bundle.min.js"></script>
<script src="./assets/js/jquery-3.6.0.min.js"></script>
<script src="./assets/js/bootstrap-multiselect.min.js"></script>

<script>
	$("#visibility").change(function() {
		if ($("#visibility").val() == 3) { // protected
			$("#share_with_div").removeClass("d-none");
		} else {
			$("#share_with_div").removeClass("d-block");
			$("#share_with_div").addClass("d-none");
		}
	});

	$("#paste_form").submit(function(e) {
		e.preventDefault();
		//$("#submit_btn").prop("disabled", true);

		if ($("#visibility").val() == 3 && $("#share_with").val() == "") {
			alert("Select at least one person!");
		} else {
			console.log($(this).serialize());
			$.ajax({
				type : $(this).attr('method'),
				url : $(this).attr('action'),
				data : $(this).serialize(),
				cache : false,
				timeout : 800000,
				success : function(data) {

				},
				error : function(e) {
				}
			});
		}
	});
</script>

</html>