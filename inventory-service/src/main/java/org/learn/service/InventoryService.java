package org.learn.service;

import org.learn.dto.InventoryResponse;
import org.learn.model.Inventory;
import org.learn.repo.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository repository;


    public List<InventoryResponse> findBySkuCode() {
       return repository.findAll().stream().map(this::mapInventoryResponse).toList();
    }

    private InventoryResponse mapInventoryResponse(Inventory inventory) {
        return InventoryResponse.builder().skuCode(inventory.getSkuCode())
                .quantity(inventory.getQuantity()).build();
    }
}
