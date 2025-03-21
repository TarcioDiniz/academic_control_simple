package com.academic_control_simple.model;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private final String nome;
    private Professor professor;
    private final List<Aluno> alunosMatriculados = new ArrayList<>();

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void adicionarAluno(Aluno aluno) {
        alunosMatriculados.add(aluno);
    }

    public String getNome() {
        return nome;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public int getNumeroAlunos() {
        return alunosMatriculados.size();
    }

    public Professor getProfessor() {
        return professor;
    }
}