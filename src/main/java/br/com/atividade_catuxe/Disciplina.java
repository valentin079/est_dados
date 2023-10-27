package br.com.atividade_catuxe;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
//    Atributos Descrição
//- codigo int Código da Disciplina
//- nome String Nome da Disciplina
//- horario String Horário da Disciplina
//- listaAlunos Aluno[] Lista de Alunos matriculados na disciplina

    private int codigo;
    private String nome;
    private String horario;
    private List<Aluno> totalAlunos;


    public Disciplina(int codigo, String nome, String horario, List<Aluno> totalAlunos) {
        this.codigo = codigo;
        this.nome = nome;
        this.horario = horario;
        this.totalAlunos = totalAlunos;
    }

    public void MatricularAluno(Aluno aluno){
        if (totalAlunos == null) {
            totalAlunos = new ArrayList<>();
        }
        totalAlunos.add(aluno);
    }




    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public List<Aluno> getTotalAlunos() {
        return totalAlunos;
    }


}
