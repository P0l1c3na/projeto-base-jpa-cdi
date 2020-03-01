package com.stefanini.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_PERFIL")
public class Perfil {
    @Id
    @Column(name = "co_seq_perfil")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_pessoa_perfil",
            joinColumns = {@JoinColumn(name = "co_seq_perfil")},
            inverseJoinColumns = {@JoinColumn(name = "co_seq_pessoa")}
    )
    private Set<Pessoa> pessoa;

    @NotNull
    @Column(name = "no_perfil")
    private String nomePerfil;

    @Column(name = "ds_perfil")
    private String descricaoPerfil;

    @Column(name = "dt_hora_inclusao")
    private LocalTime dataHoraInclusao;

    @Column(name = "dt_hora_alteracao")
    private LocalTime dataHoraAlteracao;
}
