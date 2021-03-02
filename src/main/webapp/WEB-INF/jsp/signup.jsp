<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
</head>
<body>
	<div class="d-flex justify-content-center vh-100">
		<div class="d-flex justify-content-center align-items-center ">
			<form:form id="form" class="border border-3 rounded p-4">
				<h1 class="text-center">Sign Up:</h1>
				<p>Please enter an email and password:</p>
				<div class="input-group mb-3">

					<input type="text" id="email" name="email"
						placeholder="Enter an email" class="form-control">

				</div>
				<div class="input-group mb-3">

					<input type="password" id="password" name="password"
						placeholder="Enter a password" class="form-control">
				</div>
				<div class="input-group mb-2">

					<input type="password" id="password2" name="password2"
						placeholder="Confirm password" class="form-control">
				</div>
				<div class="text-center text-danger">${error}</div>
				<div class="d-flex justify-content-center mt-3">
					<input type="submit" value="Submit">
				</div>
			</form:form>
		</div>

	</div>
</body>
</html>