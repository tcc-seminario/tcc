package com.br.entity;

import com.br.entity.Aluno;
import com.br.entity.Estagio;
import com.br.entity.Orientador;
import com.br.entity.Pergunta;
import com.br.entity.Questionario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-12T09:56:28")
@StaticMetamodel(Cursos.class)
public class Cursos_ { 

    public static volatile SingularAttribute<Cursos, String> nomeCurso;
    public static volatile CollectionAttribute<Cursos, Pergunta> perguntaCollection;
    public static volatile CollectionAttribute<Cursos, Orientador> orientadorCollection;
    public static volatile CollectionAttribute<Cursos, Aluno> alunoCollection;
    public static volatile CollectionAttribute<Cursos, Estagio> estagioCollection;
    public static volatile SingularAttribute<Cursos, Integer> idCurso;
    public static volatile CollectionAttribute<Cursos, Questionario> questionarioCollection;

}