package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.CrudProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Home {
    @Autowired
    CrudProduct crudProduct;

    @GetMapping("/home")
    public String showHome(Model model){
        model.addAttribute("products", crudProduct.products);
        return "home";
    }

    @GetMapping("/home-create")
    public String showCreateForm(){
        return "create";
    }

    @GetMapping("/product-edit")
    public String showEditForm(Model model,@RequestParam int id){
        model.addAttribute("product",crudProduct.findByID(id));
        return "edit";
    }

    @GetMapping("/product-delete")
    public String delete(@RequestParam int id){
        crudProduct.del(id);
        return "redirect:/home";
    }

    @PostMapping("/product-create")
    public String createProduct(@ModelAttribute Product product){
        crudProduct.add(product);
        return "redirect:/home";
    }


    @PostMapping("/product-edit")
    public String editProduct(Model model, HttpServletRequest request){
        crudProduct.edit(request);

        return "redirect:/home";    }
}
