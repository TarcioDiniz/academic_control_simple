package com.academic_control_simple.model;

import java.util.*;

public class Disciplina {
    private final String nome;
    private Professor professor;
    private final Set<Aluno> alunosMatriculados = new HashSet<>();

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

    @Override
    public String toString() {
        return nome;
    }

    public Set<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public int getNumeroAlunos() {
        return alunosMatriculados.size();
    }

    public Professor getProfessor() {
        return professor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina disciplina = (Disciplina) o;
        return Objects.equals(nome, disciplina.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}