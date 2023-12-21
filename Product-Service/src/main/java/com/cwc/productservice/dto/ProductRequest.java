package com.cwc.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

/**
 * @author Deendayal Kumawat
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

}
