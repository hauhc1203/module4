package com.codegym.service;

import com.codegym.model.Category;

import com.codegym.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryService {
    @Autowired
    ICategoryRepo iCategoryRepo;

    public ArrayList<Category> getAll() {
        return (ArrayList<Category>)  iCategoryRepo.findAll();
    }



    public Optional<Category> findById(int id) {
        return iCategoryRepo.findById(id);
    }
}
