<!--  This page displays the information about all the cast and crew of a movie; information can be added -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
    <head>
    <style type="text/css">
    </style>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${movieTitle} ~ Cast & Crew</title>
    </head>
    <body>
    <a href="movies">Back to Movies</a>    
    	<div align="center">
	        <h1>${movieTitle}</h1>	        
	        			
	        <h2>Actors</h2>
	        <h3><a href="addActorInfo?id=${movieId}">Add Actor</a></h3>
	        <table border="1">
	        <tr>
	        	<th>#</th>
	        	<th>Actor</th>
	        	<th>Role</th>
	        	<th>Date of Birth</th>
	        	<th>Poster</th>
	        	<th>Action</th>	        	
	        </tr>
				<c:forEach var="actor" items="${listActors}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${actor.name}</td>
					<td>${actor.roleName}</td>
					<td>${fn:substring(actor.birthDate, 0, 10)}</td>
					<td><IMG SRC="${actor.imageUrl}" WIDTH=100 HEIGHT=100></td>
					<td>
						<a href="deleteActor?id=${actor.actorid}&movieid=${movieId}">Delete</a>
					</td>							
	        	</tr>
				</c:forEach>	        	
			</table>	
			
	        <h2>Directed By</h2>
	        <h3><a href="addDirectorInfo?id=${movieId}">Add Director</a></h3>
	        <table border="1">
	        <tr>
	        	<th>#</th>
	        	<th>Name</th>
	        	
	        	<th>Date of Birth</th>
	        	
	        	<th>Poster</th>
	        	<th>Action</th>	        	
	        </tr>
				<c:forEach var="director" items="${listDirectors}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${director.name}</td>
					
					<td>${fn:substring(director.birthDate, 0, 10)}</td>
					
					<td><IMG SRC="${director.imageUrl}" WIDTH=100 HEIGHT=100></td>
					<td>
						<a href="deleteDirector?id=${director.directorid}&movieid=${movieId}">Delete</a>
					</td>							
	        	</tr>
				</c:forEach>	        	
			</table>
			
			<h2>Written By</h2>
	        <h3><a href="addWriterInfo?id=${movieId}">Add Writer</a></h3>
	        <table border="1">
	        <tr>
	        	<th>#</th>
	        	<th>Name</th>
	        	
	        	<th>Date of Birth</th>
	        	
	        	
	        	<th>Poster</th>
	        	<th>Action</th>	        	
	        </tr>
				<c:forEach var="writer" items="${listWriters}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${writer.name}</td>
					
						<td>${fn:substring(writer.birthDate, 0, 10)}</td>
						
					<td><IMG SRC="${writer.imageUrl}" WIDTH=100 HEIGHT=100></td>
					<td>
						<a href="deleteWriter?id=${writer.writerid}&movieid=${movieId}">Delete</a>
					</td>							
	        	</tr>
				</c:forEach>	        	
			</table>		
    	</div>
    </body>
</html>