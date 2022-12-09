package com.example.demo.validator;

import com.example.demo.domain.UserVO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    // 해당 객체가 validator가 지원하는 객체인지 판단하기 위해서 override하는 메서드
    @Override
    public boolean supports(Class<?> clazz) {
        return UserVO.class.isAssignableFrom(clazz);
    }

    // 회원 검증
    @Override
    public void validate(Object target, Errors errors) {

        UserVO userVO = (UserVO) target;

        String beanName = errors.getObjectName();

        // 아이디 중복 확인
        if (beanName.equals("joinUserBean")){


            if (userVO.isUserIdExist() == false){
                errors.rejectValue("user_id", "DontCheckUserIdExist");
            }

        }

        // 비밀번호 확인

        if (beanName.equals("joinUserBean")){
            if (userVO.getUser_pw().equals(userVO.getUser_pw2())){
                errors.rejectValue("user_pw", "NotEquals");
                errors.rejectValue("user_pw2", "NotEquals");
            }
        }

    }
}
