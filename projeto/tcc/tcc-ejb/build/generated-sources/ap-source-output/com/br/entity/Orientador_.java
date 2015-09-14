package com.br.entity;

import com.br.entity.Aluno;
import com.br.entity.Cursos;
import com.br.entity.Seminario;
import com.br.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-12T09:56:28")
@StaticMetamodel(Orientador.class)
public class Orientador_ { 

    public static volatile SingularAttribute<Orientador, Usuario> usuarioIdUsuario;
    public static volatile CollectionAttribute<Orientador, Aluno> alunoCollection;
    public static volatile SingularAttribute<Orientador, Integer> idOrientador;
    public static volatile SingularAttribute<Orientador, Cursos> cursosIdCurso;
    public static volatile SingularAttribute<Orientador, Seminario> seminarioIdSeminario;

}