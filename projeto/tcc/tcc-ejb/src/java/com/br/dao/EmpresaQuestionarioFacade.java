/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.dao;

import com.br.entity.EmpresaQuestionario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author neill
 */
@Stateless
public class EmpresaQuestionarioFacade extends AbstractFacade<EmpresaQuestionario> {
    @PersistenceContext(unitName = "tcc-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpresaQuestionarioFacade() {
        super(EmpresaQuestionario.class);
    }
    
}
