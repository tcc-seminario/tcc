/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "modalidade_estagios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModalidadeEstagios.findAll", query = "SELECT m FROM ModalidadeEstagios m"),
    @NamedQuery(name = "ModalidadeEstagios.findByIdModalidade", query = "SELECT m FROM ModalidadeEstagios m WHERE m.idModalidade = :idModalidade"),
    @NamedQuery(name = "ModalidadeEstagios.findByDescricao", query = "SELECT m FROM ModalidadeEstagios m WHERE m.descricao = :descricao")})
public class ModalidadeEstagios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_modalidade")
    private Integer idModalidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "modalidadeEstagiosIdModalidade")
    private Collection<Aluno> alunoCollection;

    public ModalidadeEstagios() {
    }

    public ModalidadeEstagios(Integer idModalidade) {
        this.idModalidade = idModalidade;
    }

    public ModalidadeEstagios(Integer idModalidade, String descricao) {
        this.idModalidade = idModalidade;
        this.descricao = descricao;
    }

    public Integer getIdModalidade() {
        return idModalidade;
    }

    public void setIdModalidade(Integer idModalidade) {
        this.idModalidade = idModalidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Aluno> getAlunoCollection() {
        return alunoCollection;
    }

    public void setAlunoCollection(Collection<Aluno> alunoCollection) {
        this.alunoCollection = alunoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModalidade != null ? idModalidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModalidadeEstagios)) {
            return false;
        }
        ModalidadeEstagios other = (ModalidadeEstagios) object;
        if ((this.idModalidade == null && other.idModalidade != null) || (this.idModalidade != null && !this.idModalidade.equals(other.idModalidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.ModalidadeEstagios[ idModalidade=" + idModalidade + " ]";
    }
    
}
