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
import javax.validation.constraints.Size;

/**
 *
 * @author neill
 */
@Embeddable
public class AlunoQuestionarioRespostaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aluno_questionario_id")
    private int alunoQuestionarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aluno_questionario_aluno_id_aluno")
    private int alunoQuestionarioAlunoIdAluno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aluno_questionario_questionario_id_questionario")
    private int alunoQuestionarioQuestionarioIdQuestionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resposta_id_resposta")
    private int respostaIdResposta;

    public AlunoQuestionarioRespostaPK() {
    }

    public AlunoQuestionarioRespostaPK(String id, int alunoQuestionarioId, int alunoQuestionarioAlunoIdAluno, int alunoQuestionarioQuestionarioIdQuestionario, int respostaIdResposta) {
        this.id = id;
        this.alunoQuestionarioId = alunoQuestionarioId;
        this.alunoQuestionarioAlunoIdAluno = alunoQuestionarioAlunoIdAluno;
        this.alunoQuestionarioQuestionarioIdQuestionario = alunoQuestionarioQuestionarioIdQuestionario;
        this.respostaIdResposta = respostaIdResposta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAlunoQuestionarioId() {
        return alunoQuestionarioId;
    }

    public void setAlunoQuestionarioId(int alunoQuestionarioId) {
        this.alunoQuestionarioId = alunoQuestionarioId;
    }

    public int getAlunoQuestionarioAlunoIdAluno() {
        return alunoQuestionarioAlunoIdAluno;
    }

    public void setAlunoQuestionarioAlunoIdAluno(int alunoQuestionarioAlunoIdAluno) {
        this.alunoQuestionarioAlunoIdAluno = alunoQuestionarioAlunoIdAluno;
    }

    public int getAlunoQuestionarioQuestionarioIdQuestionario() {
        return alunoQuestionarioQuestionarioIdQuestionario;
    }

    public void setAlunoQuestionarioQuestionarioIdQuestionario(int alunoQuestionarioQuestionarioIdQuestionario) {
        this.alunoQuestionarioQuestionarioIdQuestionario = alunoQuestionarioQuestionarioIdQuestionario;
    }

    public int getRespostaIdResposta() {
        return respostaIdResposta;
    }

    public void setRespostaIdResposta(int respostaIdResposta) {
        this.respostaIdResposta = respostaIdResposta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        hash += (int) alunoQuestionarioId;
        hash += (int) alunoQuestionarioAlunoIdAluno;
        hash += (int) alunoQuestionarioQuestionarioIdQuestionario;
        hash += (int) respostaIdResposta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoQuestionarioRespostaPK)) {
            return false;
        }
        AlunoQuestionarioRespostaPK other = (AlunoQuestionarioRespostaPK) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        if (this.alunoQuestionarioId != other.alunoQuestionarioId) {
            return false;
        }
        if (this.alunoQuestionarioAlunoIdAluno != other.alunoQuestionarioAlunoIdAluno) {
            return false;
        }
        if (this.alunoQuestionarioQuestionarioIdQuestionario != other.alunoQuestionarioQuestionarioIdQuestionario) {
            return false;
        }
        if (this.respostaIdResposta != other.respostaIdResposta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.AlunoQuestionarioRespostaPK[ id=" + id + ", alunoQuestionarioId=" + alunoQuestionarioId + ", alunoQuestionarioAlunoIdAluno=" + alunoQuestionarioAlunoIdAluno + ", alunoQuestionarioQuestionarioIdQuestionario=" + alunoQuestionarioQuestionarioIdQuestionario + ", respostaIdResposta=" + respostaIdResposta + " ]";
    }
    
}
