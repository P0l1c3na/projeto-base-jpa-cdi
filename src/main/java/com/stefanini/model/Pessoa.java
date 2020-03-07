package com.stefanini.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Entity
@ToString
@NoArgsConstructor @AllArgsConstructor
@Table(name = "TB_PESSOA")
public class Pessoa {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CO_SEQ_PESSOA")
    private Long id;

    @Getter @Setter
    @Column(name = "NO_NOME")
    private  String nome;

    @Getter @Setter
    @Column(name = "DS_EMAIL")
    private  String email;

    @Getter @Setter
    @Column(name = "DT_NASCIMENTO")
    private LocalDate dataNascimento;

    @Getter @Setter
    @Column(name = "ST_PESSOA")
    private boolean situacao;
}
