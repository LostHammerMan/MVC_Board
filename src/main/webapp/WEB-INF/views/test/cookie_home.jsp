<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}/" />
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Cookie</h1>
    <a href="${root}save_cookie">save_cookie</a><br>
    <a href="${root}load_cookie">load_cookie</a><br>
    <a href="${root}load_cookie2">load_cookie2</a><br>
</body>
</html>
