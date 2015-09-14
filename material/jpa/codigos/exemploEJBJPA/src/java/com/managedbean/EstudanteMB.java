/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbean;

import com.dao.EstudanteDAOLocal;
import com.model.Estudante;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Tiago
 */
@ManagedBean
@SessionScoped
public class EstudanteMB {

    @EJB
    private EstudanteDAOLocal estudanteDao;

    private Estudante estudante = new Estudante();
    private List<Estudante> allEstudantes;

    public String crud(String acao) {
        Estudante e = new Estudante(estudante.getIdestudante(), estudante.getNome(), estudante.getSobrenome());
        switch (acao) {
            case "Add":
                estudanteDao.addEstudante(e);
                break;
            case "Edit":
                estudanteDao.editEstudante(e);
                break;
            case "Delete":
                estudanteDao.deleteEstudante(e.getIdestudante());
                break;
            case "Search":
                estudanteDao.getEstudante(e.getIdestudante());
                break;
        }
        estudante = new Estudante();
        allEstudantes = estudanteDao.getAllEstudantes();
        return "index";
    }

    /**
     * Creates a new instance of EstudanteMB
     */
    public EstudanteMB() {
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public List<Estudante> getAllEstudantes() {
        return allEstudantes;
    }

    public void setAllEstudantes(List<Estudante> allEstudantes) {
        this.allEstudantes = allEstudantes;
    }

}
