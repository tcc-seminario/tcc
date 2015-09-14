package com.br.entity;

import com.br.entity.Palestra;
import com.br.entity.Seminario;
import com.br.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-12T09:56:28")
@StaticMetamodel(Palestrante.class)
public class Palestrante_ { 

    public static volatile SingularAttribute<Palestrante, Usuario> usuarioIdUsuario;
    public static volatile SingularAttribute<Palestrante, Integer> idPalestrante;
    public static volatile CollectionAttribute<Palestrante, Palestra> palestraCollection;
    public static volatile SingularAttribute<Palestrante, Seminario> seminarioIdSeminario;

}