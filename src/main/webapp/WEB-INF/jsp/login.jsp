<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<script type="text/javascript">
	
	window.setTimeout(function() {
		document.getElementById('alert').style.display = 'none';	
	}, 2500);
	
</script>
</head>
<body class="p-2">
	<c:if test="${param.logout != null}">
		<div id="alert" class="alert alert-success" role="alert">
		
			<strong>Success!</strong> You have been signed out successfully!
		</div>
	</c:if>
	<div class="d-flex justify-content-center vh-100">
		<div class="d-flex justify-content-center align-items-center ">
			<form:form id="form" class="border border-3 rounded p-4">
				<h1 class="text-center">Login:</h1>
				<p>Please enter your username and password:</p>
				<div class="input-group mb-3">

					<input type="text" id="username" name="username"
						placeholder="Enter a username" class="form-control">

				</div>
				<div class="input-group mb-2">

					<input type="password" id="password" name="password"
						placeholder="Enter a password" class="form-control">
				</div>
				<c:if test='${param.error != null}'>
					<div class="text-center text-danger">Incorrect Credentials!</div>
				</c:if>
				<div class="d-flex justify-content-center mt-3">
					<input type="submit" value="Submit">
				</div>
				<div class="d-flex justify-content-center mt-2">
					<a href="/signup">Click here to sign up!</a>
				</div>
			</form:form>
		</div>

	</div>
</body>
</html>