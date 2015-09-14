/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author neill
 */
@Entity
@Table(name = "questionario_pergunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuestionarioPergunta.findAll", query = "SELECT q FROM QuestionarioPergunta q"),
    @NamedQuery(name = "QuestionarioPergunta.findById", query = "SELECT q FROM QuestionarioPergunta q WHERE q.questionarioPerguntaPK.id = :id"),
    @NamedQuery(name = "QuestionarioPergunta.findByQuestionarioIdQuestionario", query = "SELECT q FROM QuestionarioPergunta q WHERE q.questionarioPerguntaPK.questionarioIdQuestionario = :questionarioIdQuestionario"),
    @NamedQuery(name = "QuestionarioPergunta.findByPerguntaIdPergunta", query = "SELECT q FROM QuestionarioPergunta q WHERE q.questionarioPerguntaPK.perguntaIdPergunta = :perguntaIdPergunta")})
public class QuestionarioPergunta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuestionarioPerguntaPK questionarioPerguntaPK;
    @JoinColumn(name = "pergunta_id_pergunta", referencedColumnName = "id_pergunta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pergunta pergunta;
    @JoinColumn(name = "questionario_id_questionario", referencedColumnName = "id_questionario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Questionario questionario;

    public QuestionarioPergunta() {
    }

    public QuestionarioPergunta(QuestionarioPerguntaPK questionarioPerguntaPK) {
        this.questionarioPerguntaPK = questionarioPerguntaPK;
    }

    public QuestionarioPergunta(int id, int questionarioIdQuestionario, int perguntaIdPergunta) {
        this.questionarioPerguntaPK = new QuestionarioPerguntaPK(id, questionarioIdQuestionario, perguntaIdPergunta);
    }

    public QuestionarioPerguntaPK getQuestionarioPerguntaPK() {
        return questionarioPerguntaPK;
    }

    public void setQuestionarioPerguntaPK(QuestionarioPerguntaPK questionarioPerguntaPK) {
        this.questionarioPerguntaPK = questionarioPerguntaPK;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
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
        hash += (questionarioPerguntaPK != null ? questionarioPerguntaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionarioPergunta)) {
            return false;
        }
        QuestionarioPergunta other = (QuestionarioPergunta) object;
        if ((this.questionarioPerguntaPK == null && other.questionarioPerguntaPK != null) || (this.questionarioPerguntaPK != null && !this.questionarioPerguntaPK.equals(other.questionarioPerguntaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.QuestionarioPergunta[ questionarioPerguntaPK=" + questionarioPerguntaPK + " ]";
    }
    
}
