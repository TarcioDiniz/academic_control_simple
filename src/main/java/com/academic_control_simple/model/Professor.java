package com.academic_control_simple.model;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario {
    private final List<Disciplina> disciplinasMinistradas = new ArrayList<>();

    public Professor(String matricula, String nome,  Horario horario) {
        super(matricula, nome,  horario);
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinasMinistradas.add(disciplina);
        disciplina.setProfessor(this);
    }

    public List<Disciplina> getDisciplinasMinistradas() {
        return disciplinasMinistradas;
    }
}