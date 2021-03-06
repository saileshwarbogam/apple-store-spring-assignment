package com.sailesh.springproject.applestore.controller;

import com.sailesh.springproject.applestore.dto.ProductDTO;
import com.sailesh.springproject.applestore.entity.Category;
import com.sailesh.springproject.applestore.entity.Product;
import com.sailesh.springproject.applestore.service.CategoryService;
import com.sailesh.springproject.applestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController {

    public static final String uploadDir = System.getProperty("user.dir")+"/src/main/resources/static/product-images";

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    String categoryStr = "category";

    public AdminController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/admin")
    public String admin(){

        return "admin-home";
    }

    @GetMapping("/admin/categories")
    public String getCategories(Model model) {
        model.addAttribute("categories",categoryService.getAllCategory());
        return categoryStr;
    }

    @GetMapping("/admin/categories/add")
    public String getCategoriesAdd(Model model) {
        model.addAttribute(categoryStr,new Category());
        return "categories-add";
    }

    @PostMapping("/admin/categories/add")
    public String postCategoriesAdd(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable int id){
        categoryService.deleteCategoryById(id);

        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCategory(@PathVariable int id, Model model){
        Optional<Category> category = categoryService.getCategoryById(id);

        if(category.isPresent()){
            model.addAttribute(categoryStr, category);
            return "categories-add";
        }
        else{
            return "404";
        }

    }


    //product controllers

    @GetMapping("/admin/products")
    public String getProducts(Model model){
        model.addAttribute("products",productService.getAllProducts());

        return "product";
    }

    @GetMapping("/admin/products/add")
    public String getAddProduct(Model model){
        model.addAttribute("productDTO",new ProductDTO());
        model.addAttribute("categories",categoryService.getAllCategory());

        return "products-add";
    }

    @PostMapping("/admin/products/add")
    public  String postAddProduct(@ModelAttribute("productDTO")ProductDTO productDTO,
                                  @RequestParam("productImage")MultipartFile file,
                                  @RequestParam("imgName")String imgName) throws IOException {

        Product product = new Product();

        product.setId(productDTO.getId());
        product.setName(productDTO.getName());

        if(categoryService.getCategoryById(productDTO.getCategoryId()).isPresent()) {
            product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());

        }
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        String imageUUID;

        if(!file.isEmpty()){
            imageUUID = file.getOriginalFilename();

            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);

            Files.write(fileNameAndPath, file.getBytes());
        }
        else {
            imageUUID = imgName;
        }

        product.setImageName(imageUUID);

        productService.addProduct(product);

        return "redirect:/admin/products";


    }

    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }

}
