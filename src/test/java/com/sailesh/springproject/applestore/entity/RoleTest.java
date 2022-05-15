package com.sailesh.springproject.applestore.entity;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
}
