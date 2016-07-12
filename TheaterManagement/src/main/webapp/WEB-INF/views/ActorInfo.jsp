
<!--  This page is add a new actor or update his/her info -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Actor Information</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Actor</h1>
		<form:form action="saveActor" method="post" modelAttribute="actor">
		<table>		
			<form:hidden path="movieid" value='<%=request.getParameter("id")%>'/>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
			<td>Gender:	</td>
			<td>
			<form:select id="dropdown" path="gender">
				  <option  value="Male">Male</option>
				  <option value="Female">Female</option>
			</form:select>		
			</td>			
			</tr>
			<tr>
				<td>Date of Birth:</td>
				<td><form:input path="birthDate" />(e.g. 26-JAN-2011)</td>
			</tr>			
			<tr>
				<td>Role Name:</td>
				<td><form:input path="roleName" /></td>
			</tr>
			<tr>
			<tr>
				<td>Poster URL:</td>
				<td><form:input path="imageUrl" /></td>
			</tr>			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>