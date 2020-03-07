package com.stefanini.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.Set;

@Entity
@ToString
@NoArgsConstructor @AllArgsConstructor
@Table(name = "TB_PERFIL")
public class Perfil {
    @Id
    @Getter
    @Column(name = "CO_SEQ_PERFIL")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Getter @Setter
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "TB_PESSOA_PERFIL",
            joinColumns = {@JoinColumn(name = "CO_SEQ_PERFIL")},
            inverseJoinColumns = {@JoinColumn(name = "CO_SEQ_PESSOA")}
    )
    private Set<Pessoa> pessoa;


    @NotNull
    @Getter @Setter
    @Column(name = "NO_PERFIL")
    private String nomePerfil;

    @Getter @Setter
    @Column(name = "DS_PERFIL")
    private String descricaoPerfil;

    @Getter @Setter
    @Column(name = "DT_HORA_INCLUSAO")
    private LocalTime dataHoraInclusao;

    @Getter @Setter
    @Column(name = "DT_HORA_ALTERACAO")
    private LocalTime dataHoraAlteracao;
}
