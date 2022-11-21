<%--
  Created by IntelliJ IDEA.
  User: seong
  Date: 2022-11-21
  Time: 오후 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>joinB</h1>
    <form action="${root}user/joinBPro" method="post">
        <input type="text" name="data1" value="${data.data1}">
        <input type="text" name="data2" value="${data.data2}">
        <input type="text" name="data3" value="${data.data3}">
        <button>제출</button>
    </form>
</body>
</html>
