<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Customer</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/f8ebbde80f.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<h1>User Details Page</h1>
	<div>
		<p>${user.email}</p>
		<p>${user.password}</p>
		<p>${user.address}</p>
		<p>${user.credit_card}</p>
		<p>${user.role}</p>
		<p>${user.state}</p>
		<p>${user.zipcode}</p>
		<p>${user.email}</p>

	</div>
</body>
</html>