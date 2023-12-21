package com.cwc.inventoryservice;

import com.cwc.inventoryservice.model.Inventory;
import com.cwc.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){

        return arg -> {
			Inventory inventory0 = new Inventory();
			inventory0.setSkuCode("Iphone 13");
			inventory0.setQuantity(100);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("Iphone 13 Red");
			inventory1.setQuantity(0);

			inventoryRepository.save(inventory0);
			inventoryRepository.save(inventory1);
		};

    }


}
