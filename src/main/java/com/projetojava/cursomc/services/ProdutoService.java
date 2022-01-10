package com.projetojava.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.projetojava.cursomc.domain.Categoria;
import com.projetojava.cursomc.domain.Produto;
import com.projetojava.cursomc.repositories.CategoriaRepository;
import com.projetojava.cursomc.repositories.ProdutoRepository;
import com.projetojava.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired // esssa dependica vai ser instanciada usando o obj REPO
	private ProdutoRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	// codigo para buscar por id, vamos agora mudar no Resource o RequestMapping com value="/{id}"
	public Produto find(Integer id) { 
		 Optional<Produto> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName(), null));
	}

	
	// ex http://localhost:8080/produtos/?nome=t&categorias=1,4
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		Pageable pageRequest = null;
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}
}



