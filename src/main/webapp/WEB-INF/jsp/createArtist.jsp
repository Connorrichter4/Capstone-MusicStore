
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body style="padding: 5%">

	<div id="wrapper">
		<div id="header">
			<h2>Create / Update a Artist:</h2>


		</div>

	</div>

	<div id="container">
		<h3></h3>

		<form:form action="newArtist" modelAttribute="artist" method="POST">
			<table>
			<form:hidden path="id" />

				<tr>
					<td>Artist Name:</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Location:</td>
					<td><form:input path="location" /></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="submit" value="Save Changes" />
					</td>
				</tr>
			</table>
		</form:form>

	</div>


</body>
</html>


