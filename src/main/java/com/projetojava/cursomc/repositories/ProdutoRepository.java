package com.projetojava.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetojava.cursomc.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
