/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author neill
 */
@Entity
@Table(name = "estagio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estagio.findAll", query = "SELECT e FROM Estagio e"),
    @NamedQuery(name = "Estagio.findByIdestagio", query = "SELECT e FROM Estagio e WHERE e.idestagio = :idestagio"),
    @NamedQuery(name = "Estagio.findByCargaHoraria", query = "SELECT e FROM Estagio e WHERE e.cargaHoraria = :cargaHoraria"),
    @NamedQuery(name = "Estagio.findByDataIni", query = "SELECT e FROM Estagio e WHERE e.dataIni = :dataIni"),
    @NamedQuery(name = "Estagio.findByDataFim", query = "SELECT e FROM Estagio e WHERE e.dataFim = :dataFim"),
    @NamedQuery(name = "Estagio.findByRemuneracao", query = "SELECT e FROM Estagio e WHERE e.remuneracao = :remuneracao")})
public class Estagio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_estagio")
    private Integer idestagio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "carga_horaria")
    private int cargaHoraria;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "remuneracao")
    private BigDecimal remuneracao;
    @JoinColumn(name = "aluno_id_aluno", referencedColumnName = "id_aluno")
    @ManyToOne(optional = false)
    private Aluno alunoIdAluno;
    @JoinColumn(name = "cursos_id_curso", referencedColumnName = "id_curso")
    @ManyToOne(optional = false)
    private Cursos cursosIdCurso;
    @JoinColumn(name = "empresa_id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false)
    private Empresa empresaIdEmpresa;

    public Estagio() {
    }

    public Estagio(Integer idestagio) {
        this.idestagio = idestagio;
    }

    public Estagio(Integer idestagio, int cargaHoraria, Date dataIni, Date dataFim, BigDecimal remuneracao) {
        this.idestagio = idestagio;
        this.cargaHoraria = cargaHoraria;
        this.dataIni = dataIni;
        this.dataFim = dataFim;
        this.remuneracao = remuneracao;
    }

    public Integer getIdestagio() {
        return idestagio;
    }

    public void setIdestagio(Integer idestagio) {
        this.idestagio = idestagio;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
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

    public BigDecimal getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(BigDecimal remuneracao) {
        this.remuneracao = remuneracao;
    }

    public Aluno getAlunoIdAluno() {
        return alunoIdAluno;
    }

    public void setAlunoIdAluno(Aluno alunoIdAluno) {
        this.alunoIdAluno = alunoIdAluno;
    }

    public Cursos getCursosIdCurso() {
        return cursosIdCurso;
    }

    public void setCursosIdCurso(Cursos cursosIdCurso) {
        this.cursosIdCurso = cursosIdCurso;
    }

    public Empresa getEmpresaIdEmpresa() {
        return empresaIdEmpresa;
    }

    public void setEmpresaIdEmpresa(Empresa empresaIdEmpresa) {
        this.empresaIdEmpresa = empresaIdEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestagio != null ? idestagio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estagio)) {
            return false;
        }
        Estagio other = (Estagio) object;
        if ((this.idestagio == null && other.idestagio != null) || (this.idestagio != null && !this.idestagio.equals(other.idestagio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.Estagio[ idestagio=" + idestagio + " ]";
    }
    
}
