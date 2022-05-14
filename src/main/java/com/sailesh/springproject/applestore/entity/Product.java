package com.sailesh.springproject.applestore.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "category_id",referencedColumnName = "category_id")
    private Category category;

    private double price;
    private String description;
    private String imageName;


    public Product(){}

    public Product(int id, String name, Category category, double price, String description, String imageName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.imageName = imageName;
    }



}
