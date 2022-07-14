package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/")
    public ModelAndView home(ModelAndView modelAndView){
        modelAndView=new ModelAndView("home");
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(ModelAndView modelAndView,@RequestParam("giavi") String[] giavi1){
        modelAndView=new ModelAndView("home");
        modelAndView.addObject("giavi2",giavi1);

        return modelAndView;
    }
}
