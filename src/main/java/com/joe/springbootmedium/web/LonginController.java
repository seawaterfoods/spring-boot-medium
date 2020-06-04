package com.joe.springbootmedium.web;

import com.joe.springbootmedium.domain.User;
import com.joe.springbootmedium.domain.UserRepository;
import com.joe.springbootmedium.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LonginController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("userForm",new UserForm());
        return "register";
    }
    @GetMapping("/login")
    public String loginPage(){

        return "login";
    }

    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult result, Model model){
        if  (!userForm.confirmPassword()){
            result.rejectValue("confirmPasswordId","confirmError","兩次密碼不一致");
        }
        if (result.hasErrors()){
            return "register";
        }
        User user=userForm.convertToUser();
        userRepository.save(user);
        return "redirect:/login";
    }



}
