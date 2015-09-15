/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author neill
 */
@Entity
@Table(name = "aluno_questionario_resposta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlunoQuestionarioResposta.findAll", query = "SELECT a FROM AlunoQuestionarioResposta a"),
    @NamedQuery(name = "AlunoQuestionarioResposta.findById", query = "SELECT a FROM AlunoQuestionarioResposta a WHERE a.alunoQuestionarioRespostaPK.id = :id"),
    @NamedQuery(name = "AlunoQuestionarioResposta.findByAlunoQuestionarioId", query = "SELECT a FROM AlunoQuestionarioResposta a WHERE a.alunoQuestionarioRespostaPK.alunoQuestionarioId = :alunoQuestionarioId"),
    @NamedQuery(name = "AlunoQuestionarioResposta.findByAlunoQuestionarioAlunoIdAluno", query = "SELECT a FROM AlunoQuestionarioResposta a WHERE a.alunoQuestionarioRespostaPK.alunoQuestionarioAlunoIdAluno = :alunoQuestionarioAlunoIdAluno"),
    @NamedQuery(name = "AlunoQuestionarioResposta.findByAlunoQuestionarioQuestionarioIdQuestionario", query = "SELECT a FROM AlunoQuestionarioResposta a WHERE a.alunoQuestionarioRespostaPK.alunoQuestionarioQuestionarioIdQuestionario = :alunoQuestionarioQuestionarioIdQuestionario"),
    @NamedQuery(name = "AlunoQuestionarioResposta.findByRespostaIdResposta", query = "SELECT a FROM AlunoQuestionarioResposta a WHERE a.alunoQuestionarioRespostaPK.respostaIdResposta = :respostaIdResposta"),
    @NamedQuery(name = "AlunoQuestionarioResposta.findByRespostaAberta", query = "SELECT a FROM AlunoQuestionarioResposta a WHERE a.respostaAberta = :respostaAberta")})
public class AlunoQuestionarioResposta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlunoQuestionarioRespostaPK alunoQuestionarioRespostaPK;
    @Size(max = 45)
    @Column(name = "resposta_aberta")
    private String respostaAberta;
    @JoinColumns({
        @JoinColumn(name = "aluno_questionario_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "aluno_questionario_aluno_id_aluno", referencedColumnName = "aluno_id_aluno", insertable = false, updatable = false),
        @JoinColumn(name = "aluno_questionario_questionario_id_questionario", referencedColumnName = "questionario_id_questionario", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private AlunoQuestionario alunoQuestionario;
    @JoinColumn(name = "resposta_id_resposta", referencedColumnName = "id_resposta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Resposta resposta;

    public AlunoQuestionarioResposta() {
    }

    public AlunoQuestionarioResposta(AlunoQuestionarioRespostaPK alunoQuestionarioRespostaPK) {
        this.alunoQuestionarioRespostaPK = alunoQuestionarioRespostaPK;
    }

    public AlunoQuestionarioResposta(String id, int alunoQuestionarioId, int alunoQuestionarioAlunoIdAluno, int alunoQuestionarioQuestionarioIdQuestionario, int respostaIdResposta) {
        this.alunoQuestionarioRespostaPK = new AlunoQuestionarioRespostaPK(id, alunoQuestionarioId, alunoQuestionarioAlunoIdAluno, alunoQuestionarioQuestionarioIdQuestionario, respostaIdResposta);
    }

    public AlunoQuestionarioRespostaPK getAlunoQuestionarioRespostaPK() {
        return alunoQuestionarioRespostaPK;
    }

    public void setAlunoQuestionarioRespostaPK(AlunoQuestionarioRespostaPK alunoQuestionarioRespostaPK) {
        this.alunoQuestionarioRespostaPK = alunoQuestionarioRespostaPK;
    }

    public String getRespostaAberta() {
        return respostaAberta;
    }

    public void setRespostaAberta(String respostaAberta) {
        this.respostaAberta = respostaAberta;
    }

    public AlunoQuestionario getAlunoQuestionario() {
        return alunoQuestionario;
    }

    public void setAlunoQuestionario(AlunoQuestionario alunoQuestionario) {
        this.alunoQuestionario = alunoQuestionario;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alunoQuestionarioRespostaPK != null ? alunoQuestionarioRespostaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoQuestionarioResposta)) {
            return false;
        }
        AlunoQuestionarioResposta other = (AlunoQuestionarioResposta) object;
        if ((this.alunoQuestionarioRespostaPK == null && other.alunoQuestionarioRespostaPK != null) || (this.alunoQuestionarioRespostaPK != null && !this.alunoQuestionarioRespostaPK.equals(other.alunoQuestionarioRespostaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.AlunoQuestionarioResposta[ alunoQuestionarioRespostaPK=" + alunoQuestionarioRespostaPK + " ]";
    }
    
}
