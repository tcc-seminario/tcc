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
@Table(name = "palestrante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Palestrante.findAll", query = "SELECT p FROM Palestrante p"),
    @NamedQuery(name = "Palestrante.findByIdPalestrante", query = "SELECT p FROM Palestrante p WHERE p.idPalestrante = :idPalestrante")})
public class Palestrante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_palestrante")
    private Integer idPalestrante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "palestranteIdPalestrante")
    private Collection<Palestra> palestraCollection;
    @JoinColumn(name = "seminario_id_seminario", referencedColumnName = "id_seminario")
    @ManyToOne(optional = false)
    private Seminario seminarioIdSeminario;
    @JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioIdUsuario;

    public Palestrante() {
    }

    public Palestrante(Integer idPalestrante) {
        this.idPalestrante = idPalestrante;
    }

    public Integer getIdPalestrante() {
        return idPalestrante;
    }

    public void setIdPalestrante(Integer idPalestrante) {
        this.idPalestrante = idPalestrante;
    }

    @XmlTransient
    public Collection<Palestra> getPalestraCollection() {
        return palestraCollection;
    }

    public void setPalestraCollection(Collection<Palestra> palestraCollection) {
        this.palestraCollection = palestraCollection;
    }

    public Seminario getSeminarioIdSeminario() {
        return seminarioIdSeminario;
    }

    public void setSeminarioIdSeminario(Seminario seminarioIdSeminario) {
        this.seminarioIdSeminario = seminarioIdSeminario;
    }

    public Usuario getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Usuario usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPalestrante != null ? idPalestrante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Palestrante)) {
            return false;
        }
        Palestrante other = (Palestrante) object;
        if ((this.idPalestrante == null && other.idPalestrante != null) || (this.idPalestrante != null && !this.idPalestrante.equals(other.idPalestrante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.Palestrante[ idPalestrante=" + idPalestrante + " ]";
    }
    
}
