package com.sailesh.springproject.applestore.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

    @Test
    public void getId() {
        Product product = new Product();
        product.setId(1);
        assertEquals(1,product.getId());
    }

    @Test
    public void getName() {
        Product product = new Product();
        product.setName("iphone 12");

        assertEquals("iphone 12",product.getName());
    }

    @Test
    public void getPrice() {
        Product product = new Product();
        product.setPrice(80000);

        assertEquals(80000,product.getPrice());
    }

    @Test
    public void getDescription() {
        Product product = new Product();
        product.setDescription("Good product");

        assertEquals("Good product",product.getDescription());

    }

    @Test
    public void getImageName() {
        Product product = new Product();

        product.setImageName("iphone12.jpeg");

        assertEquals("iphone12.jpeg",product.getImageName());
    }

}
