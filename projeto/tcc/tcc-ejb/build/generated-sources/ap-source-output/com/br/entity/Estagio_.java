package com.br.entity;

import com.br.entity.Aluno;
import com.br.entity.Cursos;
import com.br.entity.Empresa;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-12T09:56:28")
@StaticMetamodel(Estagio.class)
public class Estagio_ { 

    public static volatile SingularAttribute<Estagio, Empresa> empresaIdEmpresa;
    public static volatile SingularAttribute<Estagio, Date> dataFim;
    public static volatile SingularAttribute<Estagio, BigDecimal> remuneracao;
    public static volatile SingularAttribute<Estagio, Integer> idestagio;
    public static volatile SingularAttribute<Estagio, Aluno> alunoIdAluno;
    public static volatile SingularAttribute<Estagio, Cursos> cursosIdCurso;
    public static volatile SingularAttribute<Estagio, Integer> cargaHoraria;
    public static volatile SingularAttribute<Estagio, Date> dataIni;

}