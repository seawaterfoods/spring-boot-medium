package com.joe.springbootmedium.web;

import com.joe.springbootmedium.domain.User;
import com.joe.springbootmedium.domain.UserRepository;
import com.joe.springbootmedium.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LonginController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }
    @GetMapping("/login")
    public String loginPage(){

        return "login";
    }

    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult result){
        boolean boo=true;
        if  (!userForm.confirmPassword()){
            result.rejectValue("confirmPasswordId","confirmError","兩次密碼不一致");
            boo =false;
        }
        if (result.hasErrors()){
            List<FieldError> fieldErrors=result.getFieldErrors();
            for (FieldError error:fieldErrors){
                System.out.println(error.getField()+" : "+error.getDefaultMessage()+" : "+error.getCode());
            }
            boo=false;
        }
        if (!boo){
            return "register";
        }
        User user=userForm.convertToUser();
        userRepository.save(user);
        return "redirect:/login";
    }



}
