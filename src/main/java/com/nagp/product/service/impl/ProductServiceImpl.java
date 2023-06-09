package com.nagp.product.service.impl;

import com.nagp.product.model.ProductEntity;
import com.nagp.product.model.ProductResponse;
import com.nagp.product.repository.ProductRepository;
import com.nagp.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<ProductResponse> loadAllProducts() {
        List<ProductResponse> toRet = new ArrayList<>();
        List<ProductEntity> productEntities = productRepository.findAll();
        productEntities.stream().forEach(productEntity->{
                ProductResponse productResponse = new ProductResponse();
                BeanUtils.copyProperties(productEntity, productResponse);
                toRet.add(productResponse);
        });
        return toRet;
    }
}
