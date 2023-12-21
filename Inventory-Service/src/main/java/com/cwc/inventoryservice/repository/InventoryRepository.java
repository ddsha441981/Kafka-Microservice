package com.cwc.inventoryservice.repository;

import com.cwc.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Deendayal Kumawat
 */
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
//    Optional<Inventory> findBySkuCode(List<String> skuCode);

    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
