package com.nagp.product.service.impl;

import com.nagp.product.model.ProductResponse;
import com.nagp.product.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    @Override
    public List<ProductResponse> loadAllProducts() {
        List<ProductResponse> toRet = new ArrayList<>();
        ProductResponse productResponse = new ProductResponse("1", "product-1", "Product sample", 10);
        toRet.add(productResponse);
        return toRet;
    }
}
