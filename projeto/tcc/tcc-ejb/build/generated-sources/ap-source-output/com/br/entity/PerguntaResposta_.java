package com.br.entity;

import com.br.entity.Pergunta;
import com.br.entity.PerguntaRespostaPK;
import com.br.entity.Resposta;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-12T09:56:28")
@StaticMetamodel(PerguntaResposta.class)
public class PerguntaResposta_ { 

    public static volatile SingularAttribute<PerguntaResposta, Pergunta> pergunta;
    public static volatile SingularAttribute<PerguntaResposta, Resposta> resposta;
    public static volatile SingularAttribute<PerguntaResposta, PerguntaRespostaPK> perguntaRespostaPK;

}