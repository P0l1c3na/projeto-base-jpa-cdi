package com.stefanini.dao.entidades;

import com.stefanini.dao.abstracao.GenericDao;
import com.stefanini.model.Perfil;

public class PerfilDao extends GenericDao<Perfil, Integer> {

    public PerfilDao(){
        super(Perfil.class);
    }
}
