package advjunittestingexercise;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenCheckerTest {
	private final EvenChecker evenChecker = new EvenChecker();
	
	@ParameterizedTest
	@ValueSource(ints = {2, 4, 6, 0, -2, -8})
    void testEvenNumbers(int input) {
        assertTrue(evenChecker.isEven(input), input + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -1, -3, 7})
    void testOddNumbers(int input) {
        assertFalse(evenChecker.isEven(input), input + " should be odd");
    }
}