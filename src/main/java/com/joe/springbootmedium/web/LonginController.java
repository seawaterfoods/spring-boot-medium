package com.joe.springbootmedium.web;

import com.joe.springbootmedium.domain.User;
import com.joe.springbootmedium.domain.UserRepository;
import com.joe.springbootmedium.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String register(UserForm userForm){
        User user=userForm.convertToUser();
        userRepository.save(user);
        return "redirect:/login";
    }



}
