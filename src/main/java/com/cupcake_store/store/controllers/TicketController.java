package com.cupcake_store.store.controllers;

import com.cupcake_store.store.entities.Ticket;
import com.cupcake_store.store.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ticket")
@CrossOrigin("*")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("{id}")
    public ResponseEntity<Ticket> findById(@PathVariable Long id) {
        return new ResponseEntity<>(ticketService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> findAll() {
        return new ResponseEntity<>(ticketService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ticket> create(@RequestBody Ticket ticket) {
        return new ResponseEntity<>(ticketService.save(ticket), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ticketService.delete(id);
        return new ResponseEntity<>("Compra deletada com sucesso!!", HttpStatus.OK);
    }

}
