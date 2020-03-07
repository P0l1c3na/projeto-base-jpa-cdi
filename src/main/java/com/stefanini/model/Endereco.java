package com.stefanini.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@ToString
@NoArgsConstructor @AllArgsConstructor
@Table(name = "TB_ENDERECO")
public class Endereco {
    @Id
    @Getter
    @Column(name = "CO_SEQ_ENDERECO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @NotNull
    @Getter @Setter
    private Pessoa pessoa;

    @Getter @Setter
    @Column(name = "DS_LOGRADOURO", length = 150)
    private String logradouro;

    @Getter @Setter
    @Column(name = "DS_COMPLEMENTO", length = 150)
    private String complemento;

    @Getter @Setter
    @Column(name = "DS_BAIRRO", length = 250)
    private String bairro;

    @Getter @Setter
    @Column(name = "DS_CIDADE")
    private String cidade;

    @Getter @Setter
    @Column(name = "DS_UF")
    private String uf;

    @Getter @Setter
    @Column(name = "DS_CEP", length = 8)
    private String cep;




}
