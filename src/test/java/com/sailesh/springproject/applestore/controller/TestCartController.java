package com.sailesh.springproject.applestore.controller;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCartController {

    private MockMvc mockMvc;

    CartController cartController;

    @Before
    public void setup() {
       cartController = new CartController();
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
}
