<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="root" value="${pageContext.request.contextPath}/" />
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://code.jquery.com/jquery-3.6.1.js"
            integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
            crossorigin="anonymous"></script>
    <style>
        #dataDiv{

        }
    </style>
    <title>Title</title>
</head>
<body>
  <a href="${root}test2?data1=100&data2=200&data3=300&data3=400">test1 get</a><br>
  <a href="${root}test3?data1=100&data2=200&data3=300&data3=400">test2 get</a><br>
  <div id="dataDiv">

      <div>
        <h1>result</h1><br>
      </div>
      <div>

          <h2>data1 = "${bean1.data1}"</h2>
          <h2>data2 = ${bean1.data2}</h2>
      </div>
  </div>
<script>

</script>
</body>
</html>
