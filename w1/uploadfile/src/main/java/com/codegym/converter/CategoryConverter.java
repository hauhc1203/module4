package com.codegym.converter;

import com.codegym.model.Category;
import com.codegym.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class CategoryConverter implements Converter<Integer, Category> {
    @Autowired
    ICategoryRepo iCategoryRepo;
    @Override
    public Category convert(Integer id) {
        return iCategoryRepo.findById(id).get();
    }

    @Override
    public <U> Converter<Integer, U> andThen(Converter<? super Category, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
