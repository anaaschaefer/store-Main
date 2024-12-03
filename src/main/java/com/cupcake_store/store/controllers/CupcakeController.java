package com.cupcake_store.store.controllers;

import com.cupcake_store.store.entities.Cupcake;
import com.cupcake_store.store.entities.dtos.CupcakeDTO;
import com.cupcake_store.store.services.CupcakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cupcakes")
@CrossOrigin("*")
public class CupcakeController {

	@Autowired
	private CupcakeService cupcakeService;

	@GetMapping
	public ResponseEntity<List<CupcakeDTO>> getAllCupcakes(){
		List<CupcakeDTO> allCupcakes = cupcakeService
				.findAllCupcakes()
				.stream()
				.map(Cupcake::toDTO)
				.collect(Collectors.toList());
		return new ResponseEntity<>(allCupcakes, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CupcakeDTO> getCupcakesById(@PathVariable Long id){
		CupcakeDTO cupcakeDTO = cupcakeService.findById(id).toDTO();
		return new ResponseEntity<>(cupcakeDTO, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CupcakeDTO> saveCupcake(@RequestBody Cupcake cupcake){
		CupcakeDTO cupcakeDTO = cupcakeService.save(cupcake).toDTO();
		return new ResponseEntity<>(cupcakeDTO, HttpStatus.CREATED);
	}

	@PostMapping("all")
	public ResponseEntity<List<Cupcake>> saveAll(@RequestBody List<Cupcake> cupcake){
		return new ResponseEntity<>(cupcakeService.saveAll(cupcake), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCupcakeById(@PathVariable Long id){
		cupcakeService.delete(id);
		return ResponseEntity.ok("Cupcake deletado com sucesso");
	}
}
