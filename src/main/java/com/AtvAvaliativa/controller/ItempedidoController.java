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

import com.AtvAvaliativa.entity.Itempedido;
import com.AtvAvaliativa.service.ItempedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/itempedido")
public class ItempedidoController {
	private final ItempedidoService itempedidoService;

	@Autowired
	public ItempedidoController(ItempedidoService itempedidoService) {
		this.itempedidoService = itempedidoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Itempedido> getitempedidoById(@PathVariable Long id) {
		Itempedido itempedido = itempedidoService.getItempedidoById(id);
		if (itempedido != null) {
			return ResponseEntity.ok(itempedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Itempedido>> getAllItempedido() {
		List<Itempedido> itempedido = itempedidoService.getAllItempedido();
		return ResponseEntity.ok(itempedido);
	}

	@PostMapping("/")
	public ResponseEntity<Itempedido> criarItempedido(@RequestBody @Valid Itempedido itempedido) {
		Itempedido criarItempedido = itempedidoService.salvarItempedido(itempedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarItempedido);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Itempedido> updateItempedido(@PathVariable Long id,@RequestBody Itempedido itempedido) {
		Itempedido updatedItempedido = itempedidoService.updateitempedido(id, itempedido);
		if (updatedItempedido != null) {
			return ResponseEntity.ok(updatedItempedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteItempedido(@PathVariable Long id) {
		boolean deleted = itempedidoService.deleteItempedido(id);
		if (deleted) {
			return ResponseEntity.ok().body("O Itempedido foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}



