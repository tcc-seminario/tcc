/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Estudante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tiago
 */
@Local
public interface EstudanteDAOLocal {

    void addEstudante(Estudante estudante);

    void editEstudante(Estudante estudante);

    void deleteEstudante(Long studentId);

    Estudante getEstudante(Long studentId);

    List<Estudante> getAllEstudantes();
}
