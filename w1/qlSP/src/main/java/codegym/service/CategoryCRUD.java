package codegym.service;

import codegym.model.Category;

import java.util.ArrayList;

public class CategoryCRUD implements ICRUD<Category> {
    private  ArrayList<Category> categories;

    public CategoryCRUD() {
        categories=new ArrayList<>();
        categories.add(new Category(1,"Laptop"));
        categories.add(new Category(2,"Smart Phone"));
    }

    @Override
    public ArrayList<Category> getAll() {
        return categories;
    }

    @Override
    public Category findByID(int id) {
        for (Category c:categories
             ) {
            if (c.getId()==id){
                return c;
            }
        }
        return null;
    }

    @Override
    public Category findByName(String name) {
        return null;
    }

    @Override
    public int getIndex(int id) {
        return 0;
    }
}
