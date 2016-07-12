<!--  Error handling -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Oops! Looks like something went wrong</h3>
<div><img border="0" src="http://previews.123rf.com/images/arcady31/arcady311102/arcady31110200028/8885322-oops-icon-error-oops-sorry.jpg" width="100" height="100"></div>
 <b>Technical details<br><br> </b>${ex.message}
 <br><br>
 <div><b>We'll fix this soon!</b></div>
</body>
</html>