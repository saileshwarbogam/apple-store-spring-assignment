package com.sailesh.springproject.applestore.service;

import com.sailesh.springproject.applestore.dao.ProductRepository;
import com.sailesh.springproject.applestore.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public  Product addProduct(Product product){

       return productRepository.save(product);
    }

    public void removeProductById(int id){
        productRepository.deleteById(id);
    }

    public Optional<Product> getProductById(int id) {

        return productRepository.findById(id);
    }

    public List<Product> getAllProductsByCategoryId(int id) {
        return productRepository.findAllByCategory_Id(id);
    }
}
