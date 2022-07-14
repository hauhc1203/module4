package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class CrudProduct {
    public List<Product> products = new ArrayList<>();

    public CrudProduct(){
        products.add(new Product(1,"abc","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRW4SUQmhNBwIG3mcXzuXRmAV4tbPGLGsGA3TsnD5lYCs926KV_ouhfsBiP3ju1ubZzvAY&usqp=CAU",500));
        products.add(new Product(2,"xyz","https://angiangtourism.vn/chup-cuc-hoa-mi-o-dau/imager_19742.jpg",1500));
    }

    public Product create(HttpServletRequest request)  {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        int id= Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String img=request.getParameter("img");
        int price= Integer.parseInt(request.getParameter("price"));
        return new Product(id,name,img,price);
    }



    public void edit(HttpServletRequest request)  {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        int id= Integer.parseInt(request.getParameter("id"));

        String name=request.getParameter("name");
        String oldImg=request.getParameter("oldIMG");

        String img=request.getParameter("img");
        if (img.equals("")){
            img=oldImg;
        }
        int price= Integer.parseInt(request.getParameter("price"));
        for (Product p: products
        ) {
            if (p.getId()==id){
                p.setImg(img);
                p.setName(name);
                p.setPrice(price);

            }
        }

    }

    
    public void  add(Product product){
        products.add(product);
    }

    public Product findByID(int id){
        for (Product p: products
             ) {
            if (p.getId()==id){
                return p;
            }
        }
        return null;
    }


    public void del(int id){
        products.remove(this.findByID(id));
    }
}
