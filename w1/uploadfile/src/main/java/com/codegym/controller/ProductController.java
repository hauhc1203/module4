package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.CategoryService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/products")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("products", productService.getAll());
        return modelAndView;
    }

    @GetMapping("/edit/{index}")
    public ModelAndView showEdit(@PathVariable int index){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("product", productService.getAll().get(index));
        modelAndView.addObject("categories", categoryService.getAll());
        return modelAndView;
    }

    @PostMapping("/edit/{index}")
    public ModelAndView edit(@ModelAttribute Product product, @PathVariable int index,
                             @RequestParam int categoryIndex,@RequestParam MultipartFile file){
        String nameImg = file.getOriginalFilename();
        if (nameImg.equals("")){
            product.setImg(productService.findByindex(index).getImg());
        }else {
            product.setImg("/img/" + nameImg);
        }
        try {
            FileCopyUtils.copy(file.getBytes(), new File("/home/hauhc1203/Desktop/module4/w1/uploadfile/src/main/webapp/WEB-INF/img/" + nameImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        product.setCategory(categoryService.getAll().get(categoryIndex));
        productService.edit(product,index);
        return modelAndView;
    }


    @GetMapping("/del/{index}")
    public ModelAndView del(@PathVariable("index") int index){
        productService.delete(index);
        ModelAndView modelAndView = new ModelAndView("redirect:/products");

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showForm(){
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("product",new Product());
        modelAndView.addObject("categories", categoryService.getAll());

        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Product product, @RequestParam int categoryIndex,@RequestParam MultipartFile file){
        String nameImg = file.getOriginalFilename();

            product.setImg("/img/" + nameImg);

        try {
            FileCopyUtils.copy(file.getBytes(), new File("/home/hauhc1203/Desktop/module4/w1/uploadfile/src/main/webapp/WEB-INF/img/" + nameImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        product.setCategory(categoryService.getAll().get(categoryIndex));
        productService.getAll().add(product);
        return modelAndView;
    }


}
