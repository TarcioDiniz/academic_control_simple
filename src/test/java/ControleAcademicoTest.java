import com.academic_control_simple.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class ControleAcademicoTest {

    @Test
    void criarProfessorDeveCriarProfessorCorretamente() {
        ControleAcademico controleAcademico = new ControleAcademico();
        Professor professor = controleAcademico.criarProfessor("P123", "Dr. Silva",  new Horario(LocalTime.of(8, 0), LocalTime.of(12, 0)));

        assertNotNull(professor);
        assertEquals("P123", professor.getMatricula());
        assertEquals("Dr. Silva", professor.getNome());
    }

    @Test
    void criarAlunoDeveCriarAlunoCorretamente() {
        ControleAcademico controleAcademico = new ControleAcademico();
        Aluno aluno = controleAcademico.criarAluno("A001", "Carlos",  new Horario(LocalTime.of(8, 0), LocalTime.of(12, 0)));

        assertNotNull(aluno);
        assertEquals("A001", aluno.getMatricula());
        assertEquals("Carlos", aluno.getNome());
    }

    @Test
    void criarDisciplinaDeveCriarDisciplinaCorretamente() {
        ControleAcademico controleAcademico = new ControleAcademico();
        Disciplina disciplina = controleAcademico.criarDisciplina("MAP");

        assertNotNull(disciplina);
        assertEquals("MAP", disciplina.getNome());
    }

    @Test
    void atribuirProfessorADisciplinaDeveAssociarProfessorCorretamente() {
        ControleAcademico controleAcademico = new ControleAcademico();
        Professor professor = controleAcademico.criarProfessor("P123", "Dr. Silva",  new Horario(LocalTime.of(8, 0), LocalTime.of(12, 0)));
        Disciplina disciplina = controleAcademico.criarDisciplina("Linguagem de Programação 2");

        controleAcademico.atribuirProfessorADisciplina(professor, disciplina);

        assertEquals(professor, disciplina.getProfessor());
        assertTrue(professor.getDisciplinasMinistradas().contains(disciplina));
    }

    @Test
    void matricularAlunoEmDisciplinaDeveAdicionarAlunoCorretamente() {
        ControleAcademico controleAcademico = new ControleAcademico();
        Aluno aluno = controleAcademico.criarAluno("A001", "Carlos",  new Horario(LocalTime.of(8, 0), LocalTime.of(12, 0)));
        Disciplina disciplina = controleAcademico.criarDisciplina("MAP");

        controleAcademico.matricularAlunoEmDisciplina(aluno, disciplina);

        System.out.println("Aluno's disciplines: " + aluno.getDisciplinas());
        System.out.println("Disciplina's matriculated students: " + disciplina.getAlunosMatriculados());

        assertTrue(aluno.getDisciplinas().stream().anyMatch(d -> d.getNome().equals("MAP")));
        assertTrue(disciplina.getAlunosMatriculados(). stream().anyMatch(a -> a.getMatricula().equals("A001")));
    }

    @Test
    void listarProfessoresDeveExibirInformacoesCorretamente() {
        ControleAcademico controleAcademico = new ControleAcademico();
        Professor professor = controleAcademico.criarProfessor("P123", "Dr. Silva",  new Horario(LocalTime.of(8, 0), LocalTime.of(12, 0)));
        Disciplina disciplina = controleAcademico.criarDisciplina("LEDA");
        controleAcademico.atribuirProfessorADisciplina(professor, disciplina);

        controleAcademico.listarProfessores();
    }

    @Test
    void listarAlunosDeveExibirInformacoesCorretamente() {
        ControleAcademico controleAcademico = new ControleAcademico();
        Aluno aluno = controleAcademico.criarAluno("A001", "Carlos",  new Horario(LocalTime.of(8, 0), LocalTime.of(12, 0)));
        Disciplina disciplina = controleAcademico.criarDisciplina("Linguagem de Programação 2");
        controleAcademico.matricularAlunoEmDisciplina(aluno, disciplina);

        controleAcademico.listarAlunos();
    }

    @Test
    void exibirDisciplinasDeveExibirInformacoesCorretamente() {
        ControleAcademico controleAcademico = new ControleAcademico();
        Disciplina disciplina = controleAcademico.criarDisciplina("LEDA");

        controleAcademico.exibirDisciplinas();
    }
}
