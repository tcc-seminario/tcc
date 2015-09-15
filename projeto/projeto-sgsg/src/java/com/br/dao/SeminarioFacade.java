/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.dao;

import com.br.entity.Seminario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author neill
 */
@Stateless
public class SeminarioFacade extends AbstractFacade<Seminario> {
    @PersistenceContext(unitName = "projeto-sgsgPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeminarioFacade() {
        super(Seminario.class);
    }
    
}
