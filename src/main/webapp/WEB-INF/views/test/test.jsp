<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<c:set var="root" value="${pageContext.request.contextPath}/" />
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="${root}test">
    <div>
      <label for="data1">데이타 1</label>
      <input type="text" id="data1">
    </div>
    <div>
      <label for="data2">데이타 2</label>
      <input type="text" id="data2">

    </div>
    <button id="sendForm" type="button">전송</button>
  </form>
  <script>
    $(document).ready(function () {
      $("#sendForm").on("click", function () {
         let $data1 = $("#data1");
         let $data2 = $("#data2");

        // 변수 선언시 지역 변수로 선언해야 변수 값이 덮어씌워지지 않음
        let obj = {
          "data1" : $data1.val(),
          "data2" : $data2.val()
        }

        $.ajax({
          url : "${root}test2",
          type : "post",
          data : JSON.stringify(obj),
          contentType : "application/json; charset=utf-8",
          success : function (data){

              alert("json 전송 성공");
              console.log(data);

          }
        })


        });



    });





  </script>
</body>
</html>
