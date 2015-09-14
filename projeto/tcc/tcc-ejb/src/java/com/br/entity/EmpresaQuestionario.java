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
@Table(name = "empresa_questionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpresaQuestionario.findAll", query = "SELECT e FROM EmpresaQuestionario e"),
    @NamedQuery(name = "EmpresaQuestionario.findById", query = "SELECT e FROM EmpresaQuestionario e WHERE e.empresaQuestionarioPK.id = :id"),
    @NamedQuery(name = "EmpresaQuestionario.findByEmpresaIdEmpresa", query = "SELECT e FROM EmpresaQuestionario e WHERE e.empresaQuestionarioPK.empresaIdEmpresa = :empresaIdEmpresa"),
    @NamedQuery(name = "EmpresaQuestionario.findByQuestionarioIdQuestionario", query = "SELECT e FROM EmpresaQuestionario e WHERE e.empresaQuestionarioPK.questionarioIdQuestionario = :questionarioIdQuestionario")})
public class EmpresaQuestionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpresaQuestionarioPK empresaQuestionarioPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaQuestionario")
    private Collection<EmpresaQuestionarioResposta> empresaQuestionarioRespostaCollection;
    @JoinColumn(name = "empresa_id_empresa", referencedColumnName = "id_empresa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empresa empresa;
    @JoinColumn(name = "questionario_id_questionario", referencedColumnName = "id_questionario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Questionario questionario;

    public EmpresaQuestionario() {
    }

    public EmpresaQuestionario(EmpresaQuestionarioPK empresaQuestionarioPK) {
        this.empresaQuestionarioPK = empresaQuestionarioPK;
    }

    public EmpresaQuestionario(int id, int empresaIdEmpresa, int questionarioIdQuestionario) {
        this.empresaQuestionarioPK = new EmpresaQuestionarioPK(id, empresaIdEmpresa, questionarioIdQuestionario);
    }

    public EmpresaQuestionarioPK getEmpresaQuestionarioPK() {
        return empresaQuestionarioPK;
    }

    public void setEmpresaQuestionarioPK(EmpresaQuestionarioPK empresaQuestionarioPK) {
        this.empresaQuestionarioPK = empresaQuestionarioPK;
    }

    @XmlTransient
    public Collection<EmpresaQuestionarioResposta> getEmpresaQuestionarioRespostaCollection() {
        return empresaQuestionarioRespostaCollection;
    }

    public void setEmpresaQuestionarioRespostaCollection(Collection<EmpresaQuestionarioResposta> empresaQuestionarioRespostaCollection) {
        this.empresaQuestionarioRespostaCollection = empresaQuestionarioRespostaCollection;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
        hash += (empresaQuestionarioPK != null ? empresaQuestionarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaQuestionario)) {
            return false;
        }
        EmpresaQuestionario other = (EmpresaQuestionario) object;
        if ((this.empresaQuestionarioPK == null && other.empresaQuestionarioPK != null) || (this.empresaQuestionarioPK != null && !this.empresaQuestionarioPK.equals(other.empresaQuestionarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.EmpresaQuestionario[ empresaQuestionarioPK=" + empresaQuestionarioPK + " ]";
    }
    
}
