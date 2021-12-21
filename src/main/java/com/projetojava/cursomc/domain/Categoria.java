package com.projetojava.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer Id;
	private String nome;
	
	public Categoria() {		
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(Id, other.Id);
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria(Integer id, String nome) {
		super();
		Id = id;
		this.nome = nome;
	}
	
	
}
