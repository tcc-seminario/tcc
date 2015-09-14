/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author neill
 */
@Entity
@Table(name = "pergunta_resposta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerguntaResposta.findAll", query = "SELECT p FROM PerguntaResposta p"),
    @NamedQuery(name = "PerguntaResposta.findById", query = "SELECT p FROM PerguntaResposta p WHERE p.perguntaRespostaPK.id = :id"),
    @NamedQuery(name = "PerguntaResposta.findByPerguntaIdPergunta", query = "SELECT p FROM PerguntaResposta p WHERE p.perguntaRespostaPK.perguntaIdPergunta = :perguntaIdPergunta"),
    @NamedQuery(name = "PerguntaResposta.findByRespostaIdResposta", query = "SELECT p FROM PerguntaResposta p WHERE p.perguntaRespostaPK.respostaIdResposta = :respostaIdResposta")})
public class PerguntaResposta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerguntaRespostaPK perguntaRespostaPK;
    @JoinColumn(name = "pergunta_id_pergunta", referencedColumnName = "id_pergunta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pergunta pergunta;
    @JoinColumn(name = "resposta_id_resposta", referencedColumnName = "id_resposta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Resposta resposta;

    public PerguntaResposta() {
    }

    public PerguntaResposta(PerguntaRespostaPK perguntaRespostaPK) {
        this.perguntaRespostaPK = perguntaRespostaPK;
    }

    public PerguntaResposta(int id, int perguntaIdPergunta, int respostaIdResposta) {
        this.perguntaRespostaPK = new PerguntaRespostaPK(id, perguntaIdPergunta, respostaIdResposta);
    }

    public PerguntaRespostaPK getPerguntaRespostaPK() {
        return perguntaRespostaPK;
    }

    public void setPerguntaRespostaPK(PerguntaRespostaPK perguntaRespostaPK) {
        this.perguntaRespostaPK = perguntaRespostaPK;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perguntaRespostaPK != null ? perguntaRespostaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerguntaResposta)) {
            return false;
        }
        PerguntaResposta other = (PerguntaResposta) object;
        if ((this.perguntaRespostaPK == null && other.perguntaRespostaPK != null) || (this.perguntaRespostaPK != null && !this.perguntaRespostaPK.equals(other.perguntaRespostaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.PerguntaResposta[ perguntaRespostaPK=" + perguntaRespostaPK + " ]";
    }
    
}
