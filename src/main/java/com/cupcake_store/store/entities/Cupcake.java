package com.cupcake_store.store.entities;

import com.cupcake_store.store.entities.dtos.CupcakeDTO;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Cupcake {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Float price;
	private String image;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	@ManyToMany(mappedBy = "cupcakes",fetch = FetchType.LAZY)
	private List<MarketCart> marketCarts;

	public CupcakeDTO toDTO() {
		return  CupcakeDTO.builder()
				.id(this.id)
				.name(this.name)
				.description(this.description)
				.price(this.price)
				.image(this.image)
				.createdAt(this.createdAt)
				.updatedAt(this.updatedAt)
				.build();
	}

	@PrePersist
	public void onCreate(){
		this.createdAt = LocalDateTime.now();
	}

	@PreUpdate
	public void onUpdate(){
		this.createdAt = LocalDateTime.now();
	}
}
