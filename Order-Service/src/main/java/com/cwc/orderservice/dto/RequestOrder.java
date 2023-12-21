package com.cwc.orderservice.dto;

import lombok.*;

import java.util.List;

/**
 * @author Deendayal Kumawat
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
public class RequestOrder {

    private List<OrderItemsDto> orderItemsDtos;
}
