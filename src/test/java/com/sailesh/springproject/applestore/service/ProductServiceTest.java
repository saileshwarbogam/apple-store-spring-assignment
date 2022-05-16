package com.sailesh.springproject.applestore.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


import com.sailesh.springproject.applestore.dao.CategoryRepository;
import com.sailesh.springproject.applestore.dao.ProductRepository;
import com.sailesh.springproject.applestore.entity.Category;
import com.sailesh.springproject.applestore.entity.Product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @MockBean
    private ProductRepository productRepository;


    @Autowired
    private CategoryService categoryService;
    @MockBean
    private CategoryRepository categoryRepository;

    @Test
    public void testAddProduct(){
        Product product = new Product();

        product.setName("iphone12");
        product.setId(1);
        product.setDescription("Good Product");
        product.setPrice(42000);
        product.setImageName("iphone12.jpeg");
        product.setCategory(new Category(1,"iphone12 series"));

        Mockito.when(productRepository.save(product)).thenReturn(product);

        assertThat(productService.addProduct(product)).isEqualTo(product);

    }

    @Test
    public void testGetProductById(){
        Product product = new Product();

        product.setName("iphone12");
        product.setId(1);
        product.setDescription("Good Product");
        product.setPrice(42000);
        product.setImageName("iphone12.jpeg");
        product.setCategory(new Category(1,"iphone12 series"));

        Mockito.when(productRepository.findById(1)).thenReturn(Optional.of(product));

        assertThat(productService.getProductById(1)).isEqualTo(Optional.of(product));


    }

    @Test
    public void testGetAllProducts() {
        Product product1 = new Product();

        product1.setName("iphone12");
        product1.setId(1);
        product1.setDescription("Good Product");
        product1.setPrice(42000);
        product1.setImageName("iphone12.jpeg");
        product1.setCategory(new Category(1,"iphone12 series"));

        Product product2 = new Product();

        product2.setName("iphone13");
        product2.setId(2);
        product2.setDescription("Good Product");
        product2.setPrice(50000);
        product2.setImageName("iphone13.jpeg");
        product2.setCategory(new Category(2,"iphone13 series"));

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        Mockito.when(productRepository.findAll()).thenReturn(productList);

        assertThat(productService.getAllProducts()).isEqualTo(productList);
    }


    @Test
    public void testGetAllProductsByCategoryId(){
        Product product = new Product();

        product.setName("iphone12");
        product.setId(1);
        product.setDescription("Good Product");
        product.setPrice(42000);
        product.setImageName("iphone12.jpeg");
        product.setCategory(new Category(1,"iphone12 series"));

        List<Product> productList = new ArrayList<>();
        productList.add(product);

        Mockito.when(productRepository.findAllByCategory_Id(1)).thenReturn(productList);

        assertThat(productService.getAllProductsByCategoryId(1)).isEqualTo(productList);
    }


    @Test
    public void testRemoveProductById(){
        Product product = new Product();

        product.setName("iphone12");
        product.setId(1);
        product.setDescription("Good Product");
        product.setPrice(42000);
        product.setImageName("iphone12.jpeg");
        product.setCategory(new Category(1,"iphone12 series"));

        productService.removeProductById(1);
        verify(productRepository,times(1)).deleteById(1);


    }

}
