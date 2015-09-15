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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author neill
 */
@Entity
@Table(name = "aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
    @NamedQuery(name = "Aluno.findByIdAluno", query = "SELECT a FROM Aluno a WHERE a.idAluno = :idAluno"),
    @NamedQuery(name = "Aluno.findByRgAluno", query = "SELECT a FROM Aluno a WHERE a.rgAluno = :rgAluno"),
    @NamedQuery(name = "Aluno.findByCpfAluno", query = "SELECT a FROM Aluno a WHERE a.cpfAluno = :cpfAluno"),
    @NamedQuery(name = "Aluno.findByRuaEndereco", query = "SELECT a FROM Aluno a WHERE a.ruaEndereco = :ruaEndereco"),
    @NamedQuery(name = "Aluno.findByBairro", query = "SELECT a FROM Aluno a WHERE a.bairro = :bairro"),
    @NamedQuery(name = "Aluno.findByCidade", query = "SELECT a FROM Aluno a WHERE a.cidade = :cidade"),
    @NamedQuery(name = "Aluno.findByUf", query = "SELECT a FROM Aluno a WHERE a.uf = :uf"),
    @NamedQuery(name = "Aluno.findByCep", query = "SELECT a FROM Aluno a WHERE a.cep = :cep"),
    @NamedQuery(name = "Aluno.findByTurno", query = "SELECT a FROM Aluno a WHERE a.turno = :turno"),
    @NamedQuery(name = "Aluno.findByStatusEstagioAluno", query = "SELECT a FROM Aluno a WHERE a.statusEstagioAluno = :statusEstagioAluno")})
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aluno")
    private Integer idAluno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "rg_aluno")
    private String rgAluno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "cpf_aluno")
    private String cpfAluno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rua_endereco")
    private String ruaEndereco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "uf")
    private String uf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cep")
    private int cep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "turno")
    private String turno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status_estagio_aluno")
    private int statusEstagioAluno;
    @JoinColumn(name = "cursos_id_curso", referencedColumnName = "id_curso")
    @ManyToOne(optional = false)
    private Cursos cursosIdCurso;
    @JoinColumn(name = "modalidade_estagios_id_modalidade", referencedColumnName = "id_modalidade")
    @ManyToOne
    private ModalidadeEstagios modalidadeEstagiosIdModalidade;
    @JoinColumn(name = "orientador_id_orientador", referencedColumnName = "id_orientador")
    @ManyToOne(optional = false)
    private Orientador orientadorIdOrientador;
    @JoinColumn(name = "seminario_id_seminario", referencedColumnName = "id_seminario")
    @ManyToOne
    private Seminario seminarioIdSeminario;
    @JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioIdUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alunoIdAluno")
    private Collection<Estagio> estagioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private Collection<AlunoQuestionario> alunoQuestionarioCollection;

    public Aluno() {
    }

    public Aluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public Aluno(Integer idAluno, String rgAluno, String cpfAluno, String ruaEndereco, String bairro, String cidade, String uf, int cep, String turno, int statusEstagioAluno) {
        this.idAluno = idAluno;
        this.rgAluno = rgAluno;
        this.cpfAluno = cpfAluno;
        this.ruaEndereco = ruaEndereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.turno = turno;
        this.statusEstagioAluno = statusEstagioAluno;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public String getRgAluno() {
        return rgAluno;
    }

    public void setRgAluno(String rgAluno) {
        this.rgAluno = rgAluno;
    }

    public String getCpfAluno() {
        return cpfAluno;
    }

    public void setCpfAluno(String cpfAluno) {
        this.cpfAluno = cpfAluno;
    }

    public String getRuaEndereco() {
        return ruaEndereco;
    }

    public void setRuaEndereco(String ruaEndereco) {
        this.ruaEndereco = ruaEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getStatusEstagioAluno() {
        return statusEstagioAluno;
    }

    public void setStatusEstagioAluno(int statusEstagioAluno) {
        this.statusEstagioAluno = statusEstagioAluno;
    }

    public Cursos getCursosIdCurso() {
        return cursosIdCurso;
    }

    public void setCursosIdCurso(Cursos cursosIdCurso) {
        this.cursosIdCurso = cursosIdCurso;
    }

    public ModalidadeEstagios getModalidadeEstagiosIdModalidade() {
        return modalidadeEstagiosIdModalidade;
    }

    public void setModalidadeEstagiosIdModalidade(ModalidadeEstagios modalidadeEstagiosIdModalidade) {
        this.modalidadeEstagiosIdModalidade = modalidadeEstagiosIdModalidade;
    }

    public Orientador getOrientadorIdOrientador() {
        return orientadorIdOrientador;
    }

    public void setOrientadorIdOrientador(Orientador orientadorIdOrientador) {
        this.orientadorIdOrientador = orientadorIdOrientador;
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

    @XmlTransient
    public Collection<Estagio> getEstagioCollection() {
        return estagioCollection;
    }

    public void setEstagioCollection(Collection<Estagio> estagioCollection) {
        this.estagioCollection = estagioCollection;
    }

    @XmlTransient
    public Collection<AlunoQuestionario> getAlunoQuestionarioCollection() {
        return alunoQuestionarioCollection;
    }

    public void setAlunoQuestionarioCollection(Collection<AlunoQuestionario> alunoQuestionarioCollection) {
        this.alunoQuestionarioCollection = alunoQuestionarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAluno != null ? idAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.idAluno == null && other.idAluno != null) || (this.idAluno != null && !this.idAluno.equals(other.idAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.Aluno[ idAluno=" + idAluno + " ]";
    }
    
}
