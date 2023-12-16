package com.amcart.product.controller;

import com.amcart.product.service.ProductService;
import com.amcart.product.model.ProductRequest;
import com.amcart.product.model.ProductResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/products")
@Api(value = "Product Management", protocols = "http")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    @ApiOperation(value = "Load all Products", response = ProductResponse.class, code = 200)
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        List<ProductResponse> toRet = new ArrayList<>();
        toRet = productService.loadAllProducts();
        return new ResponseEntity<>(toRet, HttpStatus.OK);
    }

    @PostMapping()
    @ApiOperation(value = "Create Product", response = ProductResponse.class, code = 200)
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest){
        String toRet = new String();
        toRet = productService.createProduct(productRequest);
        return new ResponseEntity<>(toRet, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    @ApiOperation(value = "Load Product by productId", response = ProductResponse.class, code = 200)
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String productId){
        ProductResponse toRet = new ProductResponse();
        toRet = productService.loadProductById(productId);
        return new ResponseEntity<>(toRet, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    @ApiOperation(value = "Delete Product by productId", response = ProductResponse.class, code = 200)
    public ResponseEntity<String> deleteProductById(@PathVariable String productId){
        String toRet = "";
        toRet = productService.deleteProductById(productId);
        return new ResponseEntity<>(toRet, HttpStatus.OK);
    }
}
