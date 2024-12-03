package com.cupcake_store.store.repositories;

import com.cupcake_store.store.entities.MarketCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketCartRepository extends JpaRepository<MarketCart, Long> {
}
