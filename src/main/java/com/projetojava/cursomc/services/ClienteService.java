package com.projetojava.cursomc.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojava.cursomc.domain.Cliente;
import com.projetojava.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired // esssa dependica vai ser instanciada usando o obj REPO
	private ClienteRepository repo;
	
	// codigo para buscar por id, vamos agora mudar no Resource o RequestMapping com value="/{id}"
	public Cliente find(Integer id) {
		 Optional<Cliente> obj = repo.findById(id);
		 if (obj == null) {
			 throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id
					 + ", Tipo: " + Cliente.class.getName(), null);
					 
		 }
		return obj.orElse(null);
	}
	
}
