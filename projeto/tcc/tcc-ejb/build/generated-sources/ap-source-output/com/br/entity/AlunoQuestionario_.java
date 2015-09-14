package com.br.entity;

import com.br.entity.Aluno;
import com.br.entity.AlunoQuestionarioPK;
import com.br.entity.AlunoQuestionarioResposta;
import com.br.entity.Questionario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-12T09:56:28")
@StaticMetamodel(AlunoQuestionario.class)
public class AlunoQuestionario_ { 

    public static volatile SingularAttribute<AlunoQuestionario, Aluno> aluno;
    public static volatile SingularAttribute<AlunoQuestionario, AlunoQuestionarioPK> alunoQuestionarioPK;
    public static volatile CollectionAttribute<AlunoQuestionario, AlunoQuestionarioResposta> alunoQuestionarioRespostaCollection;
    public static volatile SingularAttribute<AlunoQuestionario, Questionario> questionario;

}