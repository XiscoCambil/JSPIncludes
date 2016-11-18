<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Reading Cookies Example</title>
</head>


<body bgcolor="#f0f0f0">


<c:set var="lista" scope="session" value="hola"></c:set>
<c:out value="${lista}"></c:out>
<c:if test="${ 1 < 2 }">
    <p>funciona</p>
</c:if>


<c:if test="${ files.size() > 0 }">
    <h2> Found Cookies Name and Value</h2>
    <c:forEach items="${files}" var="name">
        <c:out value="${name}"/>
        <p>hola</p>
    </c:forEach>
</c:if>


</body>
</html>