<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="/css/style.css">
<meta charset="UTF-8">

<title>Album test</title>

</head>
<body>
	<!-- START CONTAINER -->
	<div class="container main">
		<!-- 		START MAIN CONTENT -->
		<div class="main">
			<!-- 			START NAVBAR -->
			<nav class="conatiner-fluid navbar navbar-expand-lg navbar-light bg-light">
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">
						<span class="navbar-toggler-icon"></span>
					</button>
					<a class="navbar-brand" href="/home">MUSIC STORE</a>
					<a href="/cart" class="btn btn-success float-right"><i class="fa fa-shopping-cart"></i> Cart</a>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item active">
								<a class="nav-link" href="/home">Home <span class="sr-only">(current)</span> </a>
							</li>
							<li class="nav-item"><a class="nav-link" href="#">About</a></li>
							<li class="nav-item"><form:form action="logout" method="post">
							<input type="submit" class="btn" value="Logout" />
						</form:form></li>
						</ul>
					</div>
				</nav>
			<!-- 			END NAVBAR -->
			<!-- 			START CAROUSEL -->
			<div class="jumbotron">
				<div id="carousel" class="carousel carousel-dark slide" data-bs-ride="carousel">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carousel" data-bs-slide-to="0" class="active"></button>
						<button type="button" data-bs-target="#carousel" data-bs-slide-to="1"></button>
						<button type="button" data-bs-target="#carousel" data-bs-slide-to="2"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active ">
							<img src="/img/album/Album_1.png" class="d-block w-100">
							<div class="carousel-caption d-none d-md-block caption-1">
							</div>
						</div>
						<div class="carousel-item">
							<img src="img/artist/Artist_1.png" class="d-block w-100">
							<div class="carousel-caption d-none d-md-block">
							</div>
						</div>
						<div class="carousel-item">
							<img src="img/artist/Artist_2.png" class="d-block w-100">
							<div class="carousel-caption d-none d-md-block">
							</div>
						</div>
					</div>
					<button class="carousel-control-prev" type="button" data-bs-target="#carousel" data-bs-slide="prev">
						<span class="carousel-control-prev-icon"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button" data-bs-target="#carousel" data-bs-slide="next">
						<span class="carousel-control-next-icon"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
			</div>
			<!-- 			END CAROUSEL -->
			<!-- 			START SEARCH BAR -->
			<div class="container row mt-3">
			
				<form action="/search" method="post">
					<div class="form-row">
						<div class="form-row justify-content-center">
							<input class=" col-md-11 " type="search" name="generalSearch" placeholder="Search">
							<select class=" col btn-sm" name="criteria" id="searchOption">
								 <option value="name">Name</option>
								 <option value="song">Song</option>
								 <option value="artist">Artist</option>
								 <option value="album">Album</option>
								 <option value="genre">Genre</option>
								 <option value="price">Price</option>
							</select>						
						</div>

						
						
						<button class="btn btn-primary form-control" type="button" data-toggle="collapse" data-target="#advancedSearch">
							Advanced Search Options</button>						
					</div>
				
					<div class="form-group collapse p-0 m-0" id="advancedSearch">
						<div class="form-row p-0 m-0" >
							<input class="form-control" type="search" name="minPrice" placeholder="Minimum Price:">
						</div>
						<div class="form-row p-0 m-0">
							<input class="form-control" type="search" name="maxPrice" placeholder="Maximum Price">							
						</div>					
					</div>	
					<button class="form-control btn btn-success" type="submit" name="search-btn">Search</button>					
				</form>
			</div>
			<!-- 			END SEARCH BAR -->
			
			
			
			<!-- 			START CONTENT -->
			<div class="border">
				<!-- INSERT TAB DIV HERE -->
				<div class="container-fluid">
					<ul class="nav nav-tabs" role="tablist">
						<li class="nav-item col-3"><a class="nav-link active h4"
							data-toggle="tab" href="#albums">Album</a></li>
						<li class="nav-item col-3"><a class="nav-link h4"
							data-toggle="tab" href="#artists">Artist</a></li>
						<li class="nav-item col-3"><a class="nav-link h4"
							data-toggle="tab" href="#songs">Song</a></li>
						<li class="nav-item col-3"><a class="nav-link h4"
							data-toggle="tab" href="#genres">Genre</a></li>
					</ul>
					<div class="container-fluid">
						<div class="tab-content">
							<div id="albums" class="tab-pane active">
								<h3>Albums</h3>
								<div class="row">
									<c:forEach items="${albums}" var="album">
										<div class="col-md-2" class="w-100">
											<a href="/album/${album.id}" class="album-poster"><img
												src="img/album/Album_${album.id}.png"></a>
											<h4>${album.name}</h4>
											<p>${album.artist.name}</p>
										</div>
									</c:forEach>
								</div>
							</div>
							<div id="artists" class="tab-pane">
								<h3>Artists</h3>
								<div class="row">
									<c:forEach items="${artists}" var="artist">
										<div class="col-md-2" class="w-100">
											<a href="/artist/${artist.id}" class="album-poster"><img
												src="img/artist/Artist_${artist.id}.png"></a>
											<h4>${artist.name}</h4>
											<p>${artist.location}</p>
										</div>
									</c:forEach>
								</div>
							</div>
							<div id="songs" class="tab-pane">
								<h3>Songs</h3>
								<div class="row">
									<table class="table table-dark table-striped">
										<tr>
											<th class="col-1">#</th>
											<th class="col-1"></th>
											<th class="col-4">NAME</th>
											<th class="col-3">ALBUM</th>
											<th class="col-3">ARTIST</th>
										</tr>
										<c:forEach items="${songs}" var="song">
											<tr>
												<th scope="row">${song.id}</th>
												<td><a href="/album/${song.album.id}"
													class="album-poster"><img
														src="img/album/Album_${song.album.id}.png" class="w-100"></a></td>
												<td><a href="/song/${song.id}" class="song-link">${song.name}</a></td>
												<td><a href="/album/${song.album.id}"
													class="song-link">${song.album.name}</a></td>
												<td><a href="/artist/${song.artist.id}"
													class="song-link">${song.artist.name}</a></td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
							<div id="genres" class="tab-pane">
								<h3>Genres</h3>
								<div class="row">
									<table class="table table-dark table-striped">
										<tr>
											<th class="col-1">#</th>
											<th class="col-4">NAME</th>
											<th class="col-4">DESCRIPTION</th>
										</tr>
										<c:forEach items="${genres}" var="genre">
											<tr>
												<th scope="row">${genre.id}</th>
							 					<td><a href="/genre/${genre.id}" class="song-link">${genre.name}</a></td>
												<td>${genre.description}</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>



						</div>
					</div>
				</div>




















			</div>
			<!-- 			END CONTENT -->
		</div>
		<!-- 		END MAIN CONTENT -->
	</div>
	<!-- END CONTAINER -->












	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
		crossorigin="anonymous"></script>
</body>
</html>