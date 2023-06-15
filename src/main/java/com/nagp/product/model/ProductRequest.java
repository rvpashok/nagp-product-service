package com.nagp.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProductRequest {
    String productId;
    String name;
    String description;
    List<String> skus;
    Category category;
    long quantity;
}
