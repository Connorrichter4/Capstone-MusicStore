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
		<div class="container" style="background-color: red;">
		
			<div class="row">
				<div class="sidebar col-1" style="background-color: blue;">
					This is the sidebar...
				</div>	
				<div class="main col-11" style="background-color: yellow;">
					<nav class="navbar navbar-expand-lg navbar-light bg-light">
					  <a class="navbar-brand" href="#">Navbar</a>
					  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					    <span class="navbar-toggler-icon"></span>
					  </button>
					
					  <div class="collapse navbar-collapse" id="navbarSupportedContent">
					    <ul class="navbar-nav mr-auto">
					      <li class="nav-item active">
					        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
					      </li>
					      <li class="nav-item">
					        <a class="nav-link" href="#">Link</a>
					      </li>
					      <li class="nav-item dropdown">
					        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					          Dropdown
					        </a>
					        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
					          <a class="dropdown-item" href="#">Action</a>
					          <a class="dropdown-item" href="#">Another action</a>
					          <div class="dropdown-divider"></div>
					          <a class="dropdown-item" href="#">Something else here</a>
					        </div>
					      </li>
					      <li class="nav-item">
					        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
					      </li>
					    </ul>
					    <form class="form-inline my-2 my-lg-0">
					      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
					      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					    </form>
					  </div>
					</nav>
				
				
					<div>
						<div class="row">
							<c:forEach items="${albums}" var="album">				
								<div class="col-xs-12 col-sm-6 col-md-4 col-lg-2">
			 		                <div class="card">
					                    <a href="/album/${album.id}"><img class="card-img-top img-thumbnail" src="${album.image}"></a>
					                    <div class="card-body text-center">
					                    	<div class="car-title">
					                        	<p>${album.name}<br/>${album.artist.name}</p>
					                    	</div>
					                        <div class="card-text">
					                        	${album.status}
					                        	<span class="card-text text-center col-4">Price: $${album.price}</span>
					                        </div>
					                        <a href="#" class="btn btn-secondary col-4">Buy</a>
					                    </div>
					                </div>
								</div>
							</c:forEach>						
						</div>
					
					</div>
				</div>						
			</div>	
				
		</div>

		
		

			
			

			


	


		
	</body>
</html>