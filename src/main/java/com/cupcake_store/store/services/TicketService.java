package com.cupcake_store.store.services;

import com.cupcake_store.store.entities.Ticket;
import com.cupcake_store.store.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket findById(Long id) {
        return ticketRepository.findById(id).get();
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }
}
