package com.nagp.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    String id;
    String productId;
    String name;
    String description;
    List<String> skus;
    Category category;
    long quantity;
    long createdOn;
    long updatedOn;
    String createdBy;
    String updatedBy;
}
