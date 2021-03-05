<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customers</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/f8ebbde80f.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container main">

	<div class="d-flex p-2">
		<h2>Users</h2>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">State</th>
				<!-- <th scope="col"></th> -->
				<!-- <th scope="col"></th> -->
				<th scope="col"></th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.state}</td>



					<td><a href="/admin/customer/${user.id}"><i
							class="far fa-edit"></i></a></td>
					<td><a href="/admin/customer/delete/${user.id}"><i
							class="fas fa-trash"></i></a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>