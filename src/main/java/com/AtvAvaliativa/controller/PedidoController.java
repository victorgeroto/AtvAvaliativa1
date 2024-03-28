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

import com.AtvAvaliativa.entity.Pedido;
import com.AtvAvaliativa.service.PedidoService;

@RestController
@RequestMapping("/Pedido")
public class PedidoController {
	private final PedidoService PedidoService;

	@Autowired
	public PedidoController(PedidoService PedidoService) {
		this.PedidoService = PedidoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
		Pedido Pedido = PedidoService.getPedidoById(id);
		if (Pedido != null) {
			return ResponseEntity.ok(Pedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Pedido>> getAllPedido() {
		List<Pedido> Pedido = PedidoService.getAllPedido();
		return ResponseEntity.ok(Pedido);
	}

	@PostMapping("/")
	public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido Pedido) {
		Pedido criarPedido = PedidoService.salvarPedido(Pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarPedido);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody Pedido pedido) {
		Pedido updatedPedido = PedidoService.updatepedido(id, pedido);
		if (updatedPedido != null) {
			return ResponseEntity.ok(updatedPedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePedido(@PathVariable Long id) {
		boolean deleted = PedidoService.deletePedido(id);
		if (deleted) {
			return ResponseEntity.ok().body("O Pedido foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}