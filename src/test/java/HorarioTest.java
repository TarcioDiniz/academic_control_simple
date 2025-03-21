import com.academic_control_simple.model.Horario;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HorarioTest {
    @Test
    void getHorarioCompletoDeveRetornarFormatoCorreto() {
        Horario horario = new Horario(LocalTime.of(8, 0), LocalTime.of(12, 0));
        assertEquals("08:00 - 12:00", horario.getHorarioCompleto());
    }
}

