<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Add Info</h3>
<form action="<%=request.getContextPath()%>/saveinfo" method="get">
	<input type="hidden" name="id" value="${info.id}"/>
	Name: <input type="text" name="name" value="${info.name}"/><p>
	Introduction:<input type="text" name="intro" value="${info.intro}" /><p>
	<input type="submit" value="Add"/>
</form>
</body>
</html>