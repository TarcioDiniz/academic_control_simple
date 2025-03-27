import com.academic_control_simple.model.Aluno;
import com.academic_control_simple.model.Disciplina;
import com.academic_control_simple.model.Horario;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisciplinaTest {
    @Test
    void adicionarAlunoDeveMatricularAluno() {
        Disciplina disciplina = new Disciplina("História");
        Aluno aluno = new Aluno("A002", "Maria",  new Horario(LocalTime.of(13, 0), LocalTime.of(17, 0)));

        disciplina.adicionarAluno(aluno);
        assertTrue(disciplina.getAlunosMatriculados().contains(aluno));
    }

    @Test
    void getNumeroAlunosDeveRetornarQuantidadeCorreta() {
        Disciplina disciplina = new Disciplina("Programação Java");
        disciplina.adicionarAluno(new Aluno("A003", "Pedro",  new Horario(LocalTime.of(18, 0), LocalTime.of(22, 0))));
        disciplina.adicionarAluno(new Aluno("A004", "Luiza",  new Horario(LocalTime.of(8, 0), LocalTime.of(12, 0))));

        assertEquals(2, disciplina.getNumeroAlunos());
    }
}