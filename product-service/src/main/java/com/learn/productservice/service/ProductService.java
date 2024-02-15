package com.learn.productservice.service;

import com.learn.productservice.dto.ProductRequest;
import com.learn.productservice.dto.Productresponse;
import com.learn.productservice.model.Product;
import com.learn.productservice.repo.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    ProductRepository repository;

    public void createProducts(ProductRequest request){
        Product product= Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();

        repository.save(product);
        log.info("Product Id : {} saved", product.getId());
    }

    public List<Productresponse> getProducts() {
        return  repository.findAll().stream().map(this::mapResponse).toList();
    }

    private Productresponse mapResponse(Product product) {
        return Productresponse.builder()
                .id(product.getId())
                .price(product.getPrice())
                .description(product.getDescription())
                .name(product.getName())
                .build();
    }

}
