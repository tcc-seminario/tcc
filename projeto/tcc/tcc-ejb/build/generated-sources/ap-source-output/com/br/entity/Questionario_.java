package com.br.entity;

import com.br.entity.AlunoQuestionario;
import com.br.entity.Cursos;
import com.br.entity.EmpresaQuestionario;
import com.br.entity.QuestionarioPergunta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-12T09:56:28")
@StaticMetamodel(Questionario.class)
public class Questionario_ { 

    public static volatile CollectionAttribute<Questionario, QuestionarioPergunta> questionarioPerguntaCollection;
    public static volatile SingularAttribute<Questionario, String> nomeQuestionario;
    public static volatile CollectionAttribute<Questionario, AlunoQuestionario> alunoQuestionarioCollection;
    public static volatile SingularAttribute<Questionario, Integer> idQuestionario;
    public static volatile CollectionAttribute<Questionario, EmpresaQuestionario> empresaQuestionarioCollection;
    public static volatile SingularAttribute<Questionario, Cursos> cursosIdCurso;
    public static volatile SingularAttribute<Questionario, String> tipoQuestionario;

}