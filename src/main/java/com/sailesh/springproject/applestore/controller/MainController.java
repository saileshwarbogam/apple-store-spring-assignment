package com.sailesh.springproject.applestore.controller;

import com.sailesh.springproject.applestore.global.GlobalData;
import com.sailesh.springproject.applestore.service.CategoryService;
import com.sailesh.springproject.applestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;


    public MainController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping({"/", "/home"})
    public String home(Model model){

        model.addAttribute("cartCount", GlobalData.cart.size());



        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model){

        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProducts());
        model.addAttribute("cartCount", GlobalData.cart.size());

        return "shop-view";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable int id){

        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProductsByCategoryId(id));
        model.addAttribute("cartCount", GlobalData.cart.size());


        return "shop-view";
    }


    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable int id){
        model.addAttribute("product",productService.getProductById(id).get()); //returns optional
        model.addAttribute("cartCount", GlobalData.cart.size());


        return "view-product";
    }

    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index){
        GlobalData.cart.remove(index);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(){

        return "cart-view";
    }



}
