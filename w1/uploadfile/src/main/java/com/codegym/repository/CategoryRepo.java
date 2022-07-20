package com.codegym.repository;

import com.codegym.model.Category;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoryRepo {

    @Autowired
    EntityManager entityManager;

    public List<Category> getList(){
        String queryStr = "SELECT c FROM Category c";
        TypedQuery<Category> query = entityManager.createQuery(queryStr, Category.class);
        return query.getResultList();
    }
}
