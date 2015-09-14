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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author neill
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findByDataNascimento", query = "SELECT u FROM Usuario u WHERE u.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Usuario.findByEmailUsuario", query = "SELECT u FROM Usuario u WHERE u.emailUsuario = :emailUsuario"),
    @NamedQuery(name = "Usuario.findByTelefoneUsuario", query = "SELECT u FROM Usuario u WHERE u.telefoneUsuario = :telefoneUsuario"),
    @NamedQuery(name = "Usuario.findByNumMatricula", query = "SELECT u FROM Usuario u WHERE u.numMatricula = :numMatricula"),
    @NamedQuery(name = "Usuario.findBySenhaUsuario", query = "SELECT u FROM Usuario u WHERE u.senhaUsuario = :senhaUsuario"),
    @NamedQuery(name = "Usuario.findByTipoUsuario", query = "SELECT u FROM Usuario u WHERE u.tipoUsuario = :tipoUsuario"),
    @NamedQuery(name = "Usuario.findByPerfilCompleto", query = "SELECT u FROM Usuario u WHERE u.perfilCompleto = :perfilCompleto")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome_")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email_usuario")
    private String emailUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telefone_usuario")
    private String telefoneUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "num_matricula")
    private String numMatricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "senha_usuario")
    private String senhaUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo_usuario")
    private String tipoUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "perfil_completo")
    private int perfilCompleto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdUsuario")
    private Collection<Administrador> administradorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdUsuario")
    private Collection<Aluno> alunoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdUsuario")
    private Collection<Orientador> orientadorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdUsuario")
    private Collection<Palestrante> palestranteCollection;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nome, Date dataNascimento, String emailUsuario, String telefoneUsuario, String numMatricula, String senhaUsuario, String tipoUsuario, int perfilCompleto) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.emailUsuario = emailUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.numMatricula = numMatricula;
        this.senhaUsuario = senhaUsuario;
        this.tipoUsuario = tipoUsuario;
        this.perfilCompleto = perfilCompleto;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getPerfilCompleto() {
        return perfilCompleto;
    }

    public void setPerfilCompleto(int perfilCompleto) {
        this.perfilCompleto = perfilCompleto;
    }

    @XmlTransient
    public Collection<Administrador> getAdministradorCollection() {
        return administradorCollection;
    }

    public void setAdministradorCollection(Collection<Administrador> administradorCollection) {
        this.administradorCollection = administradorCollection;
    }

    @XmlTransient
    public Collection<Aluno> getAlunoCollection() {
        return alunoCollection;
    }

    public void setAlunoCollection(Collection<Aluno> alunoCollection) {
        this.alunoCollection = alunoCollection;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
