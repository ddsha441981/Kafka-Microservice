package com.cwc.inventoryservice.dto;

import lombok.*;

/**
 * @author Deendayal Kumawat
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class InventoryResponse {

    private String skuCode;
    private boolean isInStock;

}
