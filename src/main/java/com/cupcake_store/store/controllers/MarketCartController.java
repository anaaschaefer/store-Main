package com.cupcake_store.store.controllers;

import com.cupcake_store.store.entities.MarketCart;
import com.cupcake_store.store.entities.dtos.MarketCartRequestDTO;
import com.cupcake_store.store.entities.dtos.MarketCartResponseDTO;
import com.cupcake_store.store.services.MarketCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("market-cart")
@CrossOrigin("*")
public class MarketCartController {
    @Autowired
    private MarketCartService marketCartService;

    @GetMapping
    public ResponseEntity<List<MarketCartResponseDTO>> findAll(){
        List<MarketCartResponseDTO> marketCartDTO = marketCartService.findAll()
                .stream()
                .map(MarketCart::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(marketCartDTO, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<MarketCartResponseDTO> findById(@PathVariable Long id){
        MarketCartResponseDTO marketCartDTO = marketCartService.findById(id).toDTO();
        return new ResponseEntity<>(marketCartDTO, HttpStatus.OK);
    }

    //@PostMapping
    public ResponseEntity<MarketCartResponseDTO> create(@RequestBody MarketCart marketCart){
        MarketCartResponseDTO marketCartDTO = marketCartService.save(marketCart).toDTO();
        return new ResponseEntity<>(marketCartDTO, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@PathVariable Long id){
        marketCartService.delete(id);
        return new ResponseEntity<>("Carrinho deletado com sucesso!", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MarketCartResponseDTO> buildCart(@RequestBody MarketCartRequestDTO MarketCartRequestDTO){
        MarketCartResponseDTO marketCart = marketCartService.buildAndSaveCart(MarketCartRequestDTO).toDTO();
        return new ResponseEntity<>(marketCart, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<MarketCartResponseDTO> updateStatus(@PathVariable Long id){
        MarketCartResponseDTO marketCart = marketCartService.updateStatus(id).toDTO();
        return new ResponseEntity<>(marketCart, HttpStatus.OK);
    }
}
