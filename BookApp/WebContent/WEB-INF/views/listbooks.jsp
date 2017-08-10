<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>所有书籍列表</h3>
 <c:if test="${empty requestScope.books}">
        没有书籍信息
    </c:if>
    <c:if test="${!empty requestScope.books }">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Author</th>
                <th>Price</th>
                <th>Publisher</th>
                <th colspan="2">Operation</th>
            </tr>
             
            <c:forEach items="${requestScope.books }" var="book">
                <tr>
                    <td>${book.id }</td>
                    <td>${book.name }</td>
                    <td>${book.author }</td>
                    <td>${book.price }</td>
                    <td>${book.publisher }</td>
                    <td><a href="editbook/${book.id}">Edit</a></td>
                    <td><a href="deletebook/${book.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <br><br>
    <a href="main">主界面</a>&nbsp;&nbsp;<a href="logout">退出</a>
</body>
</html>