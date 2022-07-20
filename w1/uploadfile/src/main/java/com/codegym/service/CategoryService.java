package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> categories = new ArrayList<>();

    public CategoryService() {

    }
    public List<Category> getAll() {
        categories=categoryRepo.getList();

        return categories;
    }
}
