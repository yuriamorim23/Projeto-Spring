package com.projetojava.cursomc.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //
@RequestMapping (value="/categorias")
public class CategoriaResource {
	
	@RequestMapping(method=RequestMethod.GET)// para dizer que é um get
	public String listar() {
		return "REST está funcionando";
		}
}