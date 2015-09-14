/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author neill
 */
@Embeddable
public class PerguntaRespostaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pergunta_id_pergunta")
    private int perguntaIdPergunta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resposta_id_resposta")
    private int respostaIdResposta;

    public PerguntaRespostaPK() {
    }

    public PerguntaRespostaPK(int id, int perguntaIdPergunta, int respostaIdResposta) {
        this.id = id;
        this.perguntaIdPergunta = perguntaIdPergunta;
        this.respostaIdResposta = respostaIdResposta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPerguntaIdPergunta() {
        return perguntaIdPergunta;
    }

    public void setPerguntaIdPergunta(int perguntaIdPergunta) {
        this.perguntaIdPergunta = perguntaIdPergunta;
    }

    public int getRespostaIdResposta() {
        return respostaIdResposta;
    }

    public void setRespostaIdResposta(int respostaIdResposta) {
        this.respostaIdResposta = respostaIdResposta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) perguntaIdPergunta;
        hash += (int) respostaIdResposta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerguntaRespostaPK)) {
            return false;
        }
        PerguntaRespostaPK other = (PerguntaRespostaPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.perguntaIdPergunta != other.perguntaIdPergunta) {
            return false;
        }
        if (this.respostaIdResposta != other.respostaIdResposta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entity.PerguntaRespostaPK[ id=" + id + ", perguntaIdPergunta=" + perguntaIdPergunta + ", respostaIdResposta=" + respostaIdResposta + " ]";
    }
    
}
