<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
			</div>
			
			
			<!-- START JUMBOTRON -->
			<div class="jumbotron border">
				<div class="row">
					<div class="main-img p-5 col-md-5 img-thumbnail">
						<img src="../img/artist/Artist_${artist.id}.png">
					</div>
					<div class="row titles col-md-7 p-5">
						<div class="col-12 text-center">
							<h1>${artist.name}</h1>
							<h2>${artist.location}</h2>
						</div>
					</div>
				</div>
			</div>
			
			
			
			
			<!-- START CONTENT -->
			<div class="main">
				<!-- INSERT TAB DIV HERE -->
				<div class="container-fluid">
					<ul class="nav nav-tabs" role="tablist">
						<li class="nav-item col-4"><a class="nav-link active h4"
							data-toggle="tab" href="#albums">Albums From Artist</a></li>					
						<li class="nav-item col-4"><a class="nav-link h4"
							data-toggle="tab" href="#songs">Songs From Artist</a></li>
						<li class="nav-item col-4"><a class="nav-link h4"
							data-toggle="tab" href="#genres">Artist Genres</a></li>
					</ul>
					<div class="container-fluid">
						<div class="tab-content">
							<div id="albums" class="tab-pane active">
								<h3>Albums: ${artist.name}</h3>
								<div class="row">
									<c:forEach items="${artist.album}" var="album">
										<div class="col-md-2" class="w-100">
											<a href="/album/${album.id}" class="album-poster"><img
												src="../img/album/Album_${album.id}.png"></a>
											<h4>${album.name}</h4>
											<p>${artist.name}</p>
										</div>
									</c:forEach>
								</div>
							</div>
							<div id="songs" class="tab-pane">
								<h3>Songs: ${artist.name}</h3>
								<div class="row">
									<table class="table table-dark table-striped">
										<tr>
											<th class="col-1">#</th>
											<th class="col-1"></th>
											<th class="col-4">NAME</th>
											<th class="col-3">ALBUM</th>
											<th class="col-3">ARTIST</th>
										</tr>
										<c:forEach items="${artist.songs}" var="song">
											<tr>
												<th scope="row">${song.id}</th>
												<td>
													<a href="/album/${song.album.id}" class="album-poster"><img src="../img/album/Album_${song.album.id}.png"></a>
												</td>
												<td>
													<a href="/song/${song.id}" class="song-link">${song.name}</a>
												</td>
												<td>
													<a href="/album/${song.album.id}" class="song-link">${song.album.name}</a>
												</td>
												<td><a href="/artist/${artist.id}" class="song-link">${artist.name}</a></td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
							<div id="genres" class="tab-pane">
								<h3>Genres: ${artist.name}</h3>
								<div class="row">
									<table class="table table-dark table-striped">
										<tr>
											<th class="col-1">#</th>
											<th class="col-1"></th>
											<th class="col-3">ALBUM</th>
											<th class="col-3">ARTIST</th>
										</tr>
										<c:forEach items="${artist.album}" var="album">
											<tr>
												<th scope="row">${album.id}</th>
												<td><a href="/album/${album.id}" class="album-poster">
													<img src="../img/album/Album_${album.id}.png" class="w-100"></a>
												</td>
												<td><a href="/album/${album.id}" class="song-link">${album.name}</a>
												</td>
												<td><a href="/artist/${album.genre.id}" class="song-link">${album.genre.name}</a>
												</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- START CONTENT -->


			
		
		</div>
		<!-- END MAIN CONTAINER -->
	</body>
</html>