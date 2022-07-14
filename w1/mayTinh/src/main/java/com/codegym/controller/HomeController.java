package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController  {
    @GetMapping("/home")
    public ModelAndView home(ModelAndView modelAndView){
        modelAndView=new ModelAndView("home");
        return modelAndView;
    }
    @GetMapping("/tinh")
    public ModelAndView tinh(ModelAndView modelAndView , @RequestParam double num1,@RequestParam double num2,@RequestParam String dau){
        modelAndView=new ModelAndView("home");
        double kq=0;
        switch (dau){
            case "cong":
                kq=num1+num2;
                break;
            case "-":
                kq=num1-num2;
                break;
            case "x":
                kq=num1*num2;
                break;
            case "chia":
                kq=num1/num2;
                break;
        }
        modelAndView.addObject("num1",num1);
        modelAndView.addObject("num2",num2);
        modelAndView.addObject("kq",kq);
        return modelAndView;
    }
}