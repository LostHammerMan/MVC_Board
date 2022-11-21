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
<link rel="stylesheet" type="text/css" href="/MVCProject/resources/css/joinForm.css" />
<style>
	#joinForm{
		/*width: 2000px;*/
	}
</style>
	<script>
		function checkUserIdExist(){

			var user_id = $("#user_id").val()

			if(user_id.length == 0){
				alert('아이디를 입력해주세요')
				return
			}

			$.ajax({
				url : '${root}user/checkUserIdExist/' + user_id,
				type : 'get',
				dataType : 'text',
				success : function(result){
					if(result.trim() == 'true'){
						alert('사용할 수 있는 아이디입니다')
						$("#userIdExist").val('true')
					} else {
						alert('사용할 수 없는 아이디 입니다')
						$("#userIdExist").val('false')
					}
				}
			})
		}

		function resetUserIdExist(){
			$("#userIdExist").val('false')
		}
	</script>
</head>
<body>

<c:import url="/WEB-INF/views/top_bottom/top_menu.jsp" />

div class="container" style="margin-top:100px">
<div class="row">
	<div class="col-sm-3"></div>
	<div class="col-sm-6">
		<div class="card shadow">
			<div class="card-body">
				<form:form action="${root }user/join_pro" method='post' modelAttribute="joinUserBean">
					<form:hidden path="userIdExist"/>
					<div class="form-group">
						<form:label path="user_name">이름</form:label>
						<form:input path="user_name" class='form-control'/>
						<form:errors path="user_name" style='color:red'/>
					</div>

					<div class="form-group">
						<form:label path="user_id">아이디</form:label>
						<div class="input-group">
							<form:input path="user_id" class='form-control' onkeypress="resetUserIdExist()"/>
							<div class="input-group-append">
								<button type="button" class="btn btn-primary" onclick='checkUserIdExist()'>중복확인</button>
							</div>
						</div>
						<form:errors path="user_id" style='color:red'/>
					</div>
					<div class="form-group">
						<form:label path="user_pw">비밀번호</form:label>
						<form:password path="user_pw" class='form-control'/>
						<form:errors path='user_pw' style='color:red'/>
					</div>
					<div class="form-group">
						<form:label path="user_pw2">비밀번호 확인</form:label>
						<form:password path="user_pw2" class='form-control'/>
						<form:errors path='user_pw2' style='color:red'/>
					</div>
					<div class="form-group">
						<div class="text-right">
							<form:button class='btn btn-primary'>회원가입</form:button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<div class="col-sm-3"></div>
</div>


<c:import url="/WEB-INF/views/top_bottom/bottom_menu.jsp" />
<script>
	function sample6_execDaumPostcode() {
		new daum.Postcode({
			oncomplete: function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

				// 각 주소의 노출 규칙에 따라 주소를 조합한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var addr = ''; // 주소 변수
				var extraAddr = ''; // 참고항목 변수

				//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					addr = data.roadAddress;
				} else { // 사용자가 지번 주소를 선택했을 경우(J)
					addr = data.jibunAddress;
				}

				// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
				if(data.userSelectedType === 'R'){
					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
						extraAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if(data.buildingName !== '' && data.apartment === 'Y'){
						extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
					}
					// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if(extraAddr !== ''){
						extraAddr = ' (' + extraAddr + ')';
					}
					// 조합된 참고항목을 해당 필드에 넣는다.
					document.getElementById("sample6_extraAddress").value = extraAddr;

				} else {
					document.getElementById("sample6_extraAddress").value = '';
				}

				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('sample6_postcode').value = data.zonecode;
				document.getElementById("sample6_address").value = addr;
				// 커서를 상세주소 필드로 이동한다.
				document.getElementById("sample6_detailAddress").focus();
			}
		}).open();
	}
</script>

</body>
</html>








