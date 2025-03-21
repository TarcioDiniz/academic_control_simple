import com.academic_control_simple.model.Disciplina;
import com.academic_control_simple.model.Horario;
import com.academic_control_simple.model.Professor;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfessorTest {
    @Test
    void adicionarDisciplinaDeveAtribuirProfessor() {
        Professor professor = new Professor("P123", "Dr. Silva", "silva@universidade.com", "senha123", new Horario(LocalTime.of(8, 0), LocalTime.of(12, 0)));
        Disciplina disciplina = new Disciplina("Física");

        professor.adicionarDisciplina(disciplina);
        assertTrue(professor.getDisciplinasMinistradas().contains(disciplina));
        assertEquals(professor, disciplina.getProfessor());
    }
}