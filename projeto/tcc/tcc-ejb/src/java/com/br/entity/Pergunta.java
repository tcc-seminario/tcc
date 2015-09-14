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
@Table(name = "pergunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pergunta.findAll", query = "SELECT p FROM Pergunta p"),
    @NamedQuery(name = "Pergunta.findByIdPergunta", query = "SELECT p FROM Pergunta p WHERE p.idPergunta = :idPergunta"),
    @NamedQuery(name = "Pergunta.findByEnunciado", query = "SELECT p FROM Pergunta p WHERE p.enunciado = :enunciado")})
public class Pergunta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pergunta")
    private Integer idPergunta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "enunciado")
    private String enunciado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pergunta")
    private Collection<PerguntaResposta> perguntaRespostaCollection;
    @JoinColumn(name = "cursos_id_curso", referencedColumnName = "id_curso")
    @ManyToOne(optional = false)
    private Cursos cursosIdCurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pergunta")
    private Collection<QuestionarioPergunta> questionarioPerguntaCollection;

    public Pergunta() {
    }

    public Pergunta(Integer idPergunta) {
        this.idPergunta = idPergunta;
    }

    public Pergunta(Integer idPergunta, String enunciado) {
        this.idPergunta = idPergunta;
        this.enunciado = enunciado;
    }

    public Integer getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(Integer idPergunta) {
        this.idPergunta = idPergunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    @XmlTransient
    public Collection<PerguntaResposta> getPerguntaRespostaCollection() {
        return perguntaRespostaCollection;
    }

    public void setPerguntaRespostaCollection(Collection<PerguntaResposta> perguntaRespostaCollection) {
        this.perguntaRespostaCollection = perguntaRespostaCollection;
    }

    public Cursos getCursosIdCurso() {
        return cursosIdCurso;
    }

    public void setCursosIdCurso(Cursos cursosIdCurso) {
        this.cursosIdCurso = cursosIdCurso;
    }

    @XmlTransient
    public Collection<QuestionarioPergunta> getQuestionarioPerguntaCollection() {
        return questionarioPerguntaCollection;
    }

    public void setQuestionarioPerguntaCollection(Collection<QuestionarioPergunta> questionarioPerguntaCollection) {
        this.questionarioPerguntaCollection = questionarioPerguntaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPergunta != null ? idPergunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pergunta)) {
            return false;
        }
        Pergunta other = (Pergunta) object;
        if ((this.idPergunta == null && other.idPergunta != null) || (this.idPergunta != null && !this.idPergunta.equals(other.idPergunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.Pergunta[ idPergunta=" + idPergunta + " ]";
    }
    
}
