package com.learn.productservice.dto;

import lombok.*;



@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Productresponse {

    private int id;
    private String name;
    private String description;
    private Long price;
}
