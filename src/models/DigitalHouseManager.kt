package models

import java.util.*
import kotlin.collections.ArrayList

class DigitalHouseManager(

    var alunos: ArrayList<Aluno>,

    var professores: ArrayList<Professor>,

    var cursos: ArrayList<Curso>,

    var matriculas: ArrayList<Matricula>

) {

    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int) {

        val cursoNovo = Curso(nome, codigoCurso, quantidadeMaximaDeAlunos);

        this.cursos.add(cursoNovo);

    }

    fun excluirCurso(codigoCurso: Int) {

        cursos.forEach {

            if (it.codigoCurso == codigoCurso) {

                this.cursos.remove(it);

            }

        }

    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int) {

        val professorAdjunto = ProfessorAdjunto(nome, sobrenome, codigoProfessor, quantidadeDeHoras, especialidade);

        this.professores.add(professorAdjunto);

    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {

        val professorTitular = ProfessorAdjunto(nome, sobrenome, codigoProfessor, 0, especialidade);

        this.professores.add(professorTitular);

    }

    fun excluirProfessor(codigoProfessor: Int) {

        cursos.forEach {

            if (it.codigoCurso == codigoProfessor) {

                this.cursos.remove(it);

            }

        }

    }

    fun registrarAluno(nome: String, sobrenome: String, codigoAluno: Int) {

        val aluno = Aluno(nome, sobrenome, codigoAluno);

        this.alunos.add(aluno);

    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {

        var curso: Curso? = null;

        var aluno: Aluno? = null;

        var matricula: Matricula;

        this.cursos.forEach {

            if (it.codigoCurso == codigoCurso) {

                curso = it;

                valideUm = true;

            }

        }

        this.alunos.forEach {

            if (it.codigoAluno == codigoAluno) {

                aluno = it;

                valideDois = true;

            }

        }

        if (aluno == null || curso == null && curso?.adicionaUmAluno(aluno!!)!!) {

            println("Não há vagas!");

            return;

        } else {

            matricula = Matricula(aluno!!, curso!!, Date());

            this.matriculas.add(matricula);

            println("Matricula finalizada!")

        }

    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int,codigoProfessorAdjunto: Int){

        var professorTitular: Professor? = null;

        var professorAdjunto: Professor? = null;

        var curso: Curso? = null;

        this.professores.forEach {

            if (it.codigoDoProfessor == codigoProfessorTitular) {

                professorTitular = it;

            }

            if (it.codigoDoProfessor == codigoProfessorAdjunto){

                professorAdjunto = it;

            }

        }

        this.cursos.forEach {

            if(it.codigoCurso == codigoCurso) {

                if (it.codigoCurso == codigoCurso){

                    curso = it;

                }

            }

        }

        if(curso == null || professorAdjunto == null || professorTitular == null){

            return;

        } else {

            curso!!.professorAdjunto = professorAdjunto as ProfessorAdjunto;

            curso!!.professorTitular = professorTitular as ProfessorTitular;

        }

    }

}
