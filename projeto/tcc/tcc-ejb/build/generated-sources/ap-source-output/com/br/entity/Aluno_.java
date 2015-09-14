package com.br.entity;

import com.br.entity.AlunoQuestionario;
import com.br.entity.Cursos;
import com.br.entity.Estagio;
import com.br.entity.ModalidadeEstagios;
import com.br.entity.Orientador;
import com.br.entity.Seminario;
import com.br.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-12T09:56:28")
@StaticMetamodel(Aluno.class)
public class Aluno_ { 

    public static volatile SingularAttribute<Aluno, Usuario> usuarioIdUsuario;
    public static volatile SingularAttribute<Aluno, String> cidade;
    public static volatile SingularAttribute<Aluno, String> rgAluno;
    public static volatile SingularAttribute<Aluno, String> bairro;
    public static volatile SingularAttribute<Aluno, Integer> idAluno;
    public static volatile SingularAttribute<Aluno, String> turno;
    public static volatile SingularAttribute<Aluno, Seminario> seminarioIdSeminario;
    public static volatile SingularAttribute<Aluno, Integer> cep;
    public static volatile SingularAttribute<Aluno, String> cpfAluno;
    public static volatile SingularAttribute<Aluno, String> uf;
    public static volatile CollectionAttribute<Aluno, Estagio> estagioCollection;
    public static volatile SingularAttribute<Aluno, String> ruaEndereco;
    public static volatile CollectionAttribute<Aluno, AlunoQuestionario> alunoQuestionarioCollection;
    public static volatile SingularAttribute<Aluno, Integer> statusEstagioAluno;
    public static volatile SingularAttribute<Aluno, Cursos> cursosIdCurso;
    public static volatile SingularAttribute<Aluno, ModalidadeEstagios> modalidadeEstagiosIdModalidade;
    public static volatile SingularAttribute<Aluno, Orientador> orientadorIdOrientador;

}