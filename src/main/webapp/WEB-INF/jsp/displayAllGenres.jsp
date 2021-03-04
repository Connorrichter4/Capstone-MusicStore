<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<! DOCTYPE html>

<html>

<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>List Tasks</title>

</head>

<body style="padding: 5%">



	<div id="wrapper">
		<div id="header">

			<h2>Manage Genres:</h2>


		</div>
	</div>

	<div id="content">
		<table class="table">
			<tr>
				<th scope="col">Genre name</th>
				<th scope="col">Genre Description</th>
				<th scope="col">Genre Album</th>

			</tr>

			<c:forEach var="genre" items="${genres}">


				<c:url var="updatelink" value="/updategenre">
					<c:param name="Id" value="${genre.id}" />
				</c:url>
				<c:url var="deletelink" value="/deletegenre">
					<c:param name="Id" value="${genre.id}" />
				</c:url>


				<tr>
					<td>${genre.getName()}</td>
					<td>${genre.getDescription()}</td>
				

					<td><a href="${updatelink }">Update</a> | 
					<a href="${deletelink }" onclick="if (!(confirm('Are you sure you want to delete this artist ?'))) return false">Delete</a></td>


				</tr>

			</c:forEach>

		</table>

		<div>


				<button type="button" onclick="window.location.href='createGenre'">New
				Genre</button>


		</div>


	</div>

</body>

</html>
