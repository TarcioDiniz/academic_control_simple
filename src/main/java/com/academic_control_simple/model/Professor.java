package com.academic_control_simple.model;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario {
    private final List<Disciplina> disciplinasMinistradas = new ArrayList<>();

    public Professor(String matricula, String nome, String email, String senha, Horario horario) {
        super(matricula, nome, email, senha, horario);
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinasMinistradas.add(disciplina);
        disciplina.setProfessor(this);
    }

    public List<Disciplina> getDisciplinasMinistradas() {
        return disciplinasMinistradas;
    }
}