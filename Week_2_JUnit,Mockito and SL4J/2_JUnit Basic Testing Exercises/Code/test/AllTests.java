package advjunittestingexercise;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
	EvenCheckerTest.class,
	AssertChecker.class
})

public class AllTests {
	
}