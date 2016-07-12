
<!-- This page is a confirmation page on purchasing tickets for a movie -->
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
    <img border="0" src="http://corrupteddevelopment.com/wp-content/uploads/2012/02/retro-movie-ticket.jpg" width="400" height="200">
     <div><a href="listShowing">Back to All Shows</a></div>
    	<div align="center">
	        <h1>We've reserved your tickets, Enjoy the show!</h1>
	        <table border="1">	
	        	<tr>
	        	<th>Order Summary</th></tr>   
	        	<tr><td>Confirmation# ${confirmationNumber}</td></tr>     		
	        	<tr><td>${show.title}</td></tr>	
	        	<tr><td>Start Time: ${show.startTime}</td></tr>	
	        	<tr><td>Room ${show.roomNumber}</td></tr>	         	
	        	<tr><td>No: of Tickets: ${order.quantity}</td></tr>
	        	<tr><td>Total Price: $${show.price} * ${order.quantity} = $${totalPrice}</td></tr>
	        	<tr><td>Payment Method: ${paymentMethod}</td></tr>	        	
			</table>
		</div>    	
    </body>
</html>
