<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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

		<title>Artist ${artist.id} test</title>
		
	</head>
	<body>
		<!-- START MAIN CONTAINER -->
		<div class="container main">
			<div class="main">
				<!-- 			START NAVBAR -->
				<nav class="conatiner-fluid navbar navbar-expand-lg navbar-light bg-light">
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">
						<span class="navbar-toggler-icon"></span>
					</button>
					<a class="navbar-brand" href="/home">BRAND LOGO</a>
					<button type="submit" class="btn btn-success float-right"><i class="fa fa-shopping-cart"></i> Cart</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item active">
								<a class="nav-link" href="/home">Home <span class="sr-only">(current)</span> </a>
							</li>
							<li class="nav-item"><a class="nav-link" href="#">About</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Other</a>
							</li>
						</ul>
					</div>
				</nav>
				<!-- 			END NAVBAR -->
			</div>
			
			
			<!-- START MINITRON -->
			<div class="minitron border">
				<div class="row">
					<div class="p-5 col-md-5 text-center btn btn-outline-success minitron-inside">
						<h1>${genre.name}</h1>
					</div>
					<div class="titles col-md-7 p-5">
						<div class="col-12 text-center">
							<h2>${genre.description}</h2>
						</div>
					</div>
				</div>
			</div>
			<!-- END MINITRON -->
			
			
			<!-- START CONTENT -->
			<div class="container-fluid">
				<div class="row overflow-auto" >
				
					<!-- COLLAPSE BUTTON ALBUMS -->
					<div class="container p-5 mb-5">
						<a class="col-md-12 navbar h1 title-genre" href="#albums" role="button" data-toggle="collapse">${genre.name} Albums</a>
						<div class="collapse" id="albums">
							<div class="container">
								<div class="row">
									<div class="row">
										<c:forEach items="${genre.album}" var="album">
											<div class="col-md-2" class="w-100">
												<a href="/album/${album.id}" class="album-poster"><img src="../img/album/Album_${album.id}.png"></a>
												<h4>${album.name}</h4>
												<p><a href="/artist/${album.artist.id}" class="name-link">${album.artist.name}</a></p>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>					
					</div>
					
					<!-- COLLAPSE BUTTON SONGS -->
					<div class="container p-5 mb-5">
						<a class="col-md-12 navbar h1 title-genre" href="#songs" role="button" data-toggle="collapse">${genre.name} Songs</a>
						<div class="collapse" id="songs">
							<div class="container">
								<div class="row">
									<div class="row">
										<c:forEach items="${genre.album}" var="album_genre">
											<c:forEach items="${album_genre.song}" var="song">
												<div class="col-md-2" class="w-100">
													<a href="/album/${song.id}" class="album-poster"><img src="../img/album/Album_${album_genre.id}.png"></a>
													<h4>${song.name}</h4>
													<p><a href="/artist/${album.artist.id}" class="name-link">${album_genre.artist.name}</a></p>
												</div>
											</c:forEach>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>					
					</div>
					
			
	
							
	
<!-- 					<div class="col-md-12"> -->
<!-- 						<h3>NEW RELEASES</h3> -->
<!-- 					</div> -->
					
<!-- 					<div class="col-md-3"> -->
<!-- 						<a href="" class="album-poster"><img src="the_album.png"></a> -->
<!-- 						<h4>THE ALBUM</h4> -->
<!-- 						<p>BLACKPINK</p> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
			
			
			
			<!--  END CONTENT -->

			
		
		</div>
		<!-- END MAIN CONTAINER -->
	</body>
</html>