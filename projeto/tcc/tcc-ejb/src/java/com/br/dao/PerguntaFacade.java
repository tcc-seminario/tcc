/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.dao;

import com.br.entity.Pergunta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author neill
 */
@Stateless
public class PerguntaFacade extends AbstractFacade<Pergunta> {
    @PersistenceContext(unitName = "tcc-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerguntaFacade() {
        super(Pergunta.class);
    }
    
}
