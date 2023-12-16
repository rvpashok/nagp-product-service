package com.amcart.product.exception;


public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(){
        super("Unknown Exception Occurred");
    }

    public ProductNotFoundException(String expMsg){
        super(expMsg);
    }
}
