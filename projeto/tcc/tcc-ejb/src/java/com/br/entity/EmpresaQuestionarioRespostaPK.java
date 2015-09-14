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
public class EmpresaQuestionarioRespostaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empresa_questionario_id")
    private int empresaQuestionarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empresa_questionario_empresa_id_empresa")
    private int empresaQuestionarioEmpresaIdEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empresa_questionario_questionario_id_questionario")
    private int empresaQuestionarioQuestionarioIdQuestionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resposta_id_resposta")
    private int respostaIdResposta;

    public EmpresaQuestionarioRespostaPK() {
    }

    public EmpresaQuestionarioRespostaPK(int id, int empresaQuestionarioId, int empresaQuestionarioEmpresaIdEmpresa, int empresaQuestionarioQuestionarioIdQuestionario, int respostaIdResposta) {
        this.id = id;
        this.empresaQuestionarioId = empresaQuestionarioId;
        this.empresaQuestionarioEmpresaIdEmpresa = empresaQuestionarioEmpresaIdEmpresa;
        this.empresaQuestionarioQuestionarioIdQuestionario = empresaQuestionarioQuestionarioIdQuestionario;
        this.respostaIdResposta = respostaIdResposta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpresaQuestionarioId() {
        return empresaQuestionarioId;
    }

    public void setEmpresaQuestionarioId(int empresaQuestionarioId) {
        this.empresaQuestionarioId = empresaQuestionarioId;
    }

    public int getEmpresaQuestionarioEmpresaIdEmpresa() {
        return empresaQuestionarioEmpresaIdEmpresa;
    }

    public void setEmpresaQuestionarioEmpresaIdEmpresa(int empresaQuestionarioEmpresaIdEmpresa) {
        this.empresaQuestionarioEmpresaIdEmpresa = empresaQuestionarioEmpresaIdEmpresa;
    }

    public int getEmpresaQuestionarioQuestionarioIdQuestionario() {
        return empresaQuestionarioQuestionarioIdQuestionario;
    }

    public void setEmpresaQuestionarioQuestionarioIdQuestionario(int empresaQuestionarioQuestionarioIdQuestionario) {
        this.empresaQuestionarioQuestionarioIdQuestionario = empresaQuestionarioQuestionarioIdQuestionario;
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
        hash += (int) id;
        hash += (int) empresaQuestionarioId;
        hash += (int) empresaQuestionarioEmpresaIdEmpresa;
        hash += (int) empresaQuestionarioQuestionarioIdQuestionario;
        hash += (int) respostaIdResposta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaQuestionarioRespostaPK)) {
            return false;
        }
        EmpresaQuestionarioRespostaPK other = (EmpresaQuestionarioRespostaPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.empresaQuestionarioId != other.empresaQuestionarioId) {
            return false;
        }
        if (this.empresaQuestionarioEmpresaIdEmpresa != other.empresaQuestionarioEmpresaIdEmpresa) {
            return false;
        }
        if (this.empresaQuestionarioQuestionarioIdQuestionario != other.empresaQuestionarioQuestionarioIdQuestionario) {
            return false;
        }
        if (this.respostaIdResposta != other.respostaIdResposta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.EmpresaQuestionarioRespostaPK[ id=" + id + ", empresaQuestionarioId=" + empresaQuestionarioId + ", empresaQuestionarioEmpresaIdEmpresa=" + empresaQuestionarioEmpresaIdEmpresa + ", empresaQuestionarioQuestionarioIdQuestionario=" + empresaQuestionarioQuestionarioIdQuestionario + ", respostaIdResposta=" + respostaIdResposta + " ]";
    }
    
}
