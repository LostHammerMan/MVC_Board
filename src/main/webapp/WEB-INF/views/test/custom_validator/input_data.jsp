<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>input_data</h1>
  <form:form action="input_pro" modelAttribute="dataBean1" method="post">

      data 1: <form:input path="data1" /><br>
              <form:errors path="data1" /><br>

      data 2 : <form:input path="data2" /><br>
               <form:errors path="data2" cssStyle="color: red"/><br>

      data 3 : <form:input path="data3" /><br>
                <form:errors path="data3" cssStyle="color: red"/><br>
    <form:button type="submit">확인</form:button>
  </form:form>
</body>
</html>
