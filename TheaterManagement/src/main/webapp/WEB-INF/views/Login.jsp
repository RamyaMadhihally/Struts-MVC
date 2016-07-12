<!--  Login page -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cinema Management Systems ~ Login</title>
</head>
<body>
<h2> Login</h2>
<form:form method="post"  commandName="loginForm" action="Login" >
   <table>
  <tr> <form:hidden path="role"/></tr>
    <tr>
        <td><form:label path="userName">Username</form:label></td>
        <td><form:input path="userName" /></td>
    </tr>
    <tr>
        <td><form:label path="Password">Password</form:label></td>
        <td><form:password path="password" /></td>
    </tr>
     <tr>
        <td colspan="2">
            <input type="submit" value="Login"/>
        </td>
    </tr>
    </table>
    </form:form>
</body>
</html>