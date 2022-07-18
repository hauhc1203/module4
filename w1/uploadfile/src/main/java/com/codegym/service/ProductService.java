package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements CRUD<Product> {
    private List<Product> products;


    CategoryService categoryService =new CategoryService() ;


    public ProductService( ) {


        products = new ArrayList<>();
        products.add(new Product(1, 500, "Hoàng", "/img/2.jpeg", false, categoryService.getAll().get(0)));
        products.add(new Product(2, 1000, "Thế", "/img/12.jpeg", true, categoryService.getAll().get(1)));
    }


    @Override
    public void create(Product product) {
        products.add(product);
    }

    @Override
    public void edit(Product product, int index) {
        products.set(index, product);
    }

    @Override
    public void delete(int index) {
        Product product=  products.get(index);
        File anh=new File("/home/hauhc1203/Desktop/module4/w1/uploadfile/src/main/webapp/WEB-INF" +product.getImg());
        anh.delete();
        products.remove(index);
    }

    public Product findByindex(int index){
        return products.get(index);
    }
    @Override
    public List<Product> getAll() {
        return products;
    }
}
