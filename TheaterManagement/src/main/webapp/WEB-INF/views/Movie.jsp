<!--  Page to add movies, search and display the movies -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
    <style type="text/css">
    </style>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movies</title>
    </head>
    <body>
    <div align="right">Welcome ${login.userName}!&nbsp;&nbsp;<a href="/cinema"><img border="0" src="http://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/Crystal_Clear_action_exit.svg/300px-Crystal_Clear_action_exit.svg.png" width="20" height="20"></a></div>    
    <h3><a href="newMovie">Create Movie</a></h3>
    <h3><a href=newSearchCriteria>Search Movie</a></h3>
    <h3><a href="listShowing">All Shows</a></h3>
    	<div align="center">
	        <h1>Movies</h1>
	        <table border="1">
	        <tr>
	        	<th>#</th>
	        	<th>Title</th>
	        	<th>Genre</th>
	        	<th>Length</th>
	        	<th>Year</th>
	        	<th>PG Rating</th>
	        	<th>Poster</th>
	        	<th>Action</th>	        	
	        </tr>
				<c:forEach var="movie" items="${listMovie}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
	        		<td><a href="cast?id=${movie.id}">${movie.title}</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>${movie.genre}</td>
					<td>${movie.length}</td>
					<td>${movie.year}</td>
					<td>${movie.pgRating}</td>
					<td><IMG SRC="${movie.posterUrl}" ALT="${movie.title}" WIDTH=100 HEIGHT=100></td>
					<td>
						<a href="editMovie?id=${movie.id}"><img border="0" src="https://cdn1.iconfinder.com/data/icons/huge-black-icons/512/Notes.png" width="30" height="30"></a>
						<a href="deleteMovie?id=${movie.id}"><img border="0" src="http://megaicons.net/static/img/icons_title/8/178/title/editing-delete-icon.png" width="30" height="30"></a>
						<a href="movieShowing?id=${movie.id}"><img border="0" src="http://sansinichi.com/wp-content/uploads/2014/02/movie-icon.gif" width="30" height="30"></a>
					</td>							
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    </body>
</html>