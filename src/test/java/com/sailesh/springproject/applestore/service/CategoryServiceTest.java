package com.sailesh.springproject.applestore.service;

import com.sailesh.springproject.applestore.dao.CategoryRepository;
import com.sailesh.springproject.applestore.dao.ProductRepository;
import com.sailesh.springproject.applestore.entity.Category;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {


    @Autowired
    private CategoryService categoryService;
    @MockBean
    private CategoryRepository categoryRepository;


    @Test
    public void testAddCategory(){
        Category category1 = new Category();
        category1.setId(1);
        category1.setName("iphone 12 series");

        Mockito.when(categoryRepository.save(category1)).thenReturn(category1);

        assertThat(categoryService.addCategory(category1)).isEqualTo(category1);
    }

    @Test
    public void testGetAllCategory(){

        Category category1 = new Category();
        category1.setId(1);
        category1.setName("iphone 12 series");

        Category category2 = new Category();
        category2.setId(1);
        category2.setName("iphone 12 series");

        List<Category> categoryList = new ArrayList<>();

        categoryList.add(category1);
        categoryList.add(category2);

        Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);

        assertThat(categoryService.getAllCategory()).isEqualTo(categoryList);

    }

    @Test
    public void testDeleteCategoryById(){
        Category category1 = new Category();
        category1.setId(1);
        category1.setName("iphone 12 series");

        categoryService.deleteCategoryById(1);
        verify(categoryRepository,times(1)).deleteById(1);

    }

    @Test
    public void testGetCategoryById() {
        Category category1 = new Category();
        category1.setId(1);
        category1.setName("iphone 12 series");

        Mockito.when(categoryRepository.findById(1)).thenReturn(Optional.of(category1));

        assertThat(categoryService.getCategoryById(1)).isEqualTo(Optional.of(category1));
    }
}
