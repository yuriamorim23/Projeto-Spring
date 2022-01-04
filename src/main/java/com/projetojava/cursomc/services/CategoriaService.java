 package com.projetojava.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.projetojava.cursomc.domain.Categoria;
import com.projetojava.cursomc.dto.CategoriaDTO;
import com.projetojava.cursomc.repositories.CategoriaRepository;
import com.projetojava.cursomc.services.exception.DataIntegrityException;

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
	
	public Categoria insert(Categoria obj) { //metodo get
		obj.setId(null);
		return repo.save(obj);
		
	}

	public Categoria update(Categoria obj) { // metodo put
		Categoria newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) { // metodo delete
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) { //Exception handle do delete
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
	    }
	}

	public List<Categoria> findAll() { // get de todos itens da categoria
		return repo.findAll();
	}
	
	
	//metodo para paginacao
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());
	}
	
	private void updateData(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}
	
}


