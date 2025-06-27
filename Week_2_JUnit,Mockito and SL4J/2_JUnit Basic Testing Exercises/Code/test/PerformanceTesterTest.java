package advjunittestingexercise;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.Test;

public class PerformanceTesterTest {
	 @Test
	    void testPerformTaskCompletesWithinTimeLimit() {
	        PerformanceTester tester = new PerformanceTester();

	        assertTimeout(Duration.ofMillis(500), tester::performTask);
	    }

	    @Test
	    void testFailsIfExceedsTimeLimit() {
	        PerformanceTester tester = new PerformanceTester();

	        assertTimeout(Duration.ofMillis(100), () -> tester.performTask());
	    }
}