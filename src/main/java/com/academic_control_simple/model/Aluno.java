package com.academic_control_simple.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    private final List<Disciplina> disciplinasMatriculadas = new ArrayList<>();

    public Aluno(String matricula, String nome, String email, String senha, Horario horario) {
        super(matricula, nome, email, senha, horario);
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinasMatriculadas.add(disciplina);
        disciplina.adicionarAluno(this);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinasMatriculadas;
    }
}
