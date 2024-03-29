<!-- Page to add/edit movie details -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Movie Information</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Movie</h1>
		<form:form action="saveMovie" method="post" modelAttribute="movie">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Title:</td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td>Genre:</td>
				<td><form:input path="genre" /></td>
			</tr>
			<tr>
				<td>Length:</td>
				<td><form:input path="length" /></td>
			</tr>
			<tr>
				<td>Year:</td>
				<td><form:input path="year" /></td>
			</tr>
			<tr>
				<td>PG Rating:</td>
				<td><form:input path="pgRating" /></td>
			</tr>
			<tr>
				<td>Poster URL:</td>
				<td><form:input path="posterUrl" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>