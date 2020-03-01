package com.stefanini.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_PESSOA")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "co_seq_pessoa")
    private Long id;

//    @ManyToMany(mappedBy = "pessoa",  fetch = FetchType.EAGER)
//    private Set<Perfil> perfil;

    @Column(name = "no_nome")
    private  String nome;

    @Column(name = "ds_email")
    private  String email;

    @Column(name = "dt_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "st_pessoa")
    private boolean situacao;
}
