package com.learn.productservice.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductRequest {

    private String name;
    private String description;
    private Long price;
}
