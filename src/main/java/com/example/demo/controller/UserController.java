package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.UserVO;
import com.example.demo.service.UserService;
import com.example.demo.validator.JoinUserValidator;
import com.example.demo.validator.LoginUserValidator;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.security.Principal;

@Slf4j
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    public UserService userService;

    @Autowired
    public UserDao userDao;

    // 세션 scope인 UserVo 주입
    @Resource(name = "loginUserBean")
    private UserVO loginUserBean;

//    public UserController(UserService userService){
//        this.userService = userService;
//    }


    // 회원가입
    @GetMapping("join")
    public String join(@ModelAttribute("joinUserBean") UserVO joinUserBean){
        return "user/join";
    }

    @PostMapping("join_ok")
    public String join_ok(@Valid @ModelAttribute("joinUserBean") UserVO joinUserBean, BindingResult result){
        log.info("{}", joinUserBean);

        if (result.hasErrors()){
            log.info("error occur....");
//            result.getAllErrors().forEach(objectError -> {
//                log.info("{}", objectError.getCodes()[0]);
//            });
            result.getAllErrors().forEach(objectError -> {
                log.info("{}", objectError.getCodes()[0]);
            });
            return "user/join";
        }
        userService.register(joinUserBean);
        log.info("join_ok........");
        return "user/join_ok";
    }

    // 로그인 -> Security 파일 생성 후 작동 안함
    /*@GetMapping("/login")
    public String login(@ModelAttribute("tempLoginUserBean") UserVO tempLoginUserBean,
                        @RequestParam(value = "fail", defaultValue = "false") boolean fail,
                        Model model){*/
    //@RequestMapping("/login")
    @GetMapping("/login")
    public String login(@ModelAttribute("tempLoginUserBean") UserVO tempLoginUserBean, Model model) {
        log.info("login called.....");
        log.info("loginUserBean = {}", loginUserBean);

        return "user/login";
    }

    @PostMapping("/login_pro")
    public String login_pro(@Valid @ModelAttribute("tempLoginUserBean") UserVO tempLoginUserBean, BindingResult result){

        if (result.hasErrors()){
            log.info("login_error called....");
            //log.info("tempLoginUserBean ={}", tempLoginUserBean);
            //log.info("loginUserBean ={}", loginUserBean);

            result.getAllErrors().forEach(objectError -> {
                log.info(objectError.getCodes()[0]);
            });

            return "user/login";
        }

        userService.getLoginUserInfo(tempLoginUserBean);
        log.info("login_pro called....");
        log.info("tempLoginUserBean ={}", tempLoginUserBean);

        log.info("loginUserBean ={}", loginUserBean);


        if (loginUserBean.isUserLogin() == true){
            return "user/login_ok";
        }else {
            return "user/login_fail";

        }
    }


    // 로그아웃
    @GetMapping("/logout")
    public String logout(){
        log.info("logout called...");
        loginUserBean.setUserLogin(false);
        return "user/logout";
    }

    // 회원정보 수정
    @GetMapping("/modify")
    public String modify(Principal principal, Model model){
        log.info("modify called...");
        String user_id = principal.getName(); // 사용자의 아이디값 불러오기
        UserVO loginUser = userDao.findByUserId(user_id);
        model.addAttribute("loginUser", loginUser);

        return "user/modify_user";
    }

    @PostMapping("/modify_ok")
    public String modify_ok(UserVO modifyUserBean, Principal principal){
        userService.modifyUser(modifyUserBean, principal);
        log.info("{}", modifyUserBean);
        log.info("modify_ok called....");

        return "user/modify_ok";
    }



//    UserValidator 등록
    @InitBinder
    public void initBinder(WebDataBinder binder){
        JoinUserValidator joinUserValidator = new JoinUserValidator();
        LoginUserValidator loginUserValidator = new LoginUserValidator();

        binder.addValidators(joinUserValidator, loginUserValidator);
    }

}
