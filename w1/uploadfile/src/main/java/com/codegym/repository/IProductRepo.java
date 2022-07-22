package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;

public interface IProductRepo extends PagingAndSortingRepository<Product,Integer> {
    @Query(value = "select  max(id) from Product " ,nativeQuery = true)
     int maxID();
//    ArrayList<Product> searchProductsByNameLike(String key);
        Page<Product> findAllByNameContaining(String key, Pageable pageable);
//
}
