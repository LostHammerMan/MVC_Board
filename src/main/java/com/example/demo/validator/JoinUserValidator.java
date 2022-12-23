package com.example.demo.validator;

import com.example.demo.domain.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.regex.Pattern;

@Slf4j
public class JoinUserValidator implements Validator {

    // 해당 객체가 validator가 지원하는 객체인지 판단하기 위해서 override하는 메서드
    @Override
    public boolean supports(Class<?> clazz) {
        return UserVO.class.isAssignableFrom(clazz);
    }

    // 회원 검증
    @Override
    public void validate(Object target, Errors errors) {

        UserVO userVO = (UserVO) target;

        // 빈 이름 추출
        String beanName = errors.getObjectName();
        log.info("beanName = {}", beanName);

        String user_name = userVO.getUser_name();
        String user_id = userVO.getUser_id();
        String user_pw = userVO.getUser_pw();
        String user_pw2 = userVO.getUser_pw2();
        String user_email = userVO.getUser_email();

        // login
//        @Size(min = 2, max = 4)
//        @Pattern(regexp = "[가-힣]*")
//        @NotBlank
//        private String user_name;
        // NotBlank.tempLoginUserBean.user_pw2
        // [errorCode]. ...         .[field]

//        @Size(min = 4, max = 12)
//        @javax.validation.constraints.Pattern(regexp = "[a-zA-Z0-9]*")
//        @NotBlank
//        private String user_id;
//

//

//


        if(beanName.equals("joinUserBean")) {

            // user_name
            if(!StringUtils.hasText(user_name)) {// @NotBlnk
                errors.rejectValue("user_name", "NotBlank");
                // NotBlank.tempLoginUserBean.user_name --> erorr.propeties
                return;
            }
            //"^[a-zA-Z0-9]{8,20}$"

            // * : 앞 문자가 없을 수도 무한정 많을 수도 있음
            if(!Pattern.matches("^[가-힣]{2,12}$", user_name)) { // @Pattern, @Size
                errors.rejectValue("user_name", "Pattern");
                // Pattern.tempLoginUserBean.user_name
                return;
            }


//        @Size(min = 4, max = 12)
//        @Pattern(regexp = "[a-zA-Z0-9]*")
//        @NotBlank
//        private String user_id;

            if (!StringUtils.hasText(user_id)){
                errors.rejectValue("user_id", "NotBlank");
                return;
            }

            if (!Pattern.matches("^[a-zA-Z0-9]{4,12}$", user_id)){
                errors.rejectValue("user_id", "Pattern");
                return;
            }

            // 아이디 중복 체크
            if (userVO.isUserIdExist() == false){
                errors.rejectValue("user_id", "DontCheckUserIdExist");
                return;
            }

//        @Size(min = 4, max = 16)
//        @Pattern(regexp = "[ㄱ-ㅎa-zA-Z0-9]*")
//        @NotBlank
//        private String user_pw;

            if (!StringUtils.hasText(user_pw)){
                errors.rejectValue("user_pw", "NotBlank");
                return;
            }

            if (!Pattern.matches("^[ㄱ-ㅎa-zA-Z0-9]{4,16}?", user_pw)){
                errors.rejectValue("user_pw", "Pattern");
                return;
            }

//        @Size(min = 4, max = 16)
//        @Pattern(regexp = "[ㄱ-ㅎa-zA-Z0-9]*")
//        @NotBlank
//        private String user_pw2;
            if (!StringUtils.hasText(user_pw2)){
                errors.rejectValue("user_pw2", "NotBlank");
                return;
            }

            if (!Pattern.matches("^[ㄱ-ㅎa-zA-Z0-9]{4,16}?", user_pw2)){
                errors.rejectValue("user_pw2", "Pattern");
                return;
            }

            if (!user_pw.equals(user_pw2)){
                errors.rejectValue("user_pw", "NotEquals");
                errors.rejectValue("user_pw2", "NotEquals");
                return;
            }


//        @Email(message = "옳바른 이메일 형식이 아닙니다")
//        @NotBlank
//        private String user_email;
            if (!StringUtils.hasText(user_email)){
                errors.rejectValue("user_email", "NotBlank");
                return;
            }

            if (!Pattern.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$", user_email)){
                errors.rejectValue("user_email", "Pattern");
                return;
            }
        }


//        if (beanName.equals("tempLoginUserBean")){
//
//            // user_id
//            if (!StringUtils.hasText(user_id)){
//                errors.rejectValue("user_id", "NotBlank");
//                return;
//            }
//
//            if (!Pattern.matches("^[a-zA-Z0-9]{4,16}$", user_id)){
//                errors.rejectValue("user_id", "Pattern");
//                return;
//            }
//
//            // user_pw
//            if (!StringUtils.hasText(user_pw)){
//                errors.rejectValue("user_pw", "NotBlank");
//                return;
//            }
//
//            if (!Pattern.matches("^[ㄱ-ㅎa-zA-Z0-9]{4,12}?", user_pw)){
//                errors.rejectValue("user_pw", "Pattern");
//                return;
//            }
//        }



//        // 비밀번호 확인
//        if (beanName.equals("joinUserBean")){
//            if (userVO.getUser_pw().equals(userVO.getUser_pw2())){
//                errors.rejectValue("user_pw", "NotEquals");
//                errors.rejectValue("user_pw2", "NotEquals");
//            }
//        }

//        if (userVO.isUserIdExist() == false){
//            errors.rejectValue("user_id", "DontCheckUserIdExist");
//        }

    }
}
