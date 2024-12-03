package com.cupcake_store.store.repositories;

import com.cupcake_store.store.entities.Cupcake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CupcakeRepository extends JpaRepository<Cupcake, Long> {
}
