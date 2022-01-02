package com.projetojava.cursomc.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojava.cursomc.domain.Categoria;
import com.projetojava.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired // esssa dependica vai ser instanciada usando o obj REPO
	private CategoriaRepository repo;
	
	// codigo para buscar por id, vamos agora mudar no Resource o RequestMapping com value="/{id}"
	public Categoria find(Integer id) {
		 Optional<Categoria> obj = repo.findById(id);
		 if (obj == null) {
			 throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id
					 + ", Tipo: " + Categoria.class.getName(), null);
					 
		 }
		return obj.orElse(null);
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
}
