package com.stefanini.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_ENDERECO")
public class Endereco {
    @Id
    @Column(name = "co_seq_endereco")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @NotNull
    private Pessoa pessoa;

    @Column(name = "ds_logradouro", length = 150)
    private String logradouro;

    @Column(name = "ds_complemento", length = 150)
    private String complemento;

    @Column(name = "ds_bairro", length = 250)
    private String bairro;

    @Column(name = "ds_cidade")
    private String cidade;

    @Column(name = "ds_uf")
    private String uf;

    @Column(name = "ds_cep", length = 8)
    private String cep;




}
