<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}/" />
<html>
<head>
    <title>이메일 전송 연습</title>
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
</head>
<body>
    <form id="emailForm" name="emailForm">
        <div>
            <label for="email">이메일 전송</label><br>
            <input type="text" id="email" />
            <input type="button" id="emailSendBtn" value="인증메일 전송"/>
        </div>
        <div>
            <label for="emailAuth">인증번호</label><br>
            <input type="text" id="emailAuth" />
            <input type="button" id="emailAuthBtn" value="인증">
        </div>
    </form>
    <script>
        // const $email = $("#email"); // 이메일 입력 값
        // const $emailSendBtn = $("#emailSendBtn"); // 이메일 전송 버튼
        // const $emailAuth = $("#emailAuth"); // 인증번호 입력
        // const $emailAuthBtn = $("#emailAuthBtn"); // 인증확인 버튼


        function isEmpty(data){
            if (data === "" || data == null){
                return true;
            }else {
                return false;
            }
        }
    </script>
    <script>
        $(document).ready(function (){
            const $email = $("#email"); // 이메일 입력 값
            const $emailSendBtn = $("#emailSendBtn"); // 이메일 전송 버튼
            const $emailAuth = $("#emailAuth"); // 인증번호 입력
            const $emailAuthBtn = $("#emailAuthBtn"); // 인증확인 버튼
            let isEmailAuth = false;

            // 이메일 인증 번호
            $emailSendBtn.on("click", function (){

                if (isEmpty($email.val())){
                    alert("이메일 입력해...")
                    $email.focus();
                    return false;
                }

                $.ajax({
                    url : "${root}emailSendExam",
                    type : "post",
                    dataType : "text",
                    data : {$email : $email.val()},
                    success : function (data){
                        alert("전송 완료");
                        console.log("data = " + data);
                        $email.attr("readonly", true);

                    }
                })
            });

            // 인증 확인
            $emailAuthBtn.on("click", function (){

                if (isEmpty($emailAuth.val())){
                    alert("인증번호 입력해");
                    $emailAuth.focus();
                    return false;
                }

                $.ajax({
                   url : "${root}authConfirm",
                   type : "get",
                   dataType : "text",
                   data : {$emailAuth : $emailAuth.val()},
                   success : function (data){
                       if (data == "success"){
                           alert("인증됨");
                           isEmailAuth = true;
                       }else if (data == "fail"){
                           alert("인증번호 일치하지 않음");
                           $emailAuth.focus();
                       }
                   }
                });

            });



        });
    </script>
</body>
</html>
