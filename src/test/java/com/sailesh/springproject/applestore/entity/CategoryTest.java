package com.sailesh.springproject.applestore.entity;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CategoryTest {

    @Test
    public void getId(){
        Category category = new Category();
        category.setId(1);
        assertEquals(1,category.getId());

    }

    @Test
    public void getName() {
        Category category = new Category();

        category.setName("iphone11 series");

        assertEquals("iphone11 series",category.getName());
    }
}
