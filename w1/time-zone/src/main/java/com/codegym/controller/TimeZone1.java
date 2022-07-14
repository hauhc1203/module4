package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;


@Controller
@RequestMapping("/home")
public class TimeZone1 {
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("world-clock")
    public String getTime(Model model,@RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city){
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();

        TimeZone locale = TimeZone.getTimeZone(city);

        long locale_time = date.getTime() +(locale.getRawOffset() - local.getRawOffset());
// Cài đặt lại thời gian cho biến date thành thời gian hiện tại của 1 thành phố cụ thể
        date.setTime(locale_time);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "home";
    }
}