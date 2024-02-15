package org.learn.controller;

import org.learn.dto.InventoryResponse;
import org.learn.model.Inventory;
import org.learn.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> findBySkuCode(){
      return  inventoryService.findBySkuCode();
    }
}
