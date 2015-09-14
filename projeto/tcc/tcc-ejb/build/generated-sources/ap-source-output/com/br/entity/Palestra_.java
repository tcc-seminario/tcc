package com.br.entity;

import com.br.entity.Palestrante;
import com.br.entity.Seminario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-12T09:56:28")
@StaticMetamodel(Palestra.class)
public class Palestra_ { 

    public static volatile SingularAttribute<Palestra, Integer> idPalestra;
    public static volatile SingularAttribute<Palestra, String> nomePalestra;
    public static volatile SingularAttribute<Palestra, Date> dataHora;
    public static volatile SingularAttribute<Palestra, Palestrante> palestranteIdPalestrante;
    public static volatile SingularAttribute<Palestra, Seminario> seminarioIdSeminario;

}