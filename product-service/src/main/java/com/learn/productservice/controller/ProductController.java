package com.learn.productservice.controller;

import com.learn.productservice.dto.ProductRequest;
import com.learn.productservice.dto.Productresponse;
import com.learn.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        service.createProducts(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Productresponse> getProducts(){
       return service.getProducts();
    }
}
