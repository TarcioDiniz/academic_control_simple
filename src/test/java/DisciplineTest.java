import com.academic_control_simple.Entities.Discipline;
import com.academic_control_simple.Entities.SchoolTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class DisciplineTest {

    private Discipline discipline;

    @BeforeEach
    public void setUp() {
        discipline = new Discipline("Mathematics");
    }

    @Test
    public void testGetName() {
        assertEquals("Mathematics", discipline.getName());
    }

    @Test
    public void testSetName() {
        discipline.setName("Physics");
        assertEquals("Physics", discipline.getName());
    }

    @Test
    public void testGetMediaTests() {
        assertEquals(BigDecimal.ZERO, discipline.getMediaTests());
    }

    @Test
    public void testAddAndRemoveSchoolTest() {
        SchoolTest test = new SchoolTest(BigDecimal.valueOf(8.5));
        discipline.setSchoolTests(test);
        assertTrue(discipline.getSchoolTests().contains(test));
        discipline.removeSchoolTests(test.getId());
        assertFalse(discipline.getSchoolTests().contains(test));
    }
}
