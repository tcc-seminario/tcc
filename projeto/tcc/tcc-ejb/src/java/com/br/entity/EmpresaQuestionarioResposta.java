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
@Table(name = "empresa_questionario_resposta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpresaQuestionarioResposta.findAll", query = "SELECT e FROM EmpresaQuestionarioResposta e"),
    @NamedQuery(name = "EmpresaQuestionarioResposta.findById", query = "SELECT e FROM EmpresaQuestionarioResposta e WHERE e.empresaQuestionarioRespostaPK.id = :id"),
    @NamedQuery(name = "EmpresaQuestionarioResposta.findByEmpresaQuestionarioId", query = "SELECT e FROM EmpresaQuestionarioResposta e WHERE e.empresaQuestionarioRespostaPK.empresaQuestionarioId = :empresaQuestionarioId"),
    @NamedQuery(name = "EmpresaQuestionarioResposta.findByEmpresaQuestionarioEmpresaIdEmpresa", query = "SELECT e FROM EmpresaQuestionarioResposta e WHERE e.empresaQuestionarioRespostaPK.empresaQuestionarioEmpresaIdEmpresa = :empresaQuestionarioEmpresaIdEmpresa"),
    @NamedQuery(name = "EmpresaQuestionarioResposta.findByEmpresaQuestionarioQuestionarioIdQuestionario", query = "SELECT e FROM EmpresaQuestionarioResposta e WHERE e.empresaQuestionarioRespostaPK.empresaQuestionarioQuestionarioIdQuestionario = :empresaQuestionarioQuestionarioIdQuestionario"),
    @NamedQuery(name = "EmpresaQuestionarioResposta.findByRespostaIdResposta", query = "SELECT e FROM EmpresaQuestionarioResposta e WHERE e.empresaQuestionarioRespostaPK.respostaIdResposta = :respostaIdResposta"),
    @NamedQuery(name = "EmpresaQuestionarioResposta.findByRespostaAberta", query = "SELECT e FROM EmpresaQuestionarioResposta e WHERE e.respostaAberta = :respostaAberta")})
public class EmpresaQuestionarioResposta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpresaQuestionarioRespostaPK empresaQuestionarioRespostaPK;
    @Size(max = 45)
    @Column(name = "resposta_aberta")
    private String respostaAberta;
    @JoinColumns({
        @JoinColumn(name = "empresa_questionario_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "empresa_questionario_empresa_id_empresa", referencedColumnName = "empresa_id_empresa", insertable = false, updatable = false),
        @JoinColumn(name = "empresa_questionario_questionario_id_questionario", referencedColumnName = "questionario_id_questionario", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private EmpresaQuestionario empresaQuestionario;
    @JoinColumn(name = "resposta_id_resposta", referencedColumnName = "id_resposta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Resposta resposta;

    public EmpresaQuestionarioResposta() {
    }

    public EmpresaQuestionarioResposta(EmpresaQuestionarioRespostaPK empresaQuestionarioRespostaPK) {
        this.empresaQuestionarioRespostaPK = empresaQuestionarioRespostaPK;
    }

    public EmpresaQuestionarioResposta(int id, int empresaQuestionarioId, int empresaQuestionarioEmpresaIdEmpresa, int empresaQuestionarioQuestionarioIdQuestionario, int respostaIdResposta) {
        this.empresaQuestionarioRespostaPK = new EmpresaQuestionarioRespostaPK(id, empresaQuestionarioId, empresaQuestionarioEmpresaIdEmpresa, empresaQuestionarioQuestionarioIdQuestionario, respostaIdResposta);
    }

    public EmpresaQuestionarioRespostaPK getEmpresaQuestionarioRespostaPK() {
        return empresaQuestionarioRespostaPK;
    }

    public void setEmpresaQuestionarioRespostaPK(EmpresaQuestionarioRespostaPK empresaQuestionarioRespostaPK) {
        this.empresaQuestionarioRespostaPK = empresaQuestionarioRespostaPK;
    }

    public String getRespostaAberta() {
        return respostaAberta;
    }

    public void setRespostaAberta(String respostaAberta) {
        this.respostaAberta = respostaAberta;
    }

    public EmpresaQuestionario getEmpresaQuestionario() {
        return empresaQuestionario;
    }

    public void setEmpresaQuestionario(EmpresaQuestionario empresaQuestionario) {
        this.empresaQuestionario = empresaQuestionario;
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
        hash += (empresaQuestionarioRespostaPK != null ? empresaQuestionarioRespostaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaQuestionarioResposta)) {
            return false;
        }
        EmpresaQuestionarioResposta other = (EmpresaQuestionarioResposta) object;
        if ((this.empresaQuestionarioRespostaPK == null && other.empresaQuestionarioRespostaPK != null) || (this.empresaQuestionarioRespostaPK != null && !this.empresaQuestionarioRespostaPK.equals(other.empresaQuestionarioRespostaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.EmpresaQuestionarioResposta[ empresaQuestionarioRespostaPK=" + empresaQuestionarioRespostaPK + " ]";
    }
    
}
