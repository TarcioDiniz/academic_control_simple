package com.academic_control_simple.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RDM {
    private final Map<Aluno, Set<Disciplina>> matriculas = new HashMap<>();

    public void matricular(Aluno aluno, Disciplina disciplina) {
        matriculas.computeIfAbsent(aluno, k -> new HashSet<>()).add(disciplina);
        disciplina.adicionarAluno(aluno);
    }

    public Set<Disciplina> getDisciplinasDoAluno(Aluno aluno) {
        return matriculas.getOrDefault(aluno, new HashSet<>());
    }

    public Set<Aluno> getAlunosDaDisciplina(Disciplina disciplina) {
        Set<Aluno> alunos = new HashSet<>();
        for (Map.Entry<Aluno, Set<Disciplina>> entry : matriculas.entrySet()) {
            if (entry.getValue().contains(disciplina)) {
                alunos.add(entry.getKey());
            }
        }
        return alunos;
    }
}
