/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.entity;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author neill
 */
@Entity
@Table(name = "palestra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Palestra.findAll", query = "SELECT p FROM Palestra p"),
    @NamedQuery(name = "Palestra.findByIdPalestra", query = "SELECT p FROM Palestra p WHERE p.idPalestra = :idPalestra"),
    @NamedQuery(name = "Palestra.findByNomePalestra", query = "SELECT p FROM Palestra p WHERE p.nomePalestra = :nomePalestra"),
    @NamedQuery(name = "Palestra.findByDataHora", query = "SELECT p FROM Palestra p WHERE p.dataHora = :dataHora")})
public class Palestra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_palestra")
    private Integer idPalestra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome_palestra")
    private String nomePalestra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @JoinColumn(name = "palestrante_id_palestrante", referencedColumnName = "id_palestrante")
    @ManyToOne(optional = false)
    private Palestrante palestranteIdPalestrante;
    @JoinColumn(name = "seminario_id_seminario", referencedColumnName = "id_seminario")
    @ManyToOne(optional = false)
    private Seminario seminarioIdSeminario;

    public Palestra() {
    }

    public Palestra(Integer idPalestra) {
        this.idPalestra = idPalestra;
    }

    public Palestra(Integer idPalestra, String nomePalestra, Date dataHora) {
        this.idPalestra = idPalestra;
        this.nomePalestra = nomePalestra;
        this.dataHora = dataHora;
    }

    public Integer getIdPalestra() {
        return idPalestra;
    }

    public void setIdPalestra(Integer idPalestra) {
        this.idPalestra = idPalestra;
    }

    public String getNomePalestra() {
        return nomePalestra;
    }

    public void setNomePalestra(String nomePalestra) {
        this.nomePalestra = nomePalestra;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Palestrante getPalestranteIdPalestrante() {
        return palestranteIdPalestrante;
    }

    public void setPalestranteIdPalestrante(Palestrante palestranteIdPalestrante) {
        this.palestranteIdPalestrante = palestranteIdPalestrante;
    }

    public Seminario getSeminarioIdSeminario() {
        return seminarioIdSeminario;
    }

    public void setSeminarioIdSeminario(Seminario seminarioIdSeminario) {
        this.seminarioIdSeminario = seminarioIdSeminario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPalestra != null ? idPalestra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Palestra)) {
            return false;
        }
        Palestra other = (Palestra) object;
        if ((this.idPalestra == null && other.idPalestra != null) || (this.idPalestra != null && !this.idPalestra.equals(other.idPalestra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.Palestra[ idPalestra=" + idPalestra + " ]";
    }
    
}
