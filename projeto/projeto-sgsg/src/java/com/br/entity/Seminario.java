/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author neill
 */
@Entity
@Table(name = "seminario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seminario.findAll", query = "SELECT s FROM Seminario s"),
    @NamedQuery(name = "Seminario.findByIdSeminario", query = "SELECT s FROM Seminario s WHERE s.idSeminario = :idSeminario"),
    @NamedQuery(name = "Seminario.findByDataIni", query = "SELECT s FROM Seminario s WHERE s.dataIni = :dataIni"),
    @NamedQuery(name = "Seminario.findByDataFim", query = "SELECT s FROM Seminario s WHERE s.dataFim = :dataFim")})
public class Seminario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_seminario")
    private Integer idSeminario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_ini")
    @Temporal(TemporalType.DATE)
    private Date dataIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @OneToMany(mappedBy = "seminarioIdSeminario")
    private Collection<Aluno> alunoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seminarioIdSeminario")
    private Collection<Palestra> palestraCollection;
    @OneToMany(mappedBy = "seminarioIdSeminario")
    private Collection<Orientador> orientadorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seminarioIdSeminario")
    private Collection<Palestrante> palestranteCollection;

    public Seminario() {
    }

    public Seminario(Integer idSeminario) {
        this.idSeminario = idSeminario;
    }

    public Seminario(Integer idSeminario, Date dataIni, Date dataFim) {
        this.idSeminario = idSeminario;
        this.dataIni = dataIni;
        this.dataFim = dataFim;
    }

    public Integer getIdSeminario() {
        return idSeminario;
    }

    public void setIdSeminario(Integer idSeminario) {
        this.idSeminario = idSeminario;
    }

    public Date getDataIni() {
        return dataIni;
    }

    public void setDataIni(Date dataIni) {
        this.dataIni = dataIni;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @XmlTransient
    public Collection<Aluno> getAlunoCollection() {
        return alunoCollection;
    }

    public void setAlunoCollection(Collection<Aluno> alunoCollection) {
        this.alunoCollection = alunoCollection;
    }

    @XmlTransient
    public Collection<Palestra> getPalestraCollection() {
        return palestraCollection;
    }

    public void setPalestraCollection(Collection<Palestra> palestraCollection) {
        this.palestraCollection = palestraCollection;
    }

    @XmlTransient
    public Collection<Orientador> getOrientadorCollection() {
        return orientadorCollection;
    }

    public void setOrientadorCollection(Collection<Orientador> orientadorCollection) {
        this.orientadorCollection = orientadorCollection;
    }

    @XmlTransient
    public Collection<Palestrante> getPalestranteCollection() {
        return palestranteCollection;
    }

    public void setPalestranteCollection(Collection<Palestrante> palestranteCollection) {
        this.palestranteCollection = palestranteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeminario != null ? idSeminario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seminario)) {
            return false;
        }
        Seminario other = (Seminario) object;
        if ((this.idSeminario == null && other.idSeminario != null) || (this.idSeminario != null && !this.idSeminario.equals(other.idSeminario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.Seminario[ idSeminario=" + idSeminario + " ]";
    }
    
}
