<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/f8ebbde80f.js"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body class="bg-light">

	<div class="container main">
		<nav
			class="conatiner-fluid navbar navbar-expand-lg navbar-light bg-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent">
				<span class="navbar-toggler-icon"></span>
			</button>
			<a class="navbar-brand" href="/home">MUSIC STORE</a>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="/home">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">About</a></li>
					<li class="nav-item"><form:form action="logout" method="post">
							<input type="submit" class="btn" value="Logout" />
						</form:form></li>
				</ul>
			</div>
		</nav>
		<div class="list-group p-3 mt-2">
			<h2>Confirmed!</h2>
			<h4>Your Order Will Be Shipped Shortly!</h4>
			<div class="list-group">
				<div
					class="list-group-item list-group-item-action flex-column align-items-start">

					<h5 class="mb-1">Shipping Address</h5>
					
					<div class="">${user.address}, ${user.city}</div>
					<div class="">${user.state}, ${user.zipcode}</div>
					<hr/>
					<div>Total: $${total} </div>
					<div>Card: ${user.credit_card}</div>
				</div>
			</div>

		</div>


	</div>
</body>
</html>