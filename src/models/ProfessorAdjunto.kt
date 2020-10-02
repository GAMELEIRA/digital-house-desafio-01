package models

class ProfessorAdjunto(

    nome: String,

    sobrenome: String,

    codigoProfessor: Int,

    tempoDeCasa: Int,

) : Professor(nome, sobrenome, tempoDeCasa,  codigoProfessor) {

    var quantidadeHorasMonitoria: Int = 0;

}