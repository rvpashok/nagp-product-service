package com.amcart.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class PingController {

    @GetMapping("ping")
    public String ping(){
        return "Product services pinging at " + System.currentTimeMillis();
    }
}
