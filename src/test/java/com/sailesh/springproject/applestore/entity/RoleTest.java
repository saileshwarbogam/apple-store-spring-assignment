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
public class RoleTest {

    @Test
    public void getId(){
        Role role = new Role();

        role.setId(1);
        assertEquals(1,role.getId());
    }

    @Test
    public void getName(){
        Role role = new Role();
        role.setName("USER");
        assertEquals("USER",role.getName());
    }

    @Test
    public void testConstructor() {
        Role role = new Role(1,"ROLE_ADMIN");

    }


}
