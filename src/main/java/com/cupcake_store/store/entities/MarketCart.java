package com.cupcake_store.store.entities;

import com.cupcake_store.store.entities.dtos.MarketCartResponseDTO;
import com.cupcake_store.store.entities.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MarketCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "market_cart_cupcake",  // Nome da tabela de junção
            joinColumns = @JoinColumn(name = "market_cart_id"),  // Chave estrangeira para MarketCart
            inverseJoinColumns = @JoinColumn(name = "cupcake_id")  // Chave estrangeira para Cupcake
    )
    private List<Cupcake> cupcakes;
    private TicketStatus ticketStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate(){
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate(){
        this.createdAt = LocalDateTime.now();
    }

    public MarketCartResponseDTO toDTO(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        return MarketCartResponseDTO.builder()
                .id(this.id)
                .user(this.user.toUserDTO())
                .cupcakes(this.cupcakes.stream().map(Cupcake::toDTO).collect(Collectors.toList()))
                .ticketStatus(this.ticketStatus.getDescription())
                .createdAt(this.createdAt.format(formatter))
                .updatedAt(this.updatedAt != null ? this.updatedAt.format(formatter) : null)
                .build();
    }
}
