package com.recommendation_service.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTO {
    private long userId;
    private long productId;
    private int quantity;
    private int totalPrice;
}
