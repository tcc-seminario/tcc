package com.br.entity;

import com.br.entity.AlunoQuestionarioResposta;
import com.br.entity.EmpresaQuestionarioResposta;
import com.br.entity.PerguntaResposta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-12T09:56:28")
@StaticMetamodel(Resposta.class)
public class Resposta_ { 

    public static volatile SingularAttribute<Resposta, Integer> idResposta;
    public static volatile CollectionAttribute<Resposta, PerguntaResposta> perguntaRespostaCollection;
    public static volatile SingularAttribute<Resposta, String> resposta;
    public static volatile CollectionAttribute<Resposta, EmpresaQuestionarioResposta> empresaQuestionarioRespostaCollection;
    public static volatile CollectionAttribute<Resposta, AlunoQuestionarioResposta> alunoQuestionarioRespostaCollection;

}