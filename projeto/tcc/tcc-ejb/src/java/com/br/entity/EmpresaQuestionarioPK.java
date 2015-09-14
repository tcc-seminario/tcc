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
public class EmpresaQuestionarioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empresa_id_empresa")
    private int empresaIdEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "questionario_id_questionario")
    private int questionarioIdQuestionario;

    public EmpresaQuestionarioPK() {
    }

    public EmpresaQuestionarioPK(int id, int empresaIdEmpresa, int questionarioIdQuestionario) {
        this.id = id;
        this.empresaIdEmpresa = empresaIdEmpresa;
        this.questionarioIdQuestionario = questionarioIdQuestionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpresaIdEmpresa() {
        return empresaIdEmpresa;
    }

    public void setEmpresaIdEmpresa(int empresaIdEmpresa) {
        this.empresaIdEmpresa = empresaIdEmpresa;
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
        hash += (int) empresaIdEmpresa;
        hash += (int) questionarioIdQuestionario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaQuestionarioPK)) {
            return false;
        }
        EmpresaQuestionarioPK other = (EmpresaQuestionarioPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.empresaIdEmpresa != other.empresaIdEmpresa) {
            return false;
        }
        if (this.questionarioIdQuestionario != other.questionarioIdQuestionario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.EmpresaQuestionarioPK[ id=" + id + ", empresaIdEmpresa=" + empresaIdEmpresa + ", questionarioIdQuestionario=" + questionarioIdQuestionario + " ]";
    }
    
}
