package com.br.entity;

import com.br.entity.Administrador;
import com.br.entity.Aluno;
import com.br.entity.Orientador;
import com.br.entity.Palestrante;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-12T09:56:28")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> numMatricula;
    public static volatile CollectionAttribute<Usuario, Palestrante> palestranteCollection;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> telefoneUsuario;
    public static volatile SingularAttribute<Usuario, String> nome;
    public static volatile CollectionAttribute<Usuario, Administrador> administradorCollection;
    public static volatile CollectionAttribute<Usuario, Orientador> orientadorCollection;
    public static volatile CollectionAttribute<Usuario, Aluno> alunoCollection;
    public static volatile SingularAttribute<Usuario, String> emailUsuario;
    public static volatile SingularAttribute<Usuario, String> senhaUsuario;
    public static volatile SingularAttribute<Usuario, String> tipoUsuario;
    public static volatile SingularAttribute<Usuario, Date> dataNascimento;
    public static volatile SingularAttribute<Usuario, Integer> perfilCompleto;

}