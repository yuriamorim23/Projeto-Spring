package com.projetojava.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetojava.cursomc.domain.Categoria;

@Repository // O Integer está associada a classe Categoria
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
