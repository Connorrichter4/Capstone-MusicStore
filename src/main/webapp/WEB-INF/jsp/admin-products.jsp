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
		<h2>Albums</h2>
		<a href="/admin/album/create"><i class="far fa-plus-square fa-2x"></i></a>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Price</th>
				<th scope="col">Date</th>
				<th scope="col">Status</th>
				<th scope="col">Artist Id</th>
				<th scope="col">Inventory</th>
				<!-- <th scope="col"></th> -->
				<th scope="col"></th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${albums}" var="album">
				<tr>
					<td>${album.name}</td>
					<td>${album.price}</td>
					<td><fmt:formatDate type="date" value="${album.date}" /></td>
					<td>${album.status}</td>
					<td>${album.artist.name}</td>
					<td>${album.inventory}</td>


					<td><a href="/admin/album/${album.id}"><i
							class="far fa-edit"></i></a></td>
					<td><a href="/delete-task/${album.id}"><i
							class="fas fa-trash"></i></a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="d-flex p-2">
		<h2>Songs</h2>
		<a href="/admin/song/create"><i class="far fa-plus-square fa-2x"></i></a>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Price</th>
				<th scope="col">Album</th>
				<th scope="col">Artist</th>
				<th scope="col">Inventory</th>
				<!-- <th scope="col"></th> -->
				<!-- <th scope="col"></th> -->
				<th scope="col"></th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${songs}" var="song">
				<tr>
					<td>${song.name}</td>
					<td>${song.price}</td>
					<td>${song.album.name}</td>
					<td>${song.artist.name}</td>
					<td>${song.inventory}</td>


					<td><a href="/admin/song/${song.id}"><i
							class="far fa-edit"></i></a></td>
					<td><a href="/admin/song/delete/${song.id}"><i
							class="fas fa-trash"></i></a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>