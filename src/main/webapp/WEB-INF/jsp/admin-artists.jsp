<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/f8ebbde80f.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="d-flex p-2">
		<h2>Artists</h2>
		<a href="/admin/createArtist"><i class="far fa-plus-square fa-2x"></i></a>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Location</th>
				<!-- <th scope="col"></th> -->
				<!-- <th scope="col"></th> -->
				<th scope="col"></th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${artists}" var="artist">
				<tr>
					<td>${artist.name}</td>
					<td>${artist.location}</td>


					<td><a href="/admin/updateartist/${artist.id}"><i
							class="far fa-edit"></i></a></td>
					<td><a href="/admin/deleteartist/${artist.id}"><i
							class="fas fa-trash"></i></a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>