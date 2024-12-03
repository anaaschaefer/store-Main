package com.cupcake_store.store.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MarketCartRequestDTO {
    private Long userId;
    private List<Long> cupcakeIds;
}
