package com.amcart.product.service;

import com.amcart.product.model.ProductRequest;
import com.amcart.product.model.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductResponse> loadAllProducts();
    List<ProductResponse> loadAllMasterProducts();
    ProductResponse loadProductById(String productId);
    String deleteProductById(String productId);
    String createProduct(ProductRequest productRequest);
}
