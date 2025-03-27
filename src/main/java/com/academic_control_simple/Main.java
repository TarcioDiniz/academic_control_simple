package com.academic_control_simple;

import com.academic_control_simple.model.*;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ControleAcademico controle = new ControleAcademico();

        Horario horarioMatutino = new Horario(LocalTime.of(8, 0), LocalTime.of(12, 0));

        Professor professor1 = controle.criarProfessor("P1234", "Dra. Sabrina",  horarioMatutino);
        Professor professor2 = controle.criarProfessor("P124", "Prof. Ana Costa",  horarioMatutino);

        Aluno aluno1 = controle.criarAluno("A001", "Tarcio",  horarioMatutino);
        Aluno aluno2 = controle.criarAluno("A002", "Maria",  horarioMatutino);
        Aluno aluno3 = controle.criarAluno("A003", "Ronaldo",  horarioMatutino);

        Disciplina disciplina1 = controle.criarDisciplina("MAP");
        Disciplina disciplina2 = controle.criarDisciplina("LEDA");
        Disciplina disciplina3 = controle.criarDisciplina("Laboratório de Programação 2");

        controle.atribuirProfessorADisciplina(professor1, disciplina1);
        controle.atribuirProfessorADisciplina(professor2, disciplina2);
        controle.atribuirProfessorADisciplina(professor2, disciplina3);

        controle.matricularAlunoEmDisciplina(aluno1, disciplina1);
        controle.matricularAlunoEmDisciplina(aluno1, disciplina2);
        controle.matricularAlunoEmDisciplina(aluno2, disciplina1);
        controle.matricularAlunoEmDisciplina(aluno2, disciplina3);
        controle.matricularAlunoEmDisciplina(aluno3, disciplina1);
        controle.matricularAlunoEmDisciplina(aluno3, disciplina3);

        controle.listarProfessores();
        controle.listarAlunos();
        controle.exibirDisciplinas();
    }
}