<!--  Page to search movie info -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
</head>
<body>
	<div align="center">
		<h1>Search your favorite Movies</h1>
		<form:form action="searchResult" method="post" modelAttribute="searchCriteria">
			<table>
				<tr>
					<td>Title&nbsp;&nbsp;<form:input path="movie.title" size="25" /></td>
					<td>Genre&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:input path="movie.genre" size="25" /></td>
					<td>Year&nbsp;&nbsp;&nbsp;&nbsp;<form:input path="movie.year" size="25" /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
				<td>Actor&nbsp;<form:input path="actor.name" size="25" /></td>
				<td>Director&nbsp;&nbsp;<form:input path="director.name" size="25" /></td>
				<td>Writer&nbsp;&nbsp;<form:input path="writer.name" size="25" /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
				<td></td>
					<td align="center"><input type="submit" value="Search Movies"></td>
				<td></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>