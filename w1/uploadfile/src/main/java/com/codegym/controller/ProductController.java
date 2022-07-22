package com.codegym.controller;


import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.CategoryService;
import com.codegym.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;

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
    public ModelAndView show(@RequestParam(defaultValue = "0") int page ){
        ModelAndView modelAndView = new ModelAndView("home");
        Page<Product> products=productService.getAll(PageRequest.of(page,5, Sort.by("id")));
        modelAndView.addObject("products",products);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("product", productService.findByID(id));
        modelAndView.addObject("categories", categoryService.getAll());
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute Product product,
                             @RequestParam("categoryId") Category category,@RequestParam MultipartFile file){

        String link=productService.findByID(product.getId()).getImg();
        String oldName=productService.nameFile2(link);

        product.setImg(link);
        if (!file.getOriginalFilename().equals("")){
            try {
                FileCopyUtils.copy(file.getBytes(), new File("/home/hauhc1203/Desktop/module4/w1/uploadfile/src/main/webapp/WEB-INF/img/" + oldName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        product.setCategory(category);
        productService.save(product);
        return modelAndView;
    }


    @GetMapping("/del/{id}")
    public ModelAndView del(@PathVariable("id") int id){
        productService.deleteByID(id);
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
    public ModelAndView create(@ModelAttribute Product product, @RequestParam("categoryId")Category category, @RequestParam MultipartFile file){
            String newName= productService.newName(file);
            product.setImg("/img/" +newName );

        try {
            FileCopyUtils.copy(file.getBytes(), new File("/home/hauhc1203/Desktop/module4/w1/uploadfile/src/main/webapp/WEB-INF/img/" + newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        product.setCategory(category);
       productService.save(product);
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(@RequestParam("key") String key,@RequestParam(defaultValue = "0") int page){
        ModelAndView modelAndView=new ModelAndView("home");
        Page<Product> products=productService.search(key,PageRequest.of(page,5, Sort.by("id")));
        modelAndView.addObject("products", products );
        return modelAndView;

    }


}
