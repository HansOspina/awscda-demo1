package com.hansospina.jconf.co.demo1.product;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private String description;
    private Float price;
}
