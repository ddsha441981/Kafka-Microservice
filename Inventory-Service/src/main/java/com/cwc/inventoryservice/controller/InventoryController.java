package com.cwc.inventoryservice.controller;

import com.cwc.inventoryservice.dto.InventoryResponse;
import com.cwc.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Deendayal Kumawat
 */
@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryService inventoryService;

    // http://localhost:9593/api/v1/inventory/iphone-13,iphone13-red ====>@PathVariable

    // http://localhost:9593/api/v1/inventory?skuCode=iphone-13&skuCode=iphone13-red ====>@RequestParam

    @GetMapping
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
        List<InventoryResponse> stockAvailable = this.inventoryService.isStockAvailable(skuCode);
        return stockAvailable;
    }
}
