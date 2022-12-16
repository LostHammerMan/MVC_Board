<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}/" />
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${root}test_Bean_java">testBeanJava</a><br>
    <hr>
    <a href="${root}test_sessionScope">test_sessionScope1</a><br>
    <a href="${root}test_sessionScope_result">result_sessionScope1</a><br>
    <hr>
    <a href="${root}test_sessionScope2">test_sessionScope2</a><br>
    <a href="${root}test_sessionScope3">test_sessionScope3</a><br>
    <a href="${root}test_sessionScope_result2">result_sessionScope2</a><br>
    <hr>
    <a href="${root}test_sessionScope4">test_sessionScope4</a><br>
    <a href="${root}test_sessionScope_result4">result_sessionScope4</a><br>
    <hr>
    <a href="${root}test_sessionScope5">test_sessionScope4</a><br>
    <a href="${root}test_sessionScope_result5">result_sessionScope5</a><br>
    <hr>
    <a href="${root}test_session_bean1">test_session_bean1</a><br>
    <a href="${root}test_session_bean1_result1">test_session_bean1_result1</a><br>
    <hr>
    <h1>ApplicationScope</h1><br>
    <a href="${root}test_ApplicationScope1">test_ApplicationScope1</a><br>
    <a href="${root}test_ApplicationScope1_result1">test_ApplicationScope1_result1</a><br>






</body>
</html>
