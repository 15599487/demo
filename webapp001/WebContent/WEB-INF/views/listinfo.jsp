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
    <c:if test="${empty requestScope.infos}">
        没有员工信息
    </c:if>
    <c:if test="${!empty requestScope.infos }">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Introduction</th>
                <th colspan="2">Operation</th>
            </tr>
             
            <c:forEach items="${requestScope.infos }" var="emp">
                <tr>
                    <td>${emp.id }</td>
                    <td>${emp.name }</td>
                    <td>${emp.intro }</td>
                    <td><a href="editinfo/${emp.id}">Edit</a></td>
                    <td><a href="deleteinfo/${emp.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <br><br>
</body>
</html>