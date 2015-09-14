package com.br.entity;

import com.br.entity.Empresa;
import com.br.entity.EmpresaQuestionarioPK;
import com.br.entity.EmpresaQuestionarioResposta;
import com.br.entity.Questionario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-12T09:56:28")
@StaticMetamodel(EmpresaQuestionario.class)
public class EmpresaQuestionario_ { 

    public static volatile SingularAttribute<EmpresaQuestionario, EmpresaQuestionarioPK> empresaQuestionarioPK;
    public static volatile CollectionAttribute<EmpresaQuestionario, EmpresaQuestionarioResposta> empresaQuestionarioRespostaCollection;
    public static volatile SingularAttribute<EmpresaQuestionario, Empresa> empresa;
    public static volatile SingularAttribute<EmpresaQuestionario, Questionario> questionario;

}