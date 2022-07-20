package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    @Autowired
    EntityManager entityManager;

    public List<Product> getList(){
        String queryStr = "SELECT p FROM Product p";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        return  query.getResultList();
    }

    public void save(Product product){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.persist(product);
        txn.commit();
    }

    public void edit(Product product) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.merge(product);
        txn.commit();
    }

    public void delete(int id){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.remove(findById(id));
        txn.commit();
    }


    public Product findById(int id){
        String query = "SELECT p FROM Product p where p.id=:id";
        Product product = entityManager.createQuery(query,Product.class).setParameter("id",id).getSingleResult();
        return product;
    }

    public int maxID(){
        String query = "SELECT max(p.id)FROM Product p ";
        Query query1=entityManager.createQuery(query);
        int id= (int) query1.getSingleResult();
        return id;
    }

    public ArrayList<Product> search(String key){
        String query = "SELECT p FROM Product p where p.name like:key";
        ArrayList<Product> products = (ArrayList<Product>) entityManager.createQuery(query,Product.class).setParameter("key",key).getResultList();
        return products;

    }
}
