package com.nagp.product.service;

import com.nagp.product.model.ProductRequest;
import com.nagp.product.model.ProductResponse;
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
