package com.spring.springboot.entity;

import lombok.Data;

@Data
//@Entity
public class Category {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
}
