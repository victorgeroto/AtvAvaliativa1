package com.AtvAvaliativa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AtvAvaliativa.entity.Fornecedor;
import com.AtvAvaliativa.service.FornecedorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
	private final FornecedorService fornecedorService;

	@Autowired
	public FornecedorController(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> getFornecedorById(@PathVariable Long id) {
		Fornecedor Fornecedor = fornecedorService.getFornecedorById(id);
		if (Fornecedor != null) {
			return ResponseEntity.ok(Fornecedor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Fornecedor>> getAllFornecedor() {
		List<Fornecedor> Fornecedor = fornecedorService.getAllFornecedor();
		return ResponseEntity.ok(Fornecedor);
	}

	@PostMapping("/")
	public ResponseEntity<Fornecedor> criarFornecedor(@RequestBody @Valid Fornecedor Fornecedor) {
		Fornecedor criarFornecedor = fornecedorService.salvarFornecedor(Fornecedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarFornecedor);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Fornecedor> updateFornecedor(@PathVariable Long id, @RequestBody @Valid Fornecedor Fornecedor) {
		Fornecedor updatedFornecedor = fornecedorService.updatefornecedor(id, Fornecedor);
		if (updatedFornecedor != null) {
			return ResponseEntity.ok(updatedFornecedor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFornecedor(@PathVariable Long id) {
		boolean deleted = fornecedorService.deleteFornecedor(id);
		if (deleted) {
			return ResponseEntity.ok().body("o Fornecedor foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}

