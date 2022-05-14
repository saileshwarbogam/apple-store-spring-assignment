package com.sailesh.springproject.applestore.dao;

import com.sailesh.springproject.applestore.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
