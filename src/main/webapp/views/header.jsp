
<%
HttpSession cur_session = request.getSession();
%>
<nav
	class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark px-3 mb-3">

	<a class="navbar-brand mr-auto font-weight-bold" href="#"> <span
		class="text-success">Noobs</span> <span> Codeshare</span>
	</a> <a href="javascript:void(0)"
		class="navbar-brand mt-1 text-light text-lg d-block d-lg-none mr-1"
		data-bs-toggle="collapse" data-bs-target="#nbcollapse"> <span
		class="text-success h4 font-weight-bold"><i
			class="fa-solid fa-sliders"></i></span>
	</a>

	<div class="collapse navbar-collapse" id="nbcollapse">
		<ul class="navbar-nav mx-auto">
			<li class="nav-item ni px-2 px-lg-0 mx-lg-3"><a
				class="nav-link text-white" href="./home"><i
					class="fa-regular fa-paste"></i> New Paste</a></li>
			<%
			if (cur_session.getAttribute("username") != null) {
			%>
			<li class="nav-item ni px-2 px-lg-0 mx-lg-3"><a
				class="nav-link text-white" href="./library"><i
					class="fa-regular fa-bookmark"></i></i> My Code Library</a></li>
			<li class="nav-item ni px-2 px-lg-0 mx-lg-3"><a
				class="nav-link text-white" href="./shared"><i
					class="fa-solid fa-people-group"></i> Shared With Me</a></li>
			<%
			}
			%>
		</ul>
		<ul class="navbar-nav">
			<%
			if (cur_session.getAttribute("username") != null) {
			%>
			<li class="nav-item"><a class="nav-link text-white dropdown-toggle"
				href="#" id="navbarDropdownMenuLink" role="button"
				data-bs-toggle="dropdown" aria-expanded="false"><i
					class="fa-regular fa-user"></i> <%=cur_session.getAttribute("username")%>
			</a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdownMenuLink">
					<li><a class="dropdown-item" href="./logout"><i
							class="fa-solid fa-arrow-right-from-bracket"></i> Logout</a></li>
				</ul></li>
			<%
			} else {
			%>
			<li class="nav-item"><a class="nav-link" href="#">
					<button type="button" class="btn btn-primary btn-sm"
						data-bs-toggle="modal" data-bs-target="#exampleModal">
						Login</button>
			</a></li>
			<%
			}
			%>
		</ul>
	</div>
</nav>

<%
if (cur_session.getAttribute("username") == null) {
%>
<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title text-dark">Login</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form id="login_form" action="LoginService" method="post">
					<div class="mb-3">
						<label for="username" class="form-label">Username</label> <input
							type="text" class="form-control form-control-sm" id="username" name="username"
							required>
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password</label> <input
							type="password" class="form-control form-control-sm" id="password"
							name="password" required>
					</div>
					<div class="float-end">
						<input type="submit" class="btn btn-primary"
							value="Login" />
					</div>
				</form>
			</div>
			<div class="_modal-footer d-none px-2">
				<div class="alert alert-sm alert_msg" role="alert"></div>
			</div>
		</div>
	</div>
</div>
<%
}
%>
