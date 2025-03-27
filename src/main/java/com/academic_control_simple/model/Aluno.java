package com.academic_control_simple.model;

import java.util.*;

public class Aluno extends Usuario {
    private final Set<Disciplina> disciplinasMatriculadas = new HashSet<>();

    public Aluno(String matricula, String nome,Horario horario) {
        super(matricula, nome, horario);
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinasMatriculadas.add(disciplina);
        disciplina.adicionarAluno(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(matricula, aluno.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinasMatriculadas;
    }
}
