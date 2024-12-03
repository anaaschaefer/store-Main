package com.cupcake_store.store.services;

import com.cupcake_store.store.entities.Cupcake;
import com.cupcake_store.store.entities.MarketCart;
import com.cupcake_store.store.entities.User;
import com.cupcake_store.store.entities.dtos.MarketCartRequestDTO;
import com.cupcake_store.store.entities.enums.TicketStatus;
import com.cupcake_store.store.repositories.MarketCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarketCartService {

    @Autowired
    private MarketCartRepository marketCartRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CupcakeService cupcakeService;

    public MarketCart findById(Long id) {
        return marketCartRepository.findById(id).get();
    }

    public List<MarketCart> findAll() {
        return marketCartRepository.findAll();
    }

    public MarketCart save(MarketCart marketCart) {
        return marketCartRepository.save(marketCart);
    }

    public void delete(Long id) {
        marketCartRepository.deleteById(id);
    }

    public MarketCart buildAndSaveCart(MarketCartRequestDTO marketCartRequestDTO) {
        User user = userService.findById(marketCartRequestDTO.getUserId());
        List<Cupcake> cupcakes = marketCartRequestDTO.getCupcakeIds()
                .stream()
                .map(e -> cupcakeService.findById(e))
                .toList();

        MarketCart cart = MarketCart.builder()
                .user(user)
                .cupcakes(cupcakes)
                .ticketStatus(TicketStatus.PENDING)
                .build();
        return marketCartRepository.save(cart);
    }

    public MarketCart updateStatus(Long id) {
        MarketCart cart = findById(id);
        cart.setTicketStatus(cart.getTicketStatus().getNextStatus());
        return marketCartRepository.save(cart);
    }
}
