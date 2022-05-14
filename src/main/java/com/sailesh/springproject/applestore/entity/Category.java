package com.sailesh.springproject.applestore.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    @Column(name = "name")
    private String name;

    public Category(){}

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
