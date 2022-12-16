<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>input_data</h1>
  <form:form action="input_pro" modelAttribute="dataBean1" method="post">

    <form:button type="submit">확인</form:button>
  </form:form>
</body>
</html>
