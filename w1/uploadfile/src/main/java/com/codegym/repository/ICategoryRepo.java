package com.codegym.repository;

import com.codegym.model.Category;
import org.springframework.data.repository.CrudRepository;


public interface ICategoryRepo extends CrudRepository<Category,Integer> {
}
