import com.academic_control_simple.Entities.ClassGroup;
import com.academic_control_simple.Entities.Discipline;
import com.academic_control_simple.Entities.User;
import com.academic_control_simple.Enums.Day;
import com.academic_control_simple.Enums.Rules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.UUID;

public class ClassGroupTest {

    private ClassGroup classGroup;
    private User teacher;
    private Discipline discipline;

    @BeforeEach
    public void setUp() {
        teacher = new User(UUID.randomUUID(), "John Doe", "password123", Rules.TEACHER);
        discipline = new Discipline("Mathematics");
        classGroup = new ClassGroup(discipline, teacher, Day.MONDAY, LocalTime.of(8, 0), LocalTime.of(10, 0));
    }

    @Test
    public void testGetId() {
        assertNotNull(classGroup.getId());
    }

    @Test
    public void testGetDiscipline() {
        assertEquals(discipline, classGroup.getDiscipline());
    }

    @Test
    public void testGetTeacher() {
        assertEquals(teacher, classGroup.getTeacher());
    }

    @Test
    public void testAddStudent() {
        User student = new User(UUID.randomUUID(), "Jane Doe", "password456", Rules.STUDENT);
        classGroup.addStudent(student);
        assertTrue(classGroup.getStudents().contains(student));
    }
}
