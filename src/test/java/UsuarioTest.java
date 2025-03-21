import com.academic_control_simple.model.Aluno;
import com.academic_control_simple.model.Horario;
import com.academic_control_simple.model.Professor;
import com.academic_control_simple.model.Usuario;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {
    @Test
    void usuarioDeveRetornarNomeCorreto() {
        Usuario usuario = new Aluno("A005", "Carlos", "carlos@email.com", "senha005", new Horario(LocalTime.of(13, 0), LocalTime.of(17, 0)));
        assertEquals("Carlos", usuario.getNome());
    }

    @Test
    void usuarioDeveRetornarHorarioCorreto() {
        Horario horario = new Horario(LocalTime.of(13, 0), LocalTime.of(17, 0));
        Usuario usuario = new Professor("P126", "Prof. Ana", "ana@universidade.com", "senha789", horario);
        assertEquals(horario, usuario.getHorario());
    }
}
