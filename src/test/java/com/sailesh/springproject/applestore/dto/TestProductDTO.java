package com.sailesh.springproject.applestore.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProductDTO {

    @Test
    public void getId() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1);

        assertEquals(1,productDTO.getId());

    }


    @Test
    public void getName() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("iphone12");

        assertEquals("iphone12",productDTO.getName());

    }

    @Test
    public  void categoryId() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategoryId(1);

        assertEquals(1,productDTO.getCategoryId());
    }

    @Test
    public void  price() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setPrice(42000);

        assertEquals(42000, productDTO.getPrice());
    }

    @Test
    public  void description() {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setDescription("Good product");

        assertEquals("Good product", productDTO.getDescription());
    }

    @Test
    public void imageName() {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setImageName("iphone12.jpeg");

        assertEquals("iphone12.jpeg", productDTO.getImageName());
    }
}
