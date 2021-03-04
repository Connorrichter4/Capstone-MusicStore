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
		<title>Album ${album.id} test</title>
	</head>
	<body>
		<div class="container-fluid">
			<div class="row">			

	                <div class="col-xs-12 col-sm-12 col-md-6 col-lg-4">
	                   	<img class="col-12 rounded float-left img-thumbnail img-fluid" src="../img/album/${album.image}">
					</div>
					<div class="col-xs-12 col-sm-12 col-md-3 col-lg-4">
                       <h3 class="card-title text-center col-12">${album.name}</h3>
                       <h4 class="card-title text-center col-12">${album.artist.name}</h4>
                       <h4 class="card-text text-center col-12">${album.status}</h4>	                   
					</div>
					<div class="col-xs-12 col-sm-12 col-md-3 col-lg-4">
                       <p class="card-text text-center col-12">
							Release Date:<span>${album.date}</span>
						</p>
						<p>
	                       <span class="card-text text-center col-4">count: ${album.inventory}</span>
	                       <span class="card-text text-center col-4">Price: $${album.price}</span>
	                       <a href="#" class="btn btn-secondary float-right col-4">Buy</a>   
                       </p>
                      
                       
                                      
					</div>
			
			</div>
		
		</div>
	</body>
</html>