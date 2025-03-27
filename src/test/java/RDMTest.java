import com.academic_control_simple.Entities.Discipline;
import com.academic_control_simple.Entities.RDM;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RDMTest {

    private RDM rdm;
    private Discipline discipline;

    @BeforeEach
    public void setUp() {
        rdm = new RDM();
        discipline = new Discipline("Mathematics");
    }

    @Test
    public void testAddDiscipline() {
        rdm.addDiscipline(discipline);
        assertTrue(rdm.getDisciplines().contains(discipline));
    }

    @Test
    public void testRemoveDiscipline() {
        rdm.addDiscipline(discipline);
        rdm.removeDiscipline(discipline.getId());
        assertFalse(rdm.getDisciplines().contains(discipline));
    }

    @Test
    public void testGetDiscipline() {
        rdm.addDiscipline(discipline);
        assertEquals(discipline, rdm.getDiscipline(discipline.getId()));
    }
}
