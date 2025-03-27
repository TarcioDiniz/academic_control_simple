import com.academic_control_simple.Entities.AcademicControl;
import com.academic_control_simple.Entities.ClassGroup;
import com.academic_control_simple.Entities.Discipline;
import com.academic_control_simple.Entities.User;
import com.academic_control_simple.Enums.Day;
import com.academic_control_simple.Enums.Rules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AcademicControlTest {

    private AcademicControl academicControl;

    @BeforeEach
    public void setUp() {
        academicControl = new AcademicControl();
    }

    @Test
    public void testCreateUser() {
        User user = academicControl.createUser("John Doe", "password123", Rules.STUDENT);
        assertNotNull(user);
        assertEquals("John Doe", user.getFullName());
        assertEquals(Rules.STUDENT, user.getRule());
    }

    @Test
    public void testFindUserByUserId() {
        User user = academicControl.createUser("John Doe", "password123", Rules.STUDENT);
        assertNotNull(user);
        User foundUser = academicControl.findUserByUserId(user.getId());
        assertNotNull(foundUser);
        assertEquals(user.getId(), foundUser.getId());
    }

    @Test
    public void testCreateDiscipline() {
        Discipline discipline = academicControl.createDiscipline("Mathematics");
        assertNotNull(discipline);
        assertEquals("Mathematics", discipline.getName());
    }

    @Test
    public void testCreateClassGroup() {
        User user = academicControl.createUser("John Doe", "password123", Rules.TEACHER);
        Discipline discipline = academicControl.createDiscipline("Mathematics");
        ClassGroup classGroup = academicControl.createClassGroup(discipline.getId(), user.getId(), Day.MONDAY, LocalTime.of(8, 0));
        assertNotNull(classGroup);
        assertEquals(discipline, classGroup.getDiscipline());
        assertEquals(user, classGroup.getTeacher());
    }
}
