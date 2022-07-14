package com.codegym.controller;

import com.codegym.service.CrudProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Admin {
    @Autowired
    CrudProduct crudProduct;

    @GetMapping("/admin")
    public String showHome(Model model){
        model.addAttribute("products", crudProduct.products);
        return "home";
    }


}
