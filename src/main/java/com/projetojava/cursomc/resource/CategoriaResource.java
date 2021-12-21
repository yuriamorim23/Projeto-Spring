package com.projetojava.cursomc.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetojava.cursomc.domain.Categoria;

@RestController //
@RequestMapping (value="/categorias")
public class CategoriaResource {
	
	@RequestMapping(method=RequestMethod.GET)// para dizer que é um get
	public List<Categoria> listar() { // vai retornar a lista de abaixo
		
		Categoria cat1 = new Categoria(1, "informática"); // itens que fazer parte do list
		Categoria cat2 = new Categoria(2, "Escritório");
		
		List<Categoria> lista = new ArrayList<>(); // metodo para criar um array
		lista.add(cat1);
		lista.add(cat2);
		
		
		return lista;
		}
}