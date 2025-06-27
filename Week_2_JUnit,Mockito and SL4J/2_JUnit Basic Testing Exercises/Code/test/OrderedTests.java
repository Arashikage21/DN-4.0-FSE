package advjunittestingexercise;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {
private final EvenChecker evenChecker = new EvenChecker();
	
	@Order(2)
	@ParameterizedTest
	@ValueSource(ints = {2, 4, 6, 0, -2, -8})
    void testEvenNumbers(int input) {
		System.out.println("Test Even Numbers");
        assertTrue(evenChecker.isEven(input), input + " should be even");
    }

	@Order(1)
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -1, -3, 7})
    void testOddNumbers(int input) {
		System.out.println("Test Odd Numbers");
        assertFalse(evenChecker.isEven(input), input + " should be odd");
    }
}