<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}/" />
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${root}test5?data1=100&data2=300">test1 get</a><br>
    <hr />

    <form action="${root}test6" method="post">
        data1 : <input type="text" name="data1" /><br>
        data2 : <input type="text" name="data2" /><br>
        data3 : <input type="checkbox" name="data3" value="100" />data3 100
                <input type="checkbox" name="data3" value="200" />data3 200<br>
        <button type="submit">test2 post</button>
    </form>
</body>
</html>
