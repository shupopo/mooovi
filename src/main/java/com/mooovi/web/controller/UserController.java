package com.mooovi.web.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mooovi.business.entity.User;
import com.mooovi.business.service.UserService;
import com.mooovi.security.LoginUserDetails;
import com.mooovi.web.form.UserForm;

@Controller
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;
    
    @GetMapping("/login")
    public String loginForm(@AuthenticationPrincipal LoginUserDetails loginUserDetails) {
        if (loginUserDetails != null) {
            return "redirect:/";
        }
        return "users/loginForm";
    }
    
    @GetMapping("/sign_up")
    public String signupForm(UserForm form,
                             @AuthenticationPrincipal LoginUserDetails loginUserDtails) {
        if (loginUserDtails != null) {
            return "redirect:/";
        }
        return "users/signupForm";
    }
    
    @PostMapping("/sign_up")
    public String register(@Validated UserForm form,
                           BindingResult result,
                           Model model,
                           @AuthenticationPrincipal LoginUserDetails loginUserDetails){
        if (loginUserDetails != null) {
            return "redirect:/";
        }
        if (!form.getPassword().equals(form.getConfirmPassword())) {
            result.rejectValue("password", "error.passwordConfirmation", "do not match.");
        }
        if (result.hasErrors()) {
            return "users/signupForm";
        }
        User user = new User();
        BeanUtils.copyProperties(form, user);
        userService.save(user);
        return "redirect:/";
    }
}
