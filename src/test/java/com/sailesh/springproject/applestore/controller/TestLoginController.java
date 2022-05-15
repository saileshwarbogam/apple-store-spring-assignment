package com.sailesh.springproject.applestore.controller;

import com.sailesh.springproject.applestore.dao.RoleRepository;
import com.sailesh.springproject.applestore.dao.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestLoginController {

    private MockMvc mockMvc;
    LoginController loginController;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;


    @Before
    public void setup() {
        loginController = new LoginController(bCryptPasswordEncoder,userRepository,roleRepository);

        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
    }

    @Test
    public void contextLoads(){
        setup();
        Assertions.assertThat(loginController).isNotNull();
    }

    @Test
    public void testLogin() throws Exception{
        setup();
        mockMvc
                .perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("log-in"));
    }

    @Test
    public void testRegisterGet() throws Exception{
        setup();
        mockMvc
                .perform(MockMvcRequestBuilders.get("/register"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("register-view"));
    }

//    @Test
//    public void testRegisterPostIf() throws Exception {
//
//        setup();
//        mockMvc.perform(post("/register")
//                .contentType(MediaType.MULTIPART_FORM_DATA)
//                .param("firstName", "Sri")
//                .param("lastName", "Laxm")
//                .param("email", "sriles@gmail.com")
//                .param("password", "1234567a")
//        )
//                .andExpect(status().is3xxRedirection());
//    }

    @Test
    public void testRegisterPostElse() throws Exception {

        setup();
        mockMvc.perform(post("/register")
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                        .param("firstName", "S")
                        .param("lastName", "Bogam")
                        .param("email", "sailesh@gmail.com")
                        .param("password", "123abc")
                )
                .andExpect(MockMvcResultMatchers.view().name("register-view"));
    }
}
