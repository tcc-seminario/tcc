package com.br.entity;

import com.br.entity.Aluno;
import com.br.entity.Orientador;
import com.br.entity.Palestra;
import com.br.entity.Palestrante;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-12T09:56:28")
@StaticMetamodel(Seminario.class)
public class Seminario_ { 

    public static volatile CollectionAttribute<Seminario, Palestrante> palestranteCollection;
    public static volatile CollectionAttribute<Seminario, Orientador> orientadorCollection;
    public static volatile SingularAttribute<Seminario, Date> dataFim;
    public static volatile CollectionAttribute<Seminario, Aluno> alunoCollection;
    public static volatile SingularAttribute<Seminario, Integer> idSeminario;
    public static volatile CollectionAttribute<Seminario, Palestra> palestraCollection;
    public static volatile SingularAttribute<Seminario, Date> dataIni;

}