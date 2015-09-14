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
public class AlunoQuestionarioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aluno_id_aluno")
    private int alunoIdAluno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "questionario_id_questionario")
    private int questionarioIdQuestionario;

    public AlunoQuestionarioPK() {
    }

    public AlunoQuestionarioPK(int id, int alunoIdAluno, int questionarioIdQuestionario) {
        this.id = id;
        this.alunoIdAluno = alunoIdAluno;
        this.questionarioIdQuestionario = questionarioIdQuestionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlunoIdAluno() {
        return alunoIdAluno;
    }

    public void setAlunoIdAluno(int alunoIdAluno) {
        this.alunoIdAluno = alunoIdAluno;
    }

    public int getQuestionarioIdQuestionario() {
        return questionarioIdQuestionario;
    }

    public void setQuestionarioIdQuestionario(int questionarioIdQuestionario) {
        this.questionarioIdQuestionario = questionarioIdQuestionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) alunoIdAluno;
        hash += (int) questionarioIdQuestionario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoQuestionarioPK)) {
            return false;
        }
        AlunoQuestionarioPK other = (AlunoQuestionarioPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.alunoIdAluno != other.alunoIdAluno) {
            return false;
        }
        if (this.questionarioIdQuestionario != other.questionarioIdQuestionario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.AlunoQuestionarioPK[ id=" + id + ", alunoIdAluno=" + alunoIdAluno + ", questionarioIdQuestionario=" + questionarioIdQuestionario + " ]";
    }
    
}
