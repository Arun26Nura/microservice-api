package com.learn.productservice.controller;

import com.learn.productservice.dto.OrderRequest;
import com.learn.productservice.model.Orders;
import com.learn.productservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest request){
        service.placeOrder(request);

        return "Order Placed !";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Orders> findAll(){
       return service.findAll();

    }


}
