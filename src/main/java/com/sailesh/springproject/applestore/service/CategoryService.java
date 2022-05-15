package com.sailesh.springproject.applestore.service;


import com.sailesh.springproject.applestore.dao.CategoryRepository;
import com.sailesh.springproject.applestore.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public  Category addCategory(Category category){

        return categoryRepository.save(category);
    }

    public List<Category> getAllCategory(){

        return categoryRepository.findAll();
    }


    public void deleteCategoryById(int id){
        categoryRepository.deleteById(id);
    }

    public Optional<Category> getCategoryById(int id) {
        return categoryRepository.findById(id);
    }
}
