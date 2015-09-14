package com.br.entity;

import com.br.entity.Cursos;
import com.br.entity.PerguntaResposta;
import com.br.entity.QuestionarioPergunta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-12T09:56:28")
@StaticMetamodel(Pergunta.class)
public class Pergunta_ { 

    public static volatile CollectionAttribute<Pergunta, PerguntaResposta> perguntaRespostaCollection;
    public static volatile SingularAttribute<Pergunta, Integer> idPergunta;
    public static volatile CollectionAttribute<Pergunta, QuestionarioPergunta> questionarioPerguntaCollection;
    public static volatile SingularAttribute<Pergunta, String> enunciado;
    public static volatile SingularAttribute<Pergunta, Cursos> cursosIdCurso;

}