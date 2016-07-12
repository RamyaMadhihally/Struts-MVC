<!-- Page to add/edit the show info for a movie -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Showing Information</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Showing</h1>
		<form:form action="saveShowing" method="post" modelAttribute="showing">
		<table>
					<tr>
				<!-- <td>Show ID:</td> -->
				<td><form:hidden path="showid" value='<%=request.getParameter("showid")%>' /></td>
			</tr>
		
			<tr>
				 <td>Movie Title:</td> 
				<td><form:input path="title" /></td>
			</tr>
			
			<%-- <tr>
				<td>Title :</td>
				<td><form:input path ="title" /></td>
			</tr>
			 --%>
			
			<tr>
				<td>Room:</td>
				 <%-- <td><form:input path="roomNumber" /></td>  --%> 
				<td>
				<form:select id="dropdown" path="roomNumber">
				<c:forEach var="room" items="${roomNumber}">
				<option value="${item.key}" label = "--Please Select--" ${item.key == room_Number ? 'selected="selected"' : ''}>${item.value}</option>
   
				<option value="1" 
    				<c:if test="${param.selectValue == 1})"> Room </c:if> >
   					  1 
 			   		 </option>
					 <option value="2" 
    				 <c:if test="${param.selectValue == 2})"> Room  </c:if> >
   				 	 2
  					 </option>
  					 <option value="3" 
    				 <c:if test="${param.selectValue == 3})"> Room  </c:if> >
   					 3
  					 </option>
				</c:forEach>
				
				</form:select>
			
				</td>
			 
				
				
			</tr>
			<tr>
				<td>Available Seats:</td>
				<td><form:input path="availableSeats" /></td>
			</tr>
			<tr>
				<td>Start Time:</td>
				<td><form:input path="startTime" /></td>
			</tr>

			<tr>
				<td>Price:</td>
				<td><form:input path="price" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>