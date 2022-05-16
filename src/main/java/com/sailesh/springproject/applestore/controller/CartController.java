package com.sailesh.springproject.applestore.controller;


import com.sailesh.springproject.applestore.entity.Product;
import com.sailesh.springproject.applestore.global.GlobalData;
import com.sailesh.springproject.applestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {

    @Autowired
    ProductService productService;

    public CartController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id){
        if(productService.getProductById(id).isPresent()){
            GlobalData.cart.add(productService.getProductById(id).get());
        }


        return "redirect:/shop";
    }


    @GetMapping("/cart")
    public String cartGet(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart", GlobalData.cart);

        return "cart-view";
    }
}
