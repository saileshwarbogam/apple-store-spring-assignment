package com.sailesh.springproject.applestore.controller;

import com.sailesh.springproject.applestore.entity.Product;
import com.sailesh.springproject.applestore.global.GlobalData;
import com.sailesh.springproject.applestore.service.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartControllerTest {

    private MockMvc mockMvc;

    CartController cartController;

    @Autowired
    ProductService productService;

    @Before
    public void setup() {
       cartController = new CartController(productService);
        mockMvc = MockMvcBuilders.standaloneSetup(cartController).build();

    }

    @Test
    public void contextLoads(){
        setup();
        Assertions.assertThat(cartController).isNotNull();
    }

    @Test
    public void testCartGet() throws Exception {
        setup();
        mockMvc
                .perform(MockMvcRequestBuilders.get("/cart"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("cart-view"));
    }

    @Test
    public  void testAddToCart() throws Exception {
        Product product = new Product();
        product.setId(1);

        GlobalData.cart.add(product);
        setup();
        mockMvc
                .perform(MockMvcRequestBuilders.get("/addToCart/"+GlobalData.cart.get(0).getId()))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }
}
