package com.example.controller;


import com.example.service.Test;
import com.example.service.Tudien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class Home {

    @Autowired
    Tudien tudien;

    @GetMapping("/chuyendoi")
    public String chuyendoi(@RequestParam double usd, Model model){
        double vnd=usd*23000;

        model.addAttribute("vnd",vnd);
        return "home";
    }

    @GetMapping("/tracuu")
    public String tracuu(@RequestParam String eng, Model model){
        String vie="";
        int index=tudien.check(eng);
        if (index==-1){
            vie="Khong co ket qua";
        }else {
            vie=tudien.viet[index];
        }
        model.addAttribute("eng",eng);
        model.addAttribute("vie",vie);

        return "tudien";
    }

    @GetMapping("/home")
    public String home(Model model){
        Test test=new Test();
        String str="";
        for (Map.Entry<String,String> entry: test.list.entrySet()
             ) {
            str=entry.getValue();
            break;
        }

        model.addAttribute("test",str);

        return "home";
    }
    @GetMapping("/tudien")
    public String tudien(){
        return "tudien";
    }
}
