<%--
  Created by IntelliJ IDEA.
  User: 84711
  Date: 2019/1/21
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>姓名</td>
    </tr>
    <c:forEach var="v" items="${dept}">
        <tr>
            <td>${v.did}</td>
            <td>${v.dname}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
