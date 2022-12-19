<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}/" />
<html>
<head>
    <title>Title</title>
</head>
<body>
  <a href="${root}restAPI/test1">basic Controller</a><br>
  <a href="${root}restAPI/test2">rest Controller</a><br>
</body>
</html>
