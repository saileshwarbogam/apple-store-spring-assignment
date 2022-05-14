package com.sailesh.springproject.applestore.entity;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerUserDetailTest {

    @Test
    public  void getUserName() {
        User user = new User();
        CustomUserDetail customUserDetail = new CustomUserDetail(user);

        customUserDetail.setEmail("abc@gmail.com");

        assertEquals("abc@gmail.com",customUserDetail.getEmail());

    }

    @Test
    public  void getPassword() {
        User user = new User();
        CustomUserDetail customUserDetail = new CustomUserDetail(user);

        customUserDetail.setPassword("123abc");

        assertEquals("123abc",customUserDetail.getPassword());

    }


    @Test
    public  void isAccountNonExpired() {
        User user = new User();
        CustomUserDetail customUserDetail = new CustomUserDetail(user);

        assertEquals(true,customUserDetail.isAccountNonExpired());

    }

    @Test
    public  void isAccountNonLocked() {
        User user = new User();
        CustomUserDetail customUserDetail = new CustomUserDetail(user);

        assertEquals(true,customUserDetail.isAccountNonLocked());

    }


    @Test
    public  void isCredentialsNonExpired() {
        User user = new User();
        CustomUserDetail customUserDetail = new CustomUserDetail(user);

        assertEquals(true,customUserDetail.isCredentialsNonExpired());

    }


    @Test
    public  void isEnabled() {
        User user = new User();
        CustomUserDetail customUserDetail = new CustomUserDetail(user);

        assertEquals(true,customUserDetail.isEnabled());

    }


}
