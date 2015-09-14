/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author neill
 */
@Entity
@Table(name = "resposta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resposta.findAll", query = "SELECT r FROM Resposta r"),
    @NamedQuery(name = "Resposta.findByIdResposta", query = "SELECT r FROM Resposta r WHERE r.idResposta = :idResposta"),
    @NamedQuery(name = "Resposta.findByResposta", query = "SELECT r FROM Resposta r WHERE r.resposta = :resposta")})
public class Resposta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_resposta")
    private Integer idResposta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "resposta")
    private String resposta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resposta")
    private Collection<EmpresaQuestionarioResposta> empresaQuestionarioRespostaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resposta")
    private Collection<PerguntaResposta> perguntaRespostaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resposta")
    private Collection<AlunoQuestionarioResposta> alunoQuestionarioRespostaCollection;

    public Resposta() {
    }

    public Resposta(Integer idResposta) {
        this.idResposta = idResposta;
    }

    public Resposta(Integer idResposta, String resposta) {
        this.idResposta = idResposta;
        this.resposta = resposta;
    }

    public Integer getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Integer idResposta) {
        this.idResposta = idResposta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    @XmlTransient
    public Collection<EmpresaQuestionarioResposta> getEmpresaQuestionarioRespostaCollection() {
        return empresaQuestionarioRespostaCollection;
    }

    public void setEmpresaQuestionarioRespostaCollection(Collection<EmpresaQuestionarioResposta> empresaQuestionarioRespostaCollection) {
        this.empresaQuestionarioRespostaCollection = empresaQuestionarioRespostaCollection;
    }

    @XmlTransient
    public Collection<PerguntaResposta> getPerguntaRespostaCollection() {
        return perguntaRespostaCollection;
    }

    public void setPerguntaRespostaCollection(Collection<PerguntaResposta> perguntaRespostaCollection) {
        this.perguntaRespostaCollection = perguntaRespostaCollection;
    }

    @XmlTransient
    public Collection<AlunoQuestionarioResposta> getAlunoQuestionarioRespostaCollection() {
        return alunoQuestionarioRespostaCollection;
    }

    public void setAlunoQuestionarioRespostaCollection(Collection<AlunoQuestionarioResposta> alunoQuestionarioRespostaCollection) {
        this.alunoQuestionarioRespostaCollection = alunoQuestionarioRespostaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResposta != null ? idResposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resposta)) {
            return false;
        }
        Resposta other = (Resposta) object;
        if ((this.idResposta == null && other.idResposta != null) || (this.idResposta != null && !this.idResposta.equals(other.idResposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.Resposta[ idResposta=" + idResposta + " ]";
    }
    
}
