package com.amcart.product.service.impl;

import com.amcart.product.exception.ProductNotFoundException;
import com.amcart.product.repository.ProductRepository;
import com.amcart.product.model.ProductEntity;
import com.amcart.product.model.ProductRequest;
import com.amcart.product.model.ProductResponse;
import com.amcart.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<ProductResponse> loadAllProducts() {
        List<ProductResponse> toRet = new ArrayList<>();
        List<ProductEntity> productEntities = productRepository.findAll(
                Sort.by(Sort.Direction.DESC,"createdOn"));
        productEntities.stream().forEach(productEntity->{
                ProductResponse productResponse = new ProductResponse();
                BeanUtils.copyProperties(productEntity, productResponse);
                toRet.add(productResponse);
        });
        return toRet;
    }

    @Override
    public List<ProductResponse> loadAllMasterProducts() {
        List<ProductResponse> toRet = new ArrayList<>();
        List<ProductEntity> productEntities = productRepository.findAll();
        productEntities.stream().forEach(productEntity->{
            ProductResponse productResponse = new ProductResponse();
            BeanUtils.copyProperties(productEntity, productResponse);
            toRet.add(productResponse);
        });
        return toRet;
    }

    @Override
    public ProductResponse loadProductById(String productId) {
        ProductResponse toRet = new ProductResponse();
        Optional<ProductEntity> productEntity = productRepository.findByProductId(productId);
        if(productEntity.isPresent()){
            BeanUtils.copyProperties(productEntity.get(), toRet);
        }
        else{
            throw new ProductNotFoundException("Product not found with ProductId: " + productId);
        }
        return toRet;
    }

    @Override
    public String deleteProductById(String productId) {
        String toRet = "Product deleted successfully";
        ProductResponse productResponse = loadProductById(productId);
        if(productResponse != null && productResponse.getId() != null){
            productRepository.deleteById(productResponse.getId());
            return toRet;
        }
        else {
            throw new ProductNotFoundException("Product not found with ProductId: " + productId);
        }
    }

    @Override
    public String createProduct(ProductRequest productRequest) {
        String toRet = "";
        Optional<ProductEntity> extProductEntity = productRepository.findByProductId(productRequest.getProductId());
        if(extProductEntity != null && extProductEntity.isPresent()){
            throw new ProductNotFoundException("Product Already Exist with ProductId:" + productRequest.getProductId());
        }
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(productRequest.getProductId());
        productEntity.setName(productRequest.getName());
        productEntity.setDescription(productRequest.getDescription());
        productEntity.setCategory(productRequest.getCategory());
        productEntity.setSkus(productRequest.getSkus());
        productEntity.setQuantity(productRequest.getQuantity());
        productEntity.setCreatedOn(System.currentTimeMillis());
        productEntity.setUpdatedOn(System.currentTimeMillis());
        productEntity.setCreatedBy("User");
        productEntity.setUpdatedBy("User");
        productEntity = productRepository.save(productEntity);
        if (productEntity != null && productEntity.getId() != null){
            toRet = "Product created Successfully";
        }
        return toRet;
    }
}
