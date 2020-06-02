<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
<center>
    <table>
        <tr>
            <td>id</td>
            <td>账户</td>
            <td>密码</td>
            <td>是否有效</td>
        </tr>
    <c:forEach var="v" items="${aa}">
        <tr>
            <td>${v.id}</td>
            <td>${v.username}</td>
            <td>${v.password}</td>
            <td>${v.state}</td>
        </tr>
    </c:forEach>
    </table>
</center>
</body>
</html>
