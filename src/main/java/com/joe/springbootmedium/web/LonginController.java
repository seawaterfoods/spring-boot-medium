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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class LonginController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("userForm",new UserForm());
        return "register";
    }
    @GetMapping("/login")
    public String loginPage(){

        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            HttpSession session){
        User user = userRepository.findByUsernameAndPassword(username,password);
        if (user != null){
            session.setAttribute("user",user);
            return "index";
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }

    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult result, Model model){
        if  (!userForm.confirmPassword()){
//            result.rejectValue可以指定傳遞變數的類型並且設置回傳訊息。
            result.rejectValue("confirmPasswordId","confirmError","兩次密碼不一致");
        }
        if (result.hasErrors()){
            return "register";
        }
        User user=userForm.convertToUser();
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/exception")
    public String textException(){
        throw new RuntimeException("測試異常處理");
    }

}
