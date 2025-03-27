package com.academic_control_simple.model;

import com.academic_control_simple.model.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ControleAcademico {
    private final List<Professor> professores = new ArrayList<>();
    private final List<Aluno> alunos = new ArrayList<>();
    private final List<Disciplina> disciplinas = new ArrayList<>();
    private final RDM rdm = new RDM();

    public Professor criarProfessor(String matricula, String nome,  Horario horario) {
        Professor professor = new Professor(matricula, nome, horario);
        professores.add(professor);
        return professor;
    }

    public Aluno criarAluno(String matricula, String nome, Horario horario) {
        Aluno aluno = new Aluno(matricula, nome, horario);
        alunos.add(aluno);
        return aluno;
    }

    public Disciplina criarDisciplina(String nome) {
        Disciplina disciplina = new Disciplina(nome);
        disciplinas.add(disciplina);
        return disciplina;
    }

    public void matricularAlunoEmDisciplina(Aluno aluno, Disciplina disciplina) {
        rdm.matricular(aluno, disciplina);
    }

    public void atribuirProfessorADisciplina(Professor professor, Disciplina disciplina) {
        professor.adicionarDisciplina(disciplina);
    }

    public void listarProfessores() {
        for (Professor p : professores) {
            System.out.println("Professor: " + p.getNome());
            System.out.println("Horário: " + p.getHorario().getHorarioCompleto());
            System.out.println("Disciplinas: " + p.getDisciplinasMinistradas());
            System.out.println("------------------------");
        }
    }

    public void listarAlunos() {
        for (Aluno aluno : alunos) {
            System.out.println("Aluno: " + aluno.getNome());
            System.out.println("Horário: " + aluno.getHorario().getHorarioCompleto());
            System.out.println("Disciplinas: " + rdm.getDisciplinasDoAluno(aluno));
            System.out.println("------------------------");
        }
    }

    public void exibirDisciplinas() {
        disciplinas.forEach(disciplina -> {
            System.out.println("Disciplina: " + disciplina.getNome() + " - Número de alunos: " + rdm.getAlunosDaDisciplina(disciplina).size());
        });
    }

    public RDM getRDM() {
        return rdm;
    }
}
