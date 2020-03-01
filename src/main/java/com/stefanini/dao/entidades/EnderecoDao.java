package com.stefanini.dao.entidades;

import com.stefanini.dao.abstracao.GenericDao;
import com.stefanini.model.Endereco;

public class EnderecoDao extends GenericDao<Endereco, Long> {

    public EnderecoDao(){
        super(Endereco.class);
    }
}
