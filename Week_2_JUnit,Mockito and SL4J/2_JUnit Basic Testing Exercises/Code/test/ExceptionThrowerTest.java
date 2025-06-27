package advjunittestingexercise;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ExceptionThrowerTest {
	@Test
    void testThrowsIllegalArgumentException() {
        ExceptionThrower thrower = new ExceptionThrower();

        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            thrower::throwException
        );

        assertTrue(
            ex.getMessage().contains("advjunittestingexercise.ExceptionThrower"),
            "Exception message should contain class name"
        );
    }
}