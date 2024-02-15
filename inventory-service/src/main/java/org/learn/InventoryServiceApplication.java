package org.learn;

import org.learn.model.Inventory;
import org.learn.repo.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication  implements CommandLineRunner {

	public static void main(String[] args)  {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Autowired
	InventoryRepository inventoryRepository;

	@Override
	public void run(String... args) throws Exception {

		Inventory inventory= Inventory.builder().skuCode("AQA").quantity(200).build();
		Inventory inventory1=Inventory.builder().skuCode("AQB").quantity(200).build();
		inventoryRepository.save(inventory1);
		inventoryRepository.save(inventory);

	}
}
