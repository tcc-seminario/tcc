/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author neill
 */
@Entity
@Table(name = "cursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c"),
    @NamedQuery(name = "Cursos.findByIdCurso", query = "SELECT c FROM Cursos c WHERE c.idCurso = :idCurso"),
    @NamedQuery(name = "Cursos.findByNomeCurso", query = "SELECT c FROM Cursos c WHERE c.nomeCurso = :nomeCurso")})
public class Cursos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_curso")
    private Integer idCurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome_curso")
    private String nomeCurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursosIdCurso")
    private Collection<Aluno> alunoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursosIdCurso")
    private Collection<Orientador> orientadorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursosIdCurso")
    private Collection<Estagio> estagioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursosIdCurso")
    private Collection<Pergunta> perguntaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursosIdCurso")
    private Collection<Questionario> questionarioCollection;

    public Cursos() {
    }

    public Cursos(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Cursos(Integer idCurso, String nomeCurso) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    @XmlTransient
    public Collection<Aluno> getAlunoCollection() {
        return alunoCollection;
    }

    public void setAlunoCollection(Collection<Aluno> alunoCollection) {
        this.alunoCollection = alunoCollection;
    }

    @XmlTransient
    public Collection<Orientador> getOrientadorCollection() {
        return orientadorCollection;
    }

    public void setOrientadorCollection(Collection<Orientador> orientadorCollection) {
        this.orientadorCollection = orientadorCollection;
    }

    @XmlTransient
    public Collection<Estagio> getEstagioCollection() {
        return estagioCollection;
    }

    public void setEstagioCollection(Collection<Estagio> estagioCollection) {
        this.estagioCollection = estagioCollection;
    }

    @XmlTransient
    public Collection<Pergunta> getPerguntaCollection() {
        return perguntaCollection;
    }

    public void setPerguntaCollection(Collection<Pergunta> perguntaCollection) {
        this.perguntaCollection = perguntaCollection;
    }

    @XmlTransient
    public Collection<Questionario> getQuestionarioCollection() {
        return questionarioCollection;
    }

    public void setQuestionarioCollection(Collection<Questionario> questionarioCollection) {
        this.questionarioCollection = questionarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.Cursos[ idCurso=" + idCurso + " ]";
    }
    
}
