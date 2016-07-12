<!--  Page that is displayed on invalid login -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Error</title>
</head>
<body>
<h3>Exception occured</h3>
<div><img border="0" src="http://previews.123rf.com/images/arcady31/arcady311102/arcady31110200028/8885322-oops-icon-error-oops-sorry.jpg" width="100" height="100"></div>    
</div>
${ex.exceptionMsg}
</body>
</html>