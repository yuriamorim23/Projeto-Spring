package com.projetojava.cursomc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetojava.cursomc.domain.Categoria;
import com.projetojava.cursomc.services.CategoriaService;

@RestController //
@RequestMapping (value="/categorias")
public class CategoriaResource {
	
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)// para dizer que é um get
	public ResponseEntity<?> find(@PathVariable Integer id) { // vai retornar a lista de abaixo
			Categoria obj = service.find(id);
			return ResponseEntity.ok().body(obj);
			
	}
	
}