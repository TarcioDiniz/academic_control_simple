package com.academic_control_simple;

import com.academic_control_simple.model.Aluno;
import com.academic_control_simple.model.Disciplina;
import com.academic_control_simple.model.Horario;
import com.academic_control_simple.model.Professor;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Horario horarioMatutino = new Horario(LocalTime.of(8, 0), LocalTime.of(12, 0));

        List<Professor> professores = Arrays.asList(
                new Professor("P123", "Dra. Sabrina", "silva@universidade.com", "senha123", horarioMatutino),
                new Professor("P124", "Prof. Ana Costa", "ana@universidade.com", "senha456", horarioMatutino)
        );

        List<Aluno> alunos = Arrays.asList(
                new Aluno("A001", "Tarcio", "tarcio@email.com", "senha001", horarioMatutino),
                new Aluno("A002", "Maria", "maria@email.com", "senha002", horarioMatutino),
                new Aluno("A003", "Ronaldo", "ronaldo@email.com", "senha003", horarioMatutino)
        );

        List<Disciplina> disciplinas = Arrays.asList(
                new Disciplina("MAP"),
                new Disciplina("LEDA"),
                new Disciplina("Laboratório de Programação 2")
        );

        professores.get(0).adicionarDisciplina(disciplinas.get(0));
        professores.get(1).adicionarDisciplina(disciplinas.get(1));
        professores.get(1).adicionarDisciplina(disciplinas.get(2));

        alunos.forEach(aluno -> {
            aluno.adicionarDisciplina(disciplinas.get(0));
            aluno.adicionarDisciplina(disciplinas.get(2));
        });

        professores.forEach(prof -> {
            System.out.println("Professor: " + prof.getNome());
            System.out.println("Horário do professor: " + prof.getHorario().getHorarioCompleto());
            System.out.println("Disciplinas ministradas: " + prof.getDisciplinasMinistradas().stream().map(Disciplina::getNome).collect(Collectors.toList()));
            System.out.println("------------------------");
        });

        alunos.forEach(aluno -> {
            System.out.println("Aluno: " + aluno.getNome());
            System.out.println("Horário do aluno: " + aluno.getHorario().getHorarioCompleto());
            System.out.println("Disciplinas matriculadas: " + aluno.getDisciplinas().stream().map(Disciplina::getNome).collect(Collectors.toList()));
            System.out.println("------------------------");
        });

        disciplinas.forEach(disc -> System.out.println("Disciplina: " + disc.getNome() + " - Número de alunos: " + disc.getNumeroAlunos()));
    }
}