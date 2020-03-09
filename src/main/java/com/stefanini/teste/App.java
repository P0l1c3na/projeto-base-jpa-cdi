package com.stefanini.teste;

import com.stefanini.model.Endereco;
import com.stefanini.model.Perfil;
import com.stefanini.model.Pessoa;
import com.stefanini.servico.PessoaServico;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;

public class App {

	@Inject
	private PessoaServico servico;

	public static void main(String[] args) {
		// CONFIGURACAO PARA INICIAR O CONTAINER PARA GERENCIAMENTO DO CDI
		SeContainerInitializer initializer = SeContainerInitializer.newInstance();
		try (final SeContainer container = initializer.initialize()) {
			App app = container.select(App.class).get();
			app.executar();
		}
	}

	public void executar() {
		buscarTodos();
//		encontrar();
//		salvar();
//		remover();
	}
	
	
	private void remover() {
		servico.remover(5L);
	}

	private void encontrar() {
		Optional<Pessoa> pessoa = servico.encontrar(5L);
		if (pessoa.isPresent()) {
			System.out.println("Pessoa encontrada");
			System.out.println(pessoa.get());
		} else {
			System.out.println("Pessoa não encontrada");
		}
	}

	private void buscarTodos() {
		servico.getList().ifPresent(i -> {
			i.forEach(b -> {
				System.out.println(b.getEnderecos());
				System.out.println(b);
			});
		});
//		System.out.println();
	}

	public void salvar() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Raphael");
		pessoa.setDataNascimento(LocalDate.of(1997, 8, 23));
		pessoa.setEmail("phaelpolicena@gmail.com");
		pessoa.setSituacao(true);
		pessoa.setPerfils(new HashSet<Perfil>());
		pessoa.setEnderecos(new HashSet<Endereco>());
		servico.salvar(pessoa);

		Endereco endereco = new Endereco();
		endereco.setUf("GO");
		endereco.setLogradouro("Ap");
		endereco.setCep("74280530");
		endereco.setBairro("Maria Ines");

	}

}
