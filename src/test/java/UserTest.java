import com.academic_control_simple.Entities.User;
import com.academic_control_simple.Enums.Rules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User(UUID.randomUUID(), "John Doe", "password123", Rules.STUDENT);
    }

    @Test
    public void testGetId() {
        assertNotNull(user.getId());
    }

    @Test
    public void testGetFullName() {
        assertEquals("John Doe", user.getFullName());
    }

    @Test
    public void testGetPassword() {
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testGetRule() {
        assertEquals(Rules.STUDENT, user.getRule());
    }

    @Test
    public void testGetRDM() {
        assertNotNull(user.getRDM());
    }
}
