package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/home")
public class HomeController {


    private final  static String  REGEX_EMAIL="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    @GetMapping("/check")
    public String checkMail(@RequestParam("email") String email, ModelMap model){
        Pattern pattern=Pattern.compile(REGEX_EMAIL);
        Matcher matcher=pattern.matcher(email);
        String mess="";
        if (matcher.matches()){
            mess="Mail đúng";
        }else
        {
            mess="mail sai";
        }
        model.addAttribute("kq",mess);
        return "home";
    }


    @GetMapping("/")
    public String handler(){
        return "home";
    }



}