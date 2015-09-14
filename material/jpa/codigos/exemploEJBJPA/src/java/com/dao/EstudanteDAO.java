 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Estudante;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tiago
 */
@Stateless
public class EstudanteDAO implements EstudanteDAOLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addEstudante(Estudante estudante) {
        em.merge(estudante);
        em.flush();
    }

    @Override
    public void editEstudante(Estudante estudante) {
        em.merge(estudante);
        em.flush();
    }

    @Override
    public void deleteEstudante(Long studentId) {
        em.remove(getEstudante(studentId));
        em.flush();
    }

    @Override
    public Estudante getEstudante(Long studentId) {
        em.flush();
        return em.find(Estudante.class, studentId);
    }

    @Override
    public List<Estudante> getAllEstudantes() {
        em.flush();
        return em.createNamedQuery("Estudante.getAll").getResultList();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
