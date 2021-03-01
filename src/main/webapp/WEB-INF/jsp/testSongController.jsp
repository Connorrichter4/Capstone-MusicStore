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
    	<p>Album Name: ${song.album.getAlbumName()}</p>
	</c:forEach>
</div>

<br>
<br>
<form action = "addSong" method="post">    
	    <label for="songName">Song Name:</label>
	    <input type="text" id="name" name="name"><br><br>
	    
	    <label for="price">Price:</label>
	    <input type="text" id="price" name="price"><br><br>
	    
	    <label for="inventory">inventory:</label>
	    <input type="text" id="inventory" name="inventory"><br><br>
	    
	    
	    
	    <input type="submit" value="Submit"><br><br>
	<!--     <input type="reset" value="Reset"><br><br> -->
	</form>
</body>
</html>