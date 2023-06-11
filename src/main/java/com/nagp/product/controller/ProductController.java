package com.nagp.product.controller;

import com.nagp.product.model.ProductRequest;
import com.nagp.product.model.ProductResponse;
import com.nagp.product.service.ProductService;
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
    @ApiOperation(value = "To load all products", response = ProductResponse.class, code = 200)
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        List<ProductResponse> toRet = new ArrayList<>();
        toRet = productService.loadAllProducts();
        return new ResponseEntity<>(toRet, HttpStatus.OK);
    }

    @PostMapping()
    @ApiOperation(value = "To create products", response = ProductResponse.class, code = 200)
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest){
        String toRet = new String();
        toRet = productService.createProduct(productRequest);
        return new ResponseEntity<>(toRet, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    @ApiOperation(value = "To load product by productID", response = ProductResponse.class, code = 200)
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String productId){
        ProductResponse toRet = new ProductResponse();
        toRet = productService.loadProductById(productId);
        return new ResponseEntity<>(toRet, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    @ApiOperation(value = "To delete product by productID", response = ProductResponse.class, code = 200)
    public ResponseEntity<String> deleteProductById(@PathVariable String productId){
        String toRet = "";
        toRet = productService.deleteProductById(productId);
        return new ResponseEntity<>(toRet, HttpStatus.OK);
    }
}
