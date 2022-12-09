let emconfirmchk = false;
$(document).ready(function () {

    let $user_email = $("#user_email");
    let $memailConfirm = $("#memailConfirm");
    let $memailconfirmTxt = $("#memailconfirmTxt");
    let $checkEmail = $("#checkEmail");
    let $checkAuthBtn = $("#checkAuthBtn");

    let isEmailAuth = false;

    $checkEmail.click(function (e) {
        e.preventDefault();

        $.ajax({
            type: "post",
            url: "${root}user/mailConfirm",
            //contentType : "text"
            // contentType : "application/json; charset=utf-8",
            data: {
                "email": $user_email.val()
            },
            success: function (data) {
                alert("이메일 인증번호 발송 완료");
                console.log("data " + data);
                // chkEmailConfirm(data, $memailConfirm, $memailconfirmTxt);
            }
        })
    })

    // 인증확인 버튼 클릭
    $checkAuthBtn.on("click", function () {

        if (isEmpty($memailConfirm.val())) {
            alert("인증번호 입력");
            $memailConfirm.focus();
            return false;
        }

        $.ajax({
            url: '${root}user/confirmEmailAuth',
            type: 'get',
            dataType: 'text',
            data: {$memailConfirm: $memailConfirm.val()},
            success: function (data) {
                if (data == "authSuccess") {
                    isEmailAuth == true;
                    alert("인증됨....");
                    $("#joinBtn").attr("disabled", false);

                } else {
                    alert("인증번호 일치하지 않음");
                }
            }

        })

    });


// // 이메일 인증 번호 체크 함수
// function chkEmailConfirm(data, $memailConfirm, $memailconfirmTxt){
// 	$memailConfirm.on("keyup", function (){
// 		if (data != $memailConfirm.val()){
// 			emconfirmchk = false;
// 			$memailconfirmTxt.html("<span id='emconfirmchk'>인증번호가 잘못되었습니다</span>")
// 			$("#emconfirmchk").css({
// 				"color" : "#FA3E3E",
// 				"font-weight" : "bold",
// 				"font-size" : "10px"
// 			})
// 			console.log("중복아이디")
// 		}else {
// 			emconfirmchk = true;
// 			$memailconfirmTxt.html("<span id='emconfirmchk'>인증번호 확인완료</span>")
//
// 			$("#emconfirmchk").css({
// 				"color" : "#0D6EFD",
// 				"font-weight" : "bold",
// 				"font-size" : "10px"
// 			})
// 		}
// 	})
// }


    let emconfirmchk = false;

    $(document).ready(function (){



        let $user_email = $("#user_email");

        let $memailConfirm = $("#memailConfirm");

        let $memailconfirmTxt = $("#memailconfirmTxt");

        let $checkEmail = $("#checkEmail");

        let $checkAuthBtn = $("#checkAuthBtn");



        let isEmailAuth = false;



        $checkEmail.click(function (e){

            e.preventDefault();



            $.ajax({

                type : "post",

                url : "${root}user/mailConfirm",




                contentType : "application/json; charset=utf-8",

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




        //인증확인 버튼 클릭

        $checkAuthBtn.on("click", function (){



            if (isEmpty($memailConfirm.val())){

                alert("인증번호 입력");

                $memailConfirm.focus();

                return false;

            }



            $.ajax({

                url: '${root}user/confirmEmailAuth',

                type : 'get',

                dataType : 'text',

                data : {$memailConfirm : $memailConfirm.val()},

                success : function (data){

                    if (data == "authSuccess"){

                        isEmailAuth == true;

                        alert("인증됨....");

                        $("#joinBtn").attr("disabled", false);



                    }else{

                        alert("인증번호 일치하지 않음");

                    }

                }



            })



        });








        //이메일 인증 번호 체크 함수

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
        function checkUserIdExist(){

            let $user_id = $("#user_id");

            if ($user_id.val().length == 0){
                alert("아이디 입력좀");
                $user_id.focus();
                return false;
            }

            $.ajax({
                url : "${root}user/checkUserIdExist/" + $user_id.val(),
                type : "get",
                dataType: "text",
                success : function (result){
                    if (result.trim() == 'true'){
                        alert("사용가능 아이디");
                        $("#userIdExist").val('true');
                    }else {
                        alert("사용 불가능 아이디");
                        $("#userIdExist").val('false');

                    }

                }

            })

        }

        let isEmpty = function (data){
            if (data === "" || data === null){
                return true;
            }else {
                return false;
            }
        };




    })
})