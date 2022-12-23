package com.example.demo.validator;

import com.example.demo.domain.UserVO;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

public class LoginUserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserVO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserVO userVO = (UserVO) target;

        String beanName = errors.getObjectName();
        String user_id = userVO.getUser_id();
        String user_pw = userVO.getUser_pw();

        if (beanName.equals("tempLoginUserBean")){

            // user_id
            if (!StringUtils.hasText(user_id)){
                errors.rejectValue("user_id", "NotBlank");
                return;
            }

            if (!Pattern.matches("^[a-zA-Z0-9]{4,16}$", user_id)){
                errors.rejectValue("user_id", "Pattern");
                return;
            }

            // user_pw
            if (!StringUtils.hasText(user_pw)){
                errors.rejectValue("user_pw", "NotBlank");
                return;
            }

            if (!Pattern.matches("^[ㄱ-ㅎa-zA-Z0-9]{4,12}?", user_pw)){
                errors.rejectValue("user_pw", "Pattern");
                return;
            }
        }
    }
}
