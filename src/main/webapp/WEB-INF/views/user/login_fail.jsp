<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}/" />
<script>
    alert("로그인 실패, 아이디 비밀번호 다시확인");
    location.href = "${root}user/login?fail=true";
</script>