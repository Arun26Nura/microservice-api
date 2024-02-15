package com.learn.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {



    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private Long price;
}
