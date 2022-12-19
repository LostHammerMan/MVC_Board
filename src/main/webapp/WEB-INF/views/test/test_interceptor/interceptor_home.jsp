<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}/" />
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>interceptor_home</h1>
  <hr>
  <a href="${root}interceptor_test1">interceptor_test1</a><br>
  <a href="${root}interceptor_test2">interceptor_test2</a><br>
   <hr>
  <a href="${root}sub1/interceptor_test3">sub1/interceptor_test3</a><br>
  <a href="${root}sub1/interceptor_test4">sub1/interceptor_test4</a><br>
</body>
</html>
