package models

class Curso(
    var nomeCurso: String,
    var codigoCurso: Int,
    var quantidadeMaximaAlunos: Int,
    ) {

    lateinit var professorTitular: ProfessorTitular;

    lateinit var professorAdjunto: ProfessorAdjunto;

    lateinit var alunos: ArrayList<Aluno>;

    fun adicionaUmAluno(aluno: Aluno): Boolean {

        if (this.quantidadeMaximaAlunos < this.alunos.size) {

            this.alunos.add(aluno);

            return true;

        } else {

            return false;

        }

    }

    fun excluirAluno(umAluno: Aluno) {

        if (alunos.contains(umAluno.codigoAluno)) {

            alunos.remove(umAluno);

        }

    }

}