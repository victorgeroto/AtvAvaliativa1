package com.AtvAvaliativa.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.AtvAvaliativa.entity.Pedido;
import com.AtvAvaliativa.repository.PedidoRepository;

@Service
public class PedidoService  {
	
private final PedidoRepository pedidoRepository;
	
	@Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
	
	  public List<Pedido> getAllPedido() {
	        return pedidoRepository.findAll();
	    }

	    public Pedido getPedidoById(Long id) {
	        Optional<Pedido> pedido = pedidoRepository.findById(id);
	        return pedido.orElse(null);
	    }

	    public Pedido salvarPedido(Pedido pedido) {
	        return pedidoRepository.save(pedido);
	    }

	    public Pedido updatepedido(Long id, Pedido updatedPedido) {
	        Optional<Pedido> existingPedido = pedidoRepository.findById(id);
	        if (existingPedido.isPresent()) {
	            updatedPedido.setId(id);
	            return pedidoRepository.save(updatedPedido);
	        }
	        return null;
	    }

	    public boolean deletePedido(Long id) {
	        Optional<Pedido> existingPedido = pedidoRepository.findById(id);
	        if (existingPedido.isPresent()) {
	        	pedidoRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	  
}


