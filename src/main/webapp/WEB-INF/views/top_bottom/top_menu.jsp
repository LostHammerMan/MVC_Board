<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"  %>
<c:set var="root" value="${pageContext.request.contextPath}/" />
<!-- 상단 메뉴 부분 -->
<nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top shadow-lg">
    <a class="navbar-brand" href="${root}main">SoftCampus</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navMenu">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navMenu">
        <ul class="navbar-nav">
<%--            <li class="nav-item">--%>
<%--                <a href="${root}board/main" class="nav-link">자유게시판</a>--%>
<%--            </li>--%>
<%--            <li class="nav-item">--%>
<%--                <a href="${root}board/main" class="nav-link">유머게시판</a>--%>
<%--            </li>--%>
<%--            <li class="nav-item">--%>
<%--                <a href="${root}board/main" class="nav-link">정치게시판</a>--%>
<%--            </li>--%>
<%--            <li class="nav-item">--%>
<%--                <a href="${root}board/main" class="nav-link">스포츠게시판</a>--%>
<%--            </li>--%>

            <c:forEach var="obj" items="${topMenuList}" >
                <li class="nav-item">
                    <a href="${root}board/main?board_info_idx=${obj.board_info_idx}" class="nav-link"
                       >${obj.board_info_name}</a>
                </li>
            </c:forEach>
        </ul>
        <ul class="navbar-nav ml-auto">
<%--            <c:choose>--%>
<%--                <c:when test="${loginUserBean.userLogin == true}">--%>
<%--                <c:when test="${loginUserBean.userLogin == true}">--%>
<%--    표현식이 지정한 권한에 맞을 때만 출력--%>
<%--   로그인이 되어 있는 경우--%>
            <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a href="${root}user/modify" class="nav-link">정보수정</a>
                    </li>
                    <li class="nav-item">
                        <a href="${root}user/logout" class="nav-link">로그아웃</a>
                    </li>
            </sec:authorize>
<%--                </c:when>--%>
<%--                <c:otherwise>--%>
<%--    로그인이 되어 있지 않은 경우--%>
            <sec:authorize access="isAnonymous()">
                    <li class="nav-item">
                        <a href="${root}user/login" class="nav-link">로그인</a>
                    </li>
                    <li class="nav-item">
                        <a href="${root}user/join" class="nav-link">회원가입</a>
                    </li>
            </sec:authorize>
<%--                </c:otherwise>--%>
<%--            </c:choose>--%>

        </ul>
    </div>
</nav>
