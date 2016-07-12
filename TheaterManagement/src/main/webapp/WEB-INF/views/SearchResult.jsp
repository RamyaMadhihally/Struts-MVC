<!--  Page to display the movie information based on the searches -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie</title>
    </head>
    <body>
    	<div align="center">
	        <h1>We found your Movies!</h1>
	        <table border="1">	        	
				<c:forEach var="movie" items="${searchResult}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${movie.title}</td>
					<td>${movie.genre}</td>
					<td>${movie.length}</td>
					<td>${movie.year}</td>
					<td>${movie.pgRating}</td>
					<td><IMG SRC="${movie.posterUrl}" ALT="${movie.title}" WIDTH=100 HEIGHT=100></td>
					<td>
						<a href="cast?id=${movie.id}"><img border="0" src="https://cdn1.iconfinder.com/data/icons/education-set-4/512/information-2-128.png" width="30" height="30"></a>
						<a href="movieShowing?id=${movie.id}"><img border="0" src="http://sansinichi.com/wp-content/uploads/2014/02/movie-icon.gif" width="30" height="30"></a>				
					</td>					
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
		<div align= "center">
		<table>
		<tr></tr>
			 <tr><td><a href="newSearchCriteria">Start a New Search</a></td></tr> 
		</table>	
		</div>    	
    </body>
</html>
