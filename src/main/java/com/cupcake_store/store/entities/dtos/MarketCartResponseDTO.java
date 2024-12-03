package com.cupcake_store.store.entities.dtos;

import com.cupcake_store.store.entities.Cupcake;
import com.cupcake_store.store.entities.User;
import com.cupcake_store.store.entities.enums.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MarketCartResponseDTO {

    private Long id;
    private UserDTO user;
    private List<CupcakeDTO> cupcakes;
    private String ticketStatus;
    private String createdAt;
    private String updatedAt;
}
