<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>미니 프로젝트</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/MVCProject/resources/js/addr.js"></script>
<script
			src="https://code.jquery.com/jquery-3.6.1.js"
			integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
			crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/MVCProject/resources/css/joinForm.css" />
<style>
	#joinForm{
		/*width: 2000px;*/
	}

	#sendMail{
		display: flex;
	}
</style>
</head>
<body>

<c:import url="/WEB-INF/views/top_bottom/top_menu.jsp" />

<div class="container" style="margin-top:100px" id="joinForm">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card shadow">
				<div class="card-body">
					<form:form action="${root}user/join_ok" method="post" modelAttribute="joinUserVO">
						<div class="form-group">
							<form:label path="user_name">이름</form:label>
							<form:input path="user_name" class="form-control" />

						</div>

						<div class="form-group">
							<form:label path="user_id">아이디</form:label>
							<div class="input-group">
								<form:input path="user_id" class="form-control" />
								<div class="input-group-append">
									<button type="button" class="btn btn-primary">중복확인</button>
								</div>
							</div>
						</div>
						<div class="form-group">
							<form:label path="user_pw">비밀번호</form:label>
							<form:password path="user_pw" class="form-control" />
						</div>
<%--						<div class="form-group">--%>
<%--							<label for="user_pw2">비밀번호 확인</label>--%>
<%--							<input type="password" id="user_pw2" name="user_pw2" class="form-control"/>--%>
<%--						</div>--%>
						<div class="form-group">
							<div id="sendMail">
								<form:label path="user_email">이메일</form:label>
								<form:input path="user_email" class="form-control" />&nbsp;&nbsp;
								<button id="checkEmail" class="btn btn-primary">인증</button>

							</div><br>
							<div>
								<label for="memailConfirm" id="memailconfirmTxt">인증번호를 입력해주세요</label>
								<input type="text" id="memailConfirm" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label>주소</label><br>

<%--							<input type="text" id="sample6_postcode" placeholder="우편번호">--%>
<%--							<input type="text" id="${joinUserVO.zipcode}" placeholder="우편번호">--%>
							<form:input path="zipcode" id="sample6_postcode" placeholder="우편번호" />
							<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>

<%--							<input type="text" id="sample6_address" placeholder="주소"><br>--%>
							<form:input path="user_addr" id="sample6_address" placeholder="주소" /><br>
<%--							<input type="text" id="sample6_detailAddress" placeholder="상세주소">--%>
							<form:input path="user_detail_addr" id="sample6_detailAddress" placeholder="상세주소" />
<%--							<input type="hidden" id="sample6_extraAddress" placeholder="참고항목">--%>
						</div>

						<div class="form-group">

							<form:label path="user_goal">목표 지정</form:label>

							<div class="form-check">
<%--									<input type="radio" id="program" name="user_goal" class="form-check-input" />--%>
								<form:radiobutton path="user_goal" value="programming" class="form-check-input" />프로그래밍


							</div>
								<div class="form-check">
									<form:radiobutton path="user_goal" value="nomu" class="form-check-input" /> 노무사
								</div>

						</div>

							<div class="form-group">
								<div class="text-right">
									<form:button class="btn btn-primary">회원가입</form:button>
								</div>
							</div>


					</form:form>
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>

<c:import url="/WEB-INF/views/top_bottom/bottom_menu.jsp" />

<script>

	let emconfirmchk = false;
$(document).ready(function (){

	let $user_email = $("#user_email");
	let $memailConfirm = $("#memailConfirm");
	let $memailconfirmTxt = $("#memailconfirmTxt");
	let $checkEmail = $("#checkEmail");

	$checkEmail.click(function (e){
		e.preventDefault();
		$.ajax({
			type : "post",
			url : "${root}user/mailConfirm",
			data : {
				"email" : $user_email.val()
			},
			success : function (data){
				alert("이메일 인증번호 발송 완료");
				console.log("data " + data);
				chkEmailConfirm(data, $memailConfirm, $memailconfirmTxt);
			}
		})
	})

	// 이메일 인증 번호 체크 함수
	function chkEmailConfirm(data, $memailConfirm, $memailconfirmTxt){
		$memailConfirm.on("keyup", function (){
			if (data != $memailConfirm.val()){
				emconfirmchk = false;
				$memailconfirmTxt.html("<span id='emconfirmchk'>인증번호가 잘못되었습니다</span>")
				$("#emconfirmchk").css({
					"color" : "#FA3E3E",
					"font-weight" : "bold",
					"font-size" : "10px"
				})
				console.log("중복아이디")
			}else {
				emconfirmchk = true;
				$memailconfirmTxt.html("<span id='emconfirmchk'>인증번호 확인완료</span>")

				$("#emconfirmchk").css({
					"color" : "#0D6EFD",
					"font-weight" : "bold",
					"font-size" : "10px"
				})
			}
		})
	}
})

</script>

</body>
</html>








