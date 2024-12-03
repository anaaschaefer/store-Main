package com.cupcake_store.store.repositories;

import com.cupcake_store.store.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
