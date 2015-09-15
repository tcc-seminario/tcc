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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "questionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questionario.findAll", query = "SELECT q FROM Questionario q"),
    @NamedQuery(name = "Questionario.findByIdQuestionario", query = "SELECT q FROM Questionario q WHERE q.idQuestionario = :idQuestionario"),
    @NamedQuery(name = "Questionario.findByNomeQuestionario", query = "SELECT q FROM Questionario q WHERE q.nomeQuestionario = :nomeQuestionario"),
    @NamedQuery(name = "Questionario.findByTipoQuestionario", query = "SELECT q FROM Questionario q WHERE q.tipoQuestionario = :tipoQuestionario")})
public class Questionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_questionario")
    private Integer idQuestionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome_questionario")
    private String nomeQuestionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo_questionario")
    private String tipoQuestionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionario")
    private Collection<EmpresaQuestionario> empresaQuestionarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionario")
    private Collection<QuestionarioPergunta> questionarioPerguntaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionario")
    private Collection<AlunoQuestionario> alunoQuestionarioCollection;
    @JoinColumn(name = "cursos_id_curso", referencedColumnName = "id_curso")
    @ManyToOne(optional = false)
    private Cursos cursosIdCurso;

    public Questionario() {
    }

    public Questionario(Integer idQuestionario) {
        this.idQuestionario = idQuestionario;
    }

    public Questionario(Integer idQuestionario, String nomeQuestionario, String tipoQuestionario) {
        this.idQuestionario = idQuestionario;
        this.nomeQuestionario = nomeQuestionario;
        this.tipoQuestionario = tipoQuestionario;
    }

    public Integer getIdQuestionario() {
        return idQuestionario;
    }

    public void setIdQuestionario(Integer idQuestionario) {
        this.idQuestionario = idQuestionario;
    }

    public String getNomeQuestionario() {
        return nomeQuestionario;
    }

    public void setNomeQuestionario(String nomeQuestionario) {
        this.nomeQuestionario = nomeQuestionario;
    }

    public String getTipoQuestionario() {
        return tipoQuestionario;
    }

    public void setTipoQuestionario(String tipoQuestionario) {
        this.tipoQuestionario = tipoQuestionario;
    }

    @XmlTransient
    public Collection<EmpresaQuestionario> getEmpresaQuestionarioCollection() {
        return empresaQuestionarioCollection;
    }

    public void setEmpresaQuestionarioCollection(Collection<EmpresaQuestionario> empresaQuestionarioCollection) {
        this.empresaQuestionarioCollection = empresaQuestionarioCollection;
    }

    @XmlTransient
    public Collection<QuestionarioPergunta> getQuestionarioPerguntaCollection() {
        return questionarioPerguntaCollection;
    }

    public void setQuestionarioPerguntaCollection(Collection<QuestionarioPergunta> questionarioPerguntaCollection) {
        this.questionarioPerguntaCollection = questionarioPerguntaCollection;
    }

    @XmlTransient
    public Collection<AlunoQuestionario> getAlunoQuestionarioCollection() {
        return alunoQuestionarioCollection;
    }

    public void setAlunoQuestionarioCollection(Collection<AlunoQuestionario> alunoQuestionarioCollection) {
        this.alunoQuestionarioCollection = alunoQuestionarioCollection;
    }

    public Cursos getCursosIdCurso() {
        return cursosIdCurso;
    }

    public void setCursosIdCurso(Cursos cursosIdCurso) {
        this.cursosIdCurso = cursosIdCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestionario != null ? idQuestionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questionario)) {
            return false;
        }
        Questionario other = (Questionario) object;
        if ((this.idQuestionario == null && other.idQuestionario != null) || (this.idQuestionario != null && !this.idQuestionario.equals(other.idQuestionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.Questionario[ idQuestionario=" + idQuestionario + " ]";
    }
    
}
