package com.sailesh.springproject.applestore.dto;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestProductDTO {
//
//    private int id;
//    private String name;
//
//    private int categoryId;
//
//    private double price;
//    private String description;
//    private String imageName;

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
    public void getCategoryId() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategoryId(1);
        assertEquals(1,productDTO.getCategoryId());
    }

    @Test
    public void getPrice() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setPrice(1);
        assertEquals(1,productDTO.getPrice());
    }


    @Test
    public void getDescription() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setDescription("good");
        assertEquals("good",productDTO.getDescription());
    }



    @Test
    public void getImageName() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setImageName("good");
        assertEquals("good",productDTO.getImageName());
    }




}
