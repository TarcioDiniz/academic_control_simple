import com.academic_control_simple.model.Aluno;
import com.academic_control_simple.model.Disciplina;
import com.academic_control_simple.model.Horario;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlunoTest {
    @Test
    void adicionarDisciplinaDeveAdicionarCorretamente() {
        Aluno aluno = new Aluno("A001", "João", "joao@email.com", "senha001", new Horario(LocalTime.of(8, 0), LocalTime.of(12, 0)));
        Disciplina disciplina = new Disciplina("Matemática");

        aluno.adicionarDisciplina(disciplina);
        assertTrue(aluno.getDisciplinas().contains(disciplina));
        assertTrue(disciplina.getAlunosMatriculados().contains(aluno));
    }
}
