<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>Add Book</h3>
<form action="<%=request.getContextPath()%>/savebook" method="get">
	<input type="hidden" name="id" value="${book.id}"/>
	Name: <input type="text" name="name" value="${book.name}"/><p>
	Author:<input type="text" name="author" value="${book.author}" /><p>
	Price:<input type="text" name="price" value="${book.price}" /><p>
	Publisher:<input type="text" name="publisher" value="${book.publisher}" /><p>
	<input type="submit" value="AddBook"/>
</form>

</body>
</html>