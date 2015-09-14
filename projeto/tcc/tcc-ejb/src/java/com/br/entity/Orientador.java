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
@Table(name = "orientador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orientador.findAll", query = "SELECT o FROM Orientador o"),
    @NamedQuery(name = "Orientador.findByIdOrientador", query = "SELECT o FROM Orientador o WHERE o.idOrientador = :idOrientador")})
public class Orientador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orientador")
    private Integer idOrientador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orientadorIdOrientador")
    private Collection<Aluno> alunoCollection;
    @JoinColumn(name = "cursos_id_curso", referencedColumnName = "id_curso")
    @ManyToOne(optional = false)
    private Cursos cursosIdCurso;
    @JoinColumn(name = "seminario_id_seminario", referencedColumnName = "id_seminario")
    @ManyToOne
    private Seminario seminarioIdSeminario;
    @JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioIdUsuario;

    public Orientador() {
    }

    public Orientador(Integer idOrientador) {
        this.idOrientador = idOrientador;
    }

    public Integer getIdOrientador() {
        return idOrientador;
    }

    public void setIdOrientador(Integer idOrientador) {
        this.idOrientador = idOrientador;
    }

    @XmlTransient
    public Collection<Aluno> getAlunoCollection() {
        return alunoCollection;
    }

    public void setAlunoCollection(Collection<Aluno> alunoCollection) {
        this.alunoCollection = alunoCollection;
    }

    public Cursos getCursosIdCurso() {
        return cursosIdCurso;
    }

    public void setCursosIdCurso(Cursos cursosIdCurso) {
        this.cursosIdCurso = cursosIdCurso;
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
        hash += (idOrientador != null ? idOrientador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orientador)) {
            return false;
        }
        Orientador other = (Orientador) object;
        if ((this.idOrientador == null && other.idOrientador != null) || (this.idOrientador != null && !this.idOrientador.equals(other.idOrientador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.Orientador[ idOrientador=" + idOrientador + " ]";
    }
    
}
