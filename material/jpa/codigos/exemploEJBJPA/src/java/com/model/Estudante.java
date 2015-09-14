/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Tiago
 */
@Entity
@Table
@NamedQueries({@NamedQuery(name = "Estudante.getAll", query = "SELECT e FROM Estudante e order by e.idestudante")})
public class Estudante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idestudante;

    @Column
    private String nome;

    @Column
    private String sobrenome;

    public Estudante() {
    }

    public Estudante(Long idestudante, String nome, String sobrenome) {
        this.idestudante = idestudante;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Long getIdestudante() {
        return idestudante;
    }

    public void setIdestudante(Long idestudante) {
        this.idestudante = idestudante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

}
