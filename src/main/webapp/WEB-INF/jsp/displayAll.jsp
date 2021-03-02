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

			<h2>Manage Artists:</h2>


		</div>
	</div>

	<div id="content">
		<table class="table">
			<tr>
				<th scope="col">Artist name</th>
				<th scope="col">Location</th>
				

			</tr>

			<c:forEach var="artist" items="${artists}">


				<c:url var="updatelink" value="/updateartist">
					<c:param name="Id" value="${artist.id}" />
				</c:url>
				<c:url var="deletelink" value="/deleteartist">
					<c:param name="Id" value="${artist.id}" />
				</c:url>


				<tr>
					<td>${artist.getName()}</td>
					<td>${artist.getLocation()}</td>

					<td><a href="${updatelink }">Update</a> | 
					<a href="${deletelink }" onclick="if (!(confirm('Are you sure you want to delete this artist ?'))) return false">Delete</a></td>


				</tr>

			</c:forEach>

		</table>

		<div>


				<button type="button" onclick="window.location.href='createArtist'">New
				Artist</button>


		</div>


	</div>

</body>

</html>
