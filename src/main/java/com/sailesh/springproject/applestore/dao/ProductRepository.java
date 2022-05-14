package com.sailesh.springproject.applestore.dao;

import com.sailesh.springproject.applestore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByCategory_Id(int id);
}
