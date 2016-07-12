<!--  This page is to book tickets for a movie showing at different times -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Tickets</title>
</head>
 <body> 
 <table>
 <tr>
 <td><IMG SRC="${movie.posterUrl}" WIDTH=200 HEIGHT=200></td>
 <td><IMG SRC="${movie.posterUrl}" WIDTH=200 HEIGHT=200></td>
 <td><IMG SRC="${movie.posterUrl}" WIDTH=200 HEIGHT=200></td>
 <td><IMG SRC="${movie.posterUrl}" WIDTH=200 HEIGHT=200></td>
 <td><IMG SRC="${movie.posterUrl}" WIDTH=200 HEIGHT=200></td>
 <td><IMG SRC="${movie.posterUrl}" WIDTH=200 HEIGHT=200></td>
 <td><IMG SRC="${movie.posterUrl}" WIDTH=200 HEIGHT=200></td>
 </tr>
 <tr><td> <a href="listShowing">Back to All Shows</a></td></tr>
 </table>
  <div align="center">
	        <h1>Book your Tickets</h1>
	        <h2>${movie.title}</h2>
	        <h4>Hurry, Only ${show.availableSeats} seats left!</h4>
	        <h4>The show starts  ${show.startTime} in Room ${show.roomNumber}</h4>
	        <h4>Ticket Price: $${show.price}</h4>	        

		<form:form action="purchaseOrder?showid=${show.showid}" method="post" modelAttribute="order">		
		<table id="table1">
			<form:hidden path="show.showid"/>
			<tr>
			<td>Payment Method:
				<form:select id="dropdown" path="paymentMethod">
				  <option  value="VISA">VISA</option>
				  <option value="Master Card">Master Card</option>
				  <option value="American Express">American Express</option>
				  <option value="Discover">Discover</option>
				  <option value="Debit">Debit</option>
				</form:select>			
			</td>
				<td>No: of Guests: <form:input path="quantity" value="1" /></td>	
				<td align="right"><input type="submit" value="Purchase Tickets"/></td>					
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>