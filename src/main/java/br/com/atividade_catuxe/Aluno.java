package br.com.atividade_catuxe;

public class Aluno {
//    Classe: Aluno
//    Classe responsável por identificar um aluno
//    Atributos Descrição
//- nrMatricula int Matrícula do aluno
//- nome String Nome do Aluno
//- status char Status da Matrícula ( A – Ativo | T – Trancado)
//- media float Média atual do aluno
//    Métodos
//            (vale 0,5)+Aluno(int nrMatricula, String nome, float media)
//    Construtor da classe Aluno. Somente o nome do aluno poderá ter seu valor alterado
    private int nrMatricula;
    private String nomeDoAluno;
    private char statusDaMatricula;
    private float mediaAtualDoAluno;

    public Aluno(int nrMatricula, String nomeDoAluno, float mediaAtualDoAluno) {
        this.nrMatricula = nrMatricula;
        this.nomeDoAluno = nomeDoAluno;
        this.mediaAtualDoAluno = mediaAtualDoAluno;
    }
}
