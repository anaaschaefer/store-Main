package com.cupcake_store.store.entities.dtos;

import com.cupcake_store.store.entities.MarketCart;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CupcakeDTO {
    private Long id;
    private String name;
    private String description;
    private Float price;
    private String image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
