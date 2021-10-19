package com.yash.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.yash.dev.exception.EntityNotFoundException;
import com.yash.dev.repository.ReceipeRepository;
import com.yash.dev.utils.Receipe;

/**
 * Created by Yashwanth Anand S
 **/

@RestController
public class BackendReceipeAPIController {

	@Autowired
	ReceipeRepository receipeRepository;

	@PostMapping("/")
	public Receipe createReceipe(@Valid @RequestBody Receipe receipe) {
		// System.out.println("Create Receipe Method Called");
		return receipeRepository.save(receipe);
	}

	@GetMapping("/")
	public List<Receipe> getAllReceipe() {
		System.out.println("Get All Receipe Method Called");
		return receipeRepository.findAll();
	}

	@GetMapping("/{id}")
	public Receipe getReceipe(@PathVariable(value = "id") Long id) {
		System.out.println("Get Receipe Method Called");
		return receipeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Receipe", "id", id));
	}

	@GetMapping(value = "/{id}/show")
	public String getEmployeeNameById(@PathVariable Long id) {
		Receipe receipe = receipeRepository.findReceipeImageById(id);

		String receipeImage = receipe.getImage();
		return receipeImage;
	}
}
