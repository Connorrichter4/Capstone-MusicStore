<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<img src = "${allsong.album.getImage()}">
<div>
	<c:forEach items="${allSongs}" var="song">
    	<p>Song Id: ${song.getId()}</p>
    	<p>Song Name: ${song.getName()}</p>
    	<p>Song Price: ${song.getPrice()}</p>
    	<p>Song Inventory: ${song.getInventory()}</p>
    	<p>Album Name: ${song.album.getName()}</p>
	</c:forEach>
</div>


<br>
<br>
<form action = "searchById" method="post">    
	    <label for="songId">Search By Song ID:</label>
	    <input type="text" id="id" name="id"><br><br>
	    
	    <input type="submit" value="Submit"><br><br>

</form>
<br>
<br>
${songIdNotFound}
<br>


<div id="content">
	<table class="table">
		<tr>
			<th scope="col">Song Name</th>
			<th scope="col">Song Price</th>
			<th scope="col">Album Name</th>
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

</div>



<div>
	<p>Song Id: ${songFoundById.getId()}</p>
	<p>Song Name: ${songFoundById.getName()}</p>
	<p>Song Price: ${songFoundById.getPrice()}</p>
	<p>Song Inventory: ${songFoundById.getInventory()}</p>
	<p>Album Name: ${songFoundById.album.getName()}</p>
</div>

<br>
<br>
<form action = "searchByName" method="post">    
	    <label for="songName">Song Name:</label>
	    <input type="text" id="name" name="name"><br><br>
	    
	    <input type="submit" value="Submit"><br><br>
</form>

<br>
<br>
${songNameNotFound}
<br>
<div>
	<c:forEach items="${songFoundByName}" var="song">
		<p>Song Id: ${song.getId()}</p>
		<p>Song Name: ${song.getName()}</p>
		<p>Song Price: ${song.getPrice()}</p>
		<p>Song Inventory: ${song.getInventory()}</p>
		<p>Album Name: ${song.album.getName()}</p>
	</c:forEach>
</div>

<form action = "searchByPriceRange" method="post">    
	    <label for="songPrice">Song Min Price:</label>
	     <input type="text" id="minPrice" name="minPrice"><br><br>
	    <label for="songPrice">Song Max Price:</label>
	    <input type="text" id="maxPrice" name="maxPrice"><br><br>
	    
	    <input type="submit" value="Submit"><br><br>
</form>

<br>
${songPriceNotFound}
<br>
<div>
	<c:forEach items="${songFoundByPrice}" var="song">
		<p>Song Id: ${song.getId()}</p>
		<p>Song Name: ${song.getName()}</p>
		<p>Song Price: ${song.getPrice()}</p>
		<p>Song Inventory: ${song.getInventory()}</p>
		<p>Album Name: ${song.album.getName()}</p>
	</c:forEach>
</div>
<br>

<form action = "searchByAlbumName" method="post">    
	    <label for="albumName">Album Name:</label>
	    <input type="text" id="albumName" name="albumName"><br><br>
	    
	    <input type="submit" value="Submit"><br><br>
</form>

<br>
${songAlbumNotFound}
<br>
<div>
	<c:forEach items="${songFoundByAlbumName}" var="song">
		<p>Song Id: ${song.getId()}</p>
		<p>Song Name: ${song.getName()}</p>
		<p>Song Price: ${song.getPrice()}</p>
		<p>Song Inventory: ${song.getInventory()}</p>
		<p>Album Name: ${song.album.getName()}</p>
	</c:forEach>
</div>
<br>

<br>
<form action = "searchByArtistName" method="post">    
	    <label for="artistName">Artist Name:</label>
	    <input type="text" id="artistName" name="artistName"><br><br>
	    
	    <input type="submit" value="Submit"><br><br>
</form>

<br>
${songArtistNotFound}
<br>
<div>
	<c:forEach items="${songFoundByArtistName}" var="song">
		<p>Song Id: ${song.getId()}</p>
		<p>Song Name: ${song.getName()}</p>
		<p>Song Price: ${song.getPrice()}</p>
		<p>Song Inventory: ${song.getInventory()}</p>
		<p>Album Name: ${song.album.getName()}</p>
	</c:forEach>
</div>
<br>

</body>
</html>