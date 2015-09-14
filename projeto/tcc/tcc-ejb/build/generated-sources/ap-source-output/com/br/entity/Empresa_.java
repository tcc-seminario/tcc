package com.br.entity;

import com.br.entity.EmpresaQuestionario;
import com.br.entity.Estagio;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-12T09:56:28")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile SingularAttribute<Empresa, String> orientadorEmpresa;
    public static volatile SingularAttribute<Empresa, String> cidade;
    public static volatile SingularAttribute<Empresa, String> telefone;
    public static volatile SingularAttribute<Empresa, String> bairro;
    public static volatile SingularAttribute<Empresa, String> nome;
    public static volatile SingularAttribute<Empresa, String> cnpj;
    public static volatile CollectionAttribute<Empresa, EmpresaQuestionario> empresaQuestionarioCollection;
    public static volatile SingularAttribute<Empresa, String> cep;
    public static volatile SingularAttribute<Empresa, String> uf;
    public static volatile SingularAttribute<Empresa, String> enderecoRua;
    public static volatile CollectionAttribute<Empresa, Estagio> estagioCollection;
    public static volatile SingularAttribute<Empresa, Integer> idEmpresa;
    public static volatile SingularAttribute<Empresa, String> fax;
    public static volatile SingularAttribute<Empresa, String> email;

}