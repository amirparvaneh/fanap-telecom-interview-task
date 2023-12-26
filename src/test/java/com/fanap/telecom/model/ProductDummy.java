package com.fanap.telecom.model;

public class ProductDummy {

    public static Product productBuilder(){
        return Product.builder()
                .name("a")
                .build();
    }
}
