package com.stefanini.teste;

import com.stefanini.model.Endereco;
import com.stefanini.model.Perfil;
import com.stefanini.model.Pessoa;
import com.stefanini.service.EnderecoService;
import com.stefanini.service.PerfilService;
import com.stefanini.service.PessoaService;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;


public class App {

    @Inject
    private PessoaService pessoaService;

    @Inject
    private EnderecoService enderecoService;

    @Inject
    private PerfilService perfilService;

    public static void main(String[] args) {
        //CONFIGURACAO PARA INICIAR O CONTAINER PARA GERENCIAMENTO DO CDI
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        try (final SeContainer container = initializer.initialize()) {
            App app = container.select(App.class).get();
            app.executar();
        }
    }

    public void executar() {
        //inserirPessoa();
        ///inserirEndereco();
        buscarTodasPessoas();
        //inserirPerfil();
    }


    public void buscarTodasPessoas() {
        pessoaService.getList().forEach(x -> System.out.println(x));

        perfilService.getList().forEach(x -> System.out.println(x));
    }


    public void inserirPerfil() {
        Pessoa pessoa = pessoaService.getList().stream().findFirst().get();

        Perfil perfil = new Perfil();

        perfil.setNomePerfil("Cliente");
        perfil.setDescricaoPerfil("Compra as parada");
        perfil.setDataHoraAlteracao(LocalTime.now());
        perfil.setDataHoraInclusao(LocalTime.now());

        perfilService.salvar(perfil);
    }

    public void inserirPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail("Phael@gmail.com");
        pessoa.setDataNascimento(LocalDate.of(1997, 8, 23));
        pessoa.setNome("Raphael");
        pessoa.setSituacao(Boolean.TRUE);

        pessoaService.salvar(pessoa);
    }

    public void inserirEndereco() {
        Pessoa pessoa = pessoaService.getList().stream().findFirst().get();

        Endereco endereco = new Endereco();
        endereco.setPessoa(pessoa);
        endereco.setBairro("Jd Maria Inês");
        endereco.setCep("74214000");
        endereco.setCidade("Ap. Goiânia");
        endereco.setComplemento("Num tem");
        endereco.setLogradouro("Condomínio Maria Ines IV");

        enderecoService.salvar(endereco);
    }

    public Pessoa getPessoaId(Long id) {
        return pessoaService.encontrar(id);
    }

}
