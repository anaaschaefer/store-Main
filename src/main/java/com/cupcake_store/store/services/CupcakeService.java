package com.cupcake_store.store.services;

import com.cupcake_store.store.entities.Cupcake;
import com.cupcake_store.store.repositories.CupcakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CupcakeService {

	@Autowired
	private CupcakeRepository cupcakeRepository;

	public List<Cupcake> findAllCupcakes(){
		return cupcakeRepository
				.findAll();
	}

	public Cupcake findById(Long id){
		return cupcakeRepository
				.findById(id)
				.get();
	}

	public List<Cupcake> findAllById(List<Long> ids){
		return cupcakeRepository
				.findAllById(ids);
	}

	public Cupcake save(Cupcake cupcake){
		return cupcakeRepository
				.saveAndFlush(cupcake);
	}

	public void delete(Long id){
		cupcakeRepository.deleteById(id);
	}

    public List<Cupcake> saveAll(List<Cupcake> cupcake) {
		return cupcakeRepository.saveAll(cupcake);
    }


}
