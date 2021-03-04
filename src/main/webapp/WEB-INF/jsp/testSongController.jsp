<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link 	rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Song</title>
</head>

<body>

<%-- <img src = "${allsong.album.getImage()}">
<div>
	<c:forEach items="${allSongs}" var="song">
    	<p>Song Id: ${song.getId()}</p>
    	<p>Song Name: ${song.getName()}</p>
    	<p>Song Price: ${song.getPrice()}</p>
    	<p>Song Inventory: ${song.getInventory()}</p>
    	<p>Album Name: ${song.album.getName()}</p>
	</c:forEach>
</div>
 --%>

<br>
<br>

<form class="form-inline" action = "searchById" method="post"> 
 	<div class="form-group mx-sm-3 mb-2"> 
		<input class = "form-control" type="text" id="id" name="id" placeholder = "Song ID">
	</div>     
	<button type="submit" class="btn btn-primary mb-2">Search</button>
	
	<div class="form-group mx-sm-3 mb-2"> 
		<input class = "form-control" type="text" id="name" name="name" placeholder = "Song Name">
	</div>     
	<button type="submit" class="btn btn-primary mb-2">Search</button>
	
	<div class="form-group mx-sm-3 mb-2"> 
		<input class = "form-control" type="text" id="minPrice" name="minPrice" placeholder = "Min Price">
		<input class = "form-control" type="text" id="maxPrice" name="maxPrice" placeholder = "Max Price">
	</div>     
	<button type="submit" class="btn btn-primary mb-2">Search</button>
	
	<div class="form-group mx-sm-3 mb-2"> 
		<input class = "form-control" type="text" id="albumName" name="albumName" placeholder = "Album Name">
	</div>     
	<button type="submit" class="btn btn-primary mb-2">Search</button>
	
	<div class="form-group mx-sm-3 mb-2"> 
		<input class = "form-control" type="text" id="artistName" name="artistName" placeholder = "Artist Name">
	</div>     
	<button type="submit" class="btn btn-primary mb-2">Search</button>
</form>


<br>
${songIdNotFound}
<br>
<br>
${songNameNotFound}
<br>
<br>
${songPriceNotFound}
<br>
<br>
${songAlbumNotFound}
<br>
<br>
${songArtistNotFound}
<br>

<div id="content">
	<table class="table-bordered">
		<tr>
			<th scope="col">Cover</th>
			<th scope="col">Name</th>
			<th scope="col">Price</th>
			<th scope="col">Album</th>
		</tr>
		<tr>
			<td>${songFoundById.album.getImage()}</td>
			<td>${songFoundById.getName()}</td>
			<td>${songFoundById.getPrice()}</td>
			<td>${songFoundById.album.getName()}</td>
		</tr>
	</table>
</div>

<div>
	<c:forEach items="${songFoundByName}" var="song">
		<p>Song Id: ${song.getId()}</p>
		<p>Song Name: ${song.getName()}</p>
		<p>Song Price: ${song.getPrice()}</p>
		<p>Song Inventory: ${song.getInventory()}</p>
		<p>Album Name: ${song.album.getName()}</p>
	</c:forEach>
</div>

<div>
	<c:forEach items="${songFoundByPrice}" var="song">
		<p>Song Id: ${song.getId()}</p>
		<p>Song Name: ${song.getName()}</p>
		<p>Song Price: ${song.getPrice()}</p>
		<p>Song Inventory: ${song.getInventory()}</p>
		<p>Album Name: ${song.album.getName()}</p>
	</c:forEach>
</div>

<div>
	<c:forEach items="${songFoundByAlbumName}" var="song">
		<p>Song Id: ${song.getId()}</p>
		<p>Song Name: ${song.getName()}</p>
		<p>Song Price: ${song.getPrice()}</p>
		<p>Song Inventory: ${song.getInventory()}</p>
		<p>Album Name: ${song.album.getName()}</p>
	</c:forEach>
</div>

<div>
	<c:forEach items="${songFoundByArtistName}" var="song">
		<p>Song Id: ${song.getId()}</p>
		<p>Song Name: ${song.getName()}</p>
		<p>Song Price: ${song.getPrice()}</p>
		<p>Song Inventory: ${song.getInventory()}</p>
		<p>Album Name: ${song.album.getName()}</p>
	</c:forEach>
</div>


<%-- <div>
	<p>Song Id: ${songFoundById.getId()}</p>
	<p>Song Name: ${songFoundById.getName()}</p>
	<p>Song Price: ${songFoundById.getPrice()}</p>
	<p>Song Inventory: ${songFoundById.getInventory()}</p>
	<p>Album Name: ${songFoundById.album.getName()}</p>
</div> --%>


<%--<form action = "searchByName" method="post">    
	    <label for="songName">Song Name:</label>
	    <input type="text" id="name" name="name"><br><br>
	    
	    <input type="submit" value="Submit"><br><br>
</form> --%>

<%-- <form action = "searchByPriceRange" method="post">    
	    <label for="songPrice">Song Min Price:</label>
	     <input type="text" id="minPrice" name="minPrice"><br><br>
	    <label for="songPrice">Song Max Price:</label>
	    <input type="text" id="maxPrice" name="maxPrice"><br><br>
	    
	    <input type="submit" value="Submit"><br><br>
</form> --%>

<%--<form action = "searchByAlbumName" method="post">    
	    <label for="albumName">Album Name:</label>
	    <input type="text" id="albumName" name="albumName"><br><br>
	    
	    <input type="submit" value="Submit"><br><br>
</form>--%>

<%--<form action = "searchByArtistName" method="post">    
	    <label for="artistName">Artist Name:</label>
	    <input type="text" id="artistName" name="artistName"><br><br>
	    
	    <input type="submit" value="Submit"><br><br>
</form>--%>


</body>
</html>