<!--  Page to add a new movie show -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Showing</title>
</head>
 <body>
    	<div align="center">
	        <h1>Shows</h1>
	       <h3><a href="newShowing">Create New Showing</a></h3>
	        <table border="1">
	        <tr>
	        	<th>#</th>
	        	<!-- <th>Title</th> -->
	        	<!-- <th>showid</th> -->
	        	<th>Title</th>
	        	<th>Room Number</th>
	        	<th>Show Date</th>
	        	<th>Show Time</th>
	        	<!-- <th>Show Date</th> -->
	        	<th>AvailableSeats</th>
	        	<th>Price</th>	
	        	<th>Action</th>
	        	<th>#</th>	 
	        </tr>       	
				<c:forEach var="showing" items="${listShowing}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<%-- <td>${showing.title}</td> --%>
					<%-- <td>${showing.showid}</td> --%>
					<td>${showing.title}</td>
					<td>${showing.roomNumber}</td>
					<td><jsp:useBean id="startTime" class="java.util.Date"/>
<jsp:setProperty name="startTime" property="time" value="${timestampValue}"/>
<fmt:formatDate value="${showing.startTime}" pattern="MM/dd/yyyy "/></td>
	     	<td>
<jsp:setProperty name="startTime" property="time" value="${timestampValue}"/>
<fmt:formatDate value="${showing.startTime}" pattern="HH:mm "/></td>
					<%-- <td>${showing.showDate}</td> --%>
					<td>${showing.availableSeats}</td>
					<td>${showing.price}</td>					
					<td>					
						<a href="editShowing?showid=${showing.showid}">Edit Show</a>
						&nbsp;&nbsp;
						<a href="deleteShowing?showid=${showing.showid}">Delete Show</a>
					</td>
					<td><a href="bookShow?showid=${showing.showid}">Buy Tickets</a></td>							
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    </body>
</html>