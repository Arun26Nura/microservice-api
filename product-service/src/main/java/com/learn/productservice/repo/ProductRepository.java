package com.learn.productservice.repo;

import com.learn.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Integer> {
}
