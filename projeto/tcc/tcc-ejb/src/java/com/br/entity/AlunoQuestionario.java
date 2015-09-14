/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author neill
 */
@Entity
@Table(name = "aluno_questionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlunoQuestionario.findAll", query = "SELECT a FROM AlunoQuestionario a"),
    @NamedQuery(name = "AlunoQuestionario.findById", query = "SELECT a FROM AlunoQuestionario a WHERE a.alunoQuestionarioPK.id = :id"),
    @NamedQuery(name = "AlunoQuestionario.findByAlunoIdAluno", query = "SELECT a FROM AlunoQuestionario a WHERE a.alunoQuestionarioPK.alunoIdAluno = :alunoIdAluno"),
    @NamedQuery(name = "AlunoQuestionario.findByQuestionarioIdQuestionario", query = "SELECT a FROM AlunoQuestionario a WHERE a.alunoQuestionarioPK.questionarioIdQuestionario = :questionarioIdQuestionario")})
public class AlunoQuestionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlunoQuestionarioPK alunoQuestionarioPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alunoQuestionario")
    private Collection<AlunoQuestionarioResposta> alunoQuestionarioRespostaCollection;
    @JoinColumn(name = "aluno_id_aluno", referencedColumnName = "id_aluno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aluno aluno;
    @JoinColumn(name = "questionario_id_questionario", referencedColumnName = "id_questionario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Questionario questionario;

    public AlunoQuestionario() {
    }

    public AlunoQuestionario(AlunoQuestionarioPK alunoQuestionarioPK) {
        this.alunoQuestionarioPK = alunoQuestionarioPK;
    }

    public AlunoQuestionario(int id, int alunoIdAluno, int questionarioIdQuestionario) {
        this.alunoQuestionarioPK = new AlunoQuestionarioPK(id, alunoIdAluno, questionarioIdQuestionario);
    }

    public AlunoQuestionarioPK getAlunoQuestionarioPK() {
        return alunoQuestionarioPK;
    }

    public void setAlunoQuestionarioPK(AlunoQuestionarioPK alunoQuestionarioPK) {
        this.alunoQuestionarioPK = alunoQuestionarioPK;
    }

    @XmlTransient
    public Collection<AlunoQuestionarioResposta> getAlunoQuestionarioRespostaCollection() {
        return alunoQuestionarioRespostaCollection;
    }

    public void setAlunoQuestionarioRespostaCollection(Collection<AlunoQuestionarioResposta> alunoQuestionarioRespostaCollection) {
        this.alunoQuestionarioRespostaCollection = alunoQuestionarioRespostaCollection;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alunoQuestionarioPK != null ? alunoQuestionarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoQuestionario)) {
            return false;
        }
        AlunoQuestionario other = (AlunoQuestionario) object;
        if ((this.alunoQuestionarioPK == null && other.alunoQuestionarioPK != null) || (this.alunoQuestionarioPK != null && !this.alunoQuestionarioPK.equals(other.alunoQuestionarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.AlunoQuestionario[ alunoQuestionarioPK=" + alunoQuestionarioPK + " ]";
    }
    
}
