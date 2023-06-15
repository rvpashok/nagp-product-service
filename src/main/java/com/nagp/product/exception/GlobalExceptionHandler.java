package com.nagp.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<CommonExceptionModel> exception(ProductNotFoundException productNotFoundException) {
        CommonExceptionModel toRet = new CommonExceptionModel();
        toRet.setResponseCode("ProductException_0001");
        toRet.setReponseMessage(productNotFoundException.getMessage());
        return new ResponseEntity<>(toRet, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
