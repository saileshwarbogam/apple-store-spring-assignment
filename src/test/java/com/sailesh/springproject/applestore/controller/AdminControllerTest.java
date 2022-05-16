package com.sailesh.springproject.applestore.controller;


import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import com.sailesh.springproject.applestore.dao.CategoryRepository;
import com.sailesh.springproject.applestore.entity.Category;
import com.sailesh.springproject.applestore.entity.Product;
import com.sailesh.springproject.applestore.service.CategoryService;
import com.sailesh.springproject.applestore.service.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminControllerTest {

    private MockMvc mockMvc;

    AdminController adminController;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;


    @Before
    public void setup() {
        adminController = new AdminController(categoryService,productService);

        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    public void contextLoads(){
        setup();
        Assertions.assertThat(adminController).isNotNull();
    }

    @Test
    public void testGetAdmin() throws Exception{
        setup();
        mockMvc
                .perform(MockMvcRequestBuilders.get("/admin"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("admin-home"));
    }



    @Test
    public void testGetCategories() throws Exception{
        setup();
        mockMvc
                .perform(MockMvcRequestBuilders.get("/admin/categories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("category"));
    }


    @Test
    public void testGetCategoriesAdd() throws Exception{
        setup();
        mockMvc
                .perform(MockMvcRequestBuilders.get("/admin/categories/add"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("categories-add"));
    }

    @Test
    public void testPostCategoriesAdd() throws Exception{

        setup();
        mockMvc.perform(post("/admin/categories/add")
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                        .param("id",String.valueOf(1))
                        .param("name","iphone 12 series")
                )
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void testDeleteCategory() throws Exception {
        Category category = new Category();
        category.setName("iphone6 series");

        Category category1 = categoryService.addCategory(category);

//        categoryService.deleteCategoryById(category.getId());
        mockMvc
                .perform(get("/admin/categories/delete/"+category.getId()))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/admin/categories"));

    }




    @Test
    public void testGetProducts() throws Exception{
        setup();
        mockMvc
                .perform(MockMvcRequestBuilders.get("/admin/products"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("product"));
    }


    @Test
    public void testGetAddProduct() throws Exception{
        setup();
        mockMvc
                .perform(MockMvcRequestBuilders.get("/admin/products/add"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("products-add"));
    }


    @Test
    public void testPostAddProduct() throws Exception {
        setup();
        mockMvc.perform(post("/admin/categories/add")
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                        .param("id", String.valueOf(1))
                        .param("name", "iphone 12")
                        .param("category_id",String.valueOf(3))
                        .param("price",String.valueOf(200000))
                        .param("description","BestSeller")
                )
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void testDeleteProduct() throws Exception{

        Category category = new Category();
        category.setName("iphone6 series");

        Product product = new Product();
        product.setName("iphone 12");
        product.setCategory(category);
        product.setPrice(42000);
        product.setDescription("Good product");
        product.setImageName("iphone12.jpeg");

        Product product1 = productService.addProduct(product);

        mockMvc
                .perform(get("/admin/product/delete/"+product.getId()))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/admin/products"));


    }

    @Test
    public void testUpdateCategory() throws Exception {
        Category category = new Category();
        category.setName("iphone6 series");

        Category category1 = categoryService.addCategory(category);

        mockMvc
                .perform(get("/admin/categories/update/"+category.getId()))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.view().name("categories-add"));
    }

    @Test
    public void testUpdateCategory404() throws Exception {
        Category category = new Category();
        category.setName("iphone6 series");

        Category category1 = categoryService.addCategory(category);

        mockMvc
                .perform(get("/admin/categories/update/"+"20"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.view().name("404"));
    }


}
