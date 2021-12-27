package com.projetojava.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projetojava.cursomc.domain.Categoria;
import com.projetojava.cursomc.domain.Cidade;
import com.projetojava.cursomc.domain.Cliente;
import com.projetojava.cursomc.domain.Endereco;
import com.projetojava.cursomc.domain.Estado;
import com.projetojava.cursomc.domain.Produto;
import com.projetojava.cursomc.domain.enums.TipoCliente;
import com.projetojava.cursomc.repositories.CategoriaRepository;
import com.projetojava.cursomc.repositories.CidadeRepository;
import com.projetojava.cursomc.repositories.ClienteRepository;
import com.projetojava.cursomc.repositories.EnderecoRepository;
import com.projetojava.cursomc.repositories.EstadoRepository;
import com.projetojava.cursomc.repositories.ProdutoRepository;

//@SpringBootApplication
//public class CursomcApplication {


@SpringBootApplication
public class CursomcApplication implements CommandLineRunner { // Command permite exucutar um metodo auxiliar
	
	@Autowired //importando repository //apos importar salvar no salveAll array list
	private CategoriaRepository categoriaRepository;
	
	@Autowired //importando repository //apos importar salvar no salveAll array list
	private ProdutoRepository produtoRepository;
	
	@Autowired //importando repository //apos importar salvar no salveAll array list
	private EstadoRepository estadoRepository;
	
	@Autowired //importando repository // apos importar salvar no salveAll array list
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { // assinatura do metodo
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		
		//Relacionamento das tabelas
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat1.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Sao Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);	
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "3245687", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("345624", "64542365"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "354626578", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38772064", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));	
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
	}
	
}
