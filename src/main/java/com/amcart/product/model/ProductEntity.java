package com.amcart.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Products")
public class ProductEntity {
    @Id
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
