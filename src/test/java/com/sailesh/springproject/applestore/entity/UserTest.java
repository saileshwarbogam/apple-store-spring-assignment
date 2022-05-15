package com.sailesh.springproject.applestore.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Test
    public void getId() {
        User user = new User();
        user.setId(1);
        assertEquals(1,user.getId());
    }

    @Test
    public void getFirstName(){
        User user = new User();
        user.setFirstName("Bogam");
        assertEquals("Bogam",user.getFirstName());
    }


    @Test
    public void getLastName(){
        User user = new User();
        user.setLastName("Sailesh");
        assertEquals("Sailesh",user.getLastName());
    }


    @Test
    public void getEmail() {
        User user = new User();

        user.setEmail("sailesh@gmail.com");

        assertEquals("sailesh@gmail.com",user.getEmail());

    }

    @Test
    public void getPassword() {
        User user = new User();

        user.setPassword("abc123");

        assertEquals("abc123",user.getPassword());
    }


//    @Test
//    public void getRoles(){
//        User user = new User();
//
//        List<Role> roles = new ArrayList<>();
//        roles.add(new Role(1,"ADMIN"));
//
//        user.setRoles(roles);
//
//        assertEquals();
//    }

}
