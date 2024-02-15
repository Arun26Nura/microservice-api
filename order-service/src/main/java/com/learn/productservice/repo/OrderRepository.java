package com.learn.productservice.repo;

import com.learn.productservice.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends JpaRepository<Orders,Long> {
}
