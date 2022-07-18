package com.codegym.service;

import com.codegym.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    public List<Category> categories = new ArrayList<>();

    public CategoryService() {
        categories = new ArrayList<>();
        categories.add(new Category(1, "C0322g1"));
        categories.add(new Category(2, "C0422g1"));
        categories.add(new Category(3, "C0522g1"));
    }
    public List<Category> getAll() {
        return categories;
    }
}
