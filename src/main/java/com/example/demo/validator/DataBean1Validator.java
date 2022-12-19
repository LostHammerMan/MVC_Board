package com.example.demo.validator;

import com.example.demo.beans.Valid_DataBean1;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class DataBean1Validator implements Validator{

    // 해당 클래스가 유효성 검증 가능한 클래스인지 확인
    @Override
    public boolean supports(Class<?> clazz) {
        return Valid_DataBean1.class.isAssignableFrom(clazz);

        // clazz : 유효성 검사를 위한 빈 클래스 타입이 들어옴
    }

    // 유효성 검사 부분
    @Override
    public void validate(Object target, Errors errors) {

        // data2의 길이가 0이라면 문자열 검사 실패 -> error2 코드 출력, 0이 아니면 통과
        ValidationUtils.rejectIfEmpty(errors, "data2", "error2");

        // data3의 길이가 0이거나 공백으로 채워져 있으면 검증 실패 -> error3 코드 출력, 아니면 검증 통과
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data3", "error3");

        // 형변환
        Valid_DataBean1 bean1 = (Valid_DataBean1) target;

        String data2 = bean1.getData2();
        String data3 = bean1.getData3();

        if (data2.length() > 10){
            errors.rejectValue("data2", "error4");
        }

        if (!data3.contains("@")){
            errors.rejectValue("data3", "error5");
        }
    }
}
