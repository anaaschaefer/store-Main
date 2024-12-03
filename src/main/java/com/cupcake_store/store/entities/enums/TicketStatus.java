package com.cupcake_store.store.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TicketStatus {
    PENDING("Pendente"),
    PREPARING("Em preparação"),
    READY("Pronto"),
    RELEASED("Foi entregue"),;

    private String description;

    public TicketStatus getNextStatus(){
        return TicketStatus.values()[(this.ordinal() + 1) % TicketStatus.values().length];
    }



}
