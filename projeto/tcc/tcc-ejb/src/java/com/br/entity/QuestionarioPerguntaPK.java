/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author neill
 */
@Embeddable
public class QuestionarioPerguntaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "questionario_id_questionario")
    private int questionarioIdQuestionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pergunta_id_pergunta")
    private int perguntaIdPergunta;

    public QuestionarioPerguntaPK() {
    }

    public QuestionarioPerguntaPK(int id, int questionarioIdQuestionario, int perguntaIdPergunta) {
        this.id = id;
        this.questionarioIdQuestionario = questionarioIdQuestionario;
        this.perguntaIdPergunta = perguntaIdPergunta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionarioIdQuestionario() {
        return questionarioIdQuestionario;
    }

    public void setQuestionarioIdQuestionario(int questionarioIdQuestionario) {
        this.questionarioIdQuestionario = questionarioIdQuestionario;
    }

    public int getPerguntaIdPergunta() {
        return perguntaIdPergunta;
    }

    public void setPerguntaIdPergunta(int perguntaIdPergunta) {
        this.perguntaIdPergunta = perguntaIdPergunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) questionarioIdQuestionario;
        hash += (int) perguntaIdPergunta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionarioPerguntaPK)) {
            return false;
        }
        QuestionarioPerguntaPK other = (QuestionarioPerguntaPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.questionarioIdQuestionario != other.questionarioIdQuestionario) {
            return false;
        }
        if (this.perguntaIdPergunta != other.perguntaIdPergunta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.QuestionarioPerguntaPK[ id=" + id + ", questionarioIdQuestionario=" + questionarioIdQuestionario + ", perguntaIdPergunta=" + perguntaIdPergunta + " ]";
    }
    
}
