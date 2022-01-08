package com.projetojava.cursomc.services;

import java.util.Optional;

import com.projetojava.cursomc.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojava.cursomc.domain.Pedido;
import com.projetojava.cursomc.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired // esssa dependica vai ser instanciada usando o obj REPO
	private PedidoRepository repo;
	
	// codigo para buscar por id, vamos agora mudar no Resource o RequestMapping com value="/{id}"
	public Pedido find(Integer id) { 
		 Optional<Pedido> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName(), null));
	}
	
}
