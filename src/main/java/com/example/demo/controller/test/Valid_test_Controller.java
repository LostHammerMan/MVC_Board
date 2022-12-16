package com.example.demo.controller.test;

import com.example.demo.beans.Valid_DataBean1;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class Valid_test_Controller {

    @GetMapping("/validator_home")
    public String validator_home(){
        return "test/custom_validator/validator_home";
    }

    @GetMapping("/input_data")
    public String input_data(Valid_DataBean1 dataBean1){

        return "test/custom_validator/input_data";

    }

    @PostMapping("/input_pro")
    public String input_pro(@Valid Valid_DataBean1 dataBean1, BindingResult result){

        if (result.hasErrors()){
            return "test/custom_validator/input_data";

        }
        return "test/custom_validator/input_success";
    }
}
