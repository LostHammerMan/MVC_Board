package com.example.demo.controller.test;

import com.example.demo.beans.Valid_DataBean1;
import com.example.demo.validator.DataBean1Validator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class Valid_test_Controller {

    @GetMapping("/validator_home")
    public String validator_home(){
        return "test/custom_validator/validator_home";
    }

    @GetMapping("/input_data")
    public String input_data(@ModelAttribute("dataBean1") Valid_DataBean1 dataBean1){

        return "test/custom_validator/input_data";

    }

    @PostMapping("/input_pro")
    public String input_pro(@Valid @ModelAttribute("dataBean1") Valid_DataBean1 dataBean1, BindingResult result){

        if (result.hasErrors()){
            return "test/custom_validator/input_data";

        }
        return "test/custom_validator/input_success";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        DataBean1Validator validator1 = new DataBean1Validator();
        binder.setValidator(validator1);

//        @Valid가 붙은 경우, 등록된 모든 validator 로 검증

//        복수인 경우
//        binder.addValidators(validator1, validator2, validator3);
    }
}
