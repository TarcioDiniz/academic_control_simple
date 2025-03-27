import com.academic_control_simple.Entities.SchoolTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class SchoolTestTest {

    private SchoolTest schoolTest;

    @BeforeEach
    public void setUp() {
        schoolTest = new SchoolTest(BigDecimal.valueOf(9.5));
    }

    @Test
    public void testGetScore() {
        assertEquals(BigDecimal.valueOf(9.5), schoolTest.getScore());
    }

    @Test
    public void testGetId() {
        assertNotNull(schoolTest.getId());
    }
}
