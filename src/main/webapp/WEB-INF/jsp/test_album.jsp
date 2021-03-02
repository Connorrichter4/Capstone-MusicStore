<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	    <!-- Required meta tags -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
		<meta charset="ISO-8859-1">
		<title>Album test</title>
	</head>
	<body>
		<div class="container-fluid">
			<div class="row">
			
				<c:forEach items="${albums}" var="album">				
					<div class="col-2">
 		                <div class="card">
		                    <img class="card-img-top" src="${album.image}">
		                    <div class="card-body text-center">
		                        <h3 class="card-title text-center col-12">${album.name}</h3>
		                        <h4 class="card-title text-center col-12">${album.artist.name}</h4>
		                        <p class="card-text">
		                        	<span class="card-text text-center col-1">ID Number: ${album.id}</span>
		                        	<span class="card-text text-center col-11">${album.status}</span>
		                        </p>
		                        <p class="card-text text-center col-12">Release Date: <span>${album.date}</span></p>
		                        <a href="#" class="btn btn-secondary col-4">Buy</a>
		                        <span class="card-text text-center col-4">count: ${album.inventory}</span>
		                        <span class="card-text text-center col-4">Price: $${album.price}</span>
		                    </div>
		                </div>
					</div>
				</c:forEach>						
			</div>
		
		</div>

		
	</body>
</html>