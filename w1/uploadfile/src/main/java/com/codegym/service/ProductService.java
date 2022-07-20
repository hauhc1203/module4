package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductService implements CRUD<Product> {

    @Autowired
    ProductRepo productRepo;

    private static  final  String GETNAME="(.*?)\\.(.*?)";
    private static  final  String GETNAME2="/img/(.*?)";
    private List<Product> products=new ArrayList<>();

    public ProductService( ) {

    }


    @Override
    public void create(Product product) {
       productRepo.save(product);
    }

    @Override
    public void edit(Product product, int index) {
        products.set(index, product);
    }

    @Override
    public void delete(int id) {
        Product product=  productRepo.findById(id);
        File anh=new File("/home/hauhc1203/Desktop/module4/w1/uploadfile/src/main/webapp/WEB-INF" +product.getImg());
        anh.delete();
        productRepo.delete(id);
    }


    @Override
    public List<Product> getAll() {
        products=productRepo.getList();
        return products;
    }

    public  String nameFile(String name){
        Pattern p = Pattern.compile(GETNAME);
        Matcher m = p.matcher(name);
        m.matches();

        return m.group(2);
    }

    public   String nameFile2(String name){
        Pattern p = Pattern.compile(GETNAME2);
        Matcher m = p.matcher(name);
        m.matches();

        return m.group(1);
    }
    public  String newName(MultipartFile file){
        String nameImg = file.getOriginalFilename();
        String ext=nameFile(nameImg);
        int stt=productRepo.maxID()+1;
        String name="product"+stt+"."+ext;

        return name;
    }
    public ArrayList<Product> search(String key){
        key = "%"+key+"%";
        return productRepo.search(key);
    }

}
