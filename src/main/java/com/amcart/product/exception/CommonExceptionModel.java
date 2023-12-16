package com.amcart.product.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonExceptionModel {
    String responseCode;
    String reponseMessage;
}
