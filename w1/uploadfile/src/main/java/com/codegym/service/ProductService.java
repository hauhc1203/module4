package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class ProductService  {

    @Autowired
    IProductRepo iProductRepo;

    private static  final  String GETNAME="(.*?)\\.(.*?)";
    private static  final  String GETNAME2="/img/(.*?)";
    private List<Product> products;



    public Page<Product> getAll(Pageable pageable) {
        return iProductRepo.findAll(pageable);
    }

    public void deleteByID(int id){
        Product product =iProductRepo.findById(id).get();
        File img=new File("/home/hauhc1203/Desktop/module4/w1/uploadfile/src/main/webapp/WEB-INF" +product.getImg());
        img.delete();
        iProductRepo.deleteById(id);
    }

    public Product findByID(int id){
        return iProductRepo.findById(id).get();
    }

    public void save(Product product){
        iProductRepo.save(product);
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
        int stt=iProductRepo.maxID()+1;
        String name="product"+stt+"."+ext;

        return name;
    }
    public Page<Product> search(String key,Pageable pageable){

        return iProductRepo.findAllByNameContaining(key,pageable);
    }

}
