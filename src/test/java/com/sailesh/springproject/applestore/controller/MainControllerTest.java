package com.sailesh.springproject.applestore.controller;

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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MainControllerTest {

    MainController mainController;

    private MockMvc mockMvc;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;


    @Before
    public void setup() {
        mainController = new MainController(categoryService,productService);
        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    public void contextLoads(){
        setup();
        Assertions.assertThat(mainController).isNotNull();
    }


    @Test
    public void testHome() throws Exception{
        setup();
        mockMvc
                .perform(MockMvcRequestBuilders.get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    public void testHome2() throws Exception{
        setup();
        mockMvc
                .perform(MockMvcRequestBuilders.get("/home"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    public  void testShop() throws Exception {
        setup();
        mockMvc
                .perform(MockMvcRequestBuilders.get("/shop"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("shop-view"));
    }


    @Test
    public void testShopByCategory() throws Exception {
        Category category=new Category();
        category.setId(1);

        setup();

        mockMvc
                .perform(MockMvcRequestBuilders.get("/shop/category/"+category.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("shop-view"));
    }


    @Test
    public void testViewProduct() throws Exception {
        Product product = new Product();
        product.setId(1);

        mockMvc
                .perform(MockMvcRequestBuilders.get("/shop/viewproduct/"+ product.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("view-product"));
    }

    @Test
    public void testCheckout() throws Exception {
        setup();
        mockMvc.perform(MockMvcRequestBuilders.get("/checkout")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("cart-view"));
    }
}
