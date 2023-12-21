package com.cwc.inventoryservice.service.impl;

import com.cwc.inventoryservice.dto.InventoryResponse;
import com.cwc.inventoryservice.repository.InventoryRepository;
import com.cwc.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Deendayal Kumawat
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    @Transactional(readOnly = true)
    @Override
    public List<InventoryResponse> isStockAvailable(List<String> skuCode) {
        return this.inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory->
            InventoryResponse.builder().skuCode(inventory.getSkuCode())
                    .isInStock(inventory.getQuantity()>0)
                    .build()
        ).toList();
    }
}
