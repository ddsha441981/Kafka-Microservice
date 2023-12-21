package com.cwc.inventoryservice.service;

import com.cwc.inventoryservice.dto.InventoryResponse;

import java.util.List;

/**
 * @author Deendayal Kumawat
 */
public interface InventoryService {
    public List<InventoryResponse> isStockAvailable(List<String> skuCode);
}
