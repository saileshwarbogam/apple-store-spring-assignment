package com.sailesh.springproject.applestore.global;

import com.sailesh.springproject.applestore.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {

    public static  List<Product> cart;

    static {
        cart = new ArrayList<>();
    }

    private  GlobalData() {
        throw new UnsupportedOperationException("This  class cannot be instantiated");
    }
}
