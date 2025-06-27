import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DemoTest {
    private Demo demo;

    @Before
    public void setUp() {
        // Setup method - runs before each test
        System.out.println("Setting up test...");
        demo = new Demo();
    }

    @After
    public void tearDown() {
        // Teardown method - runs after each test
        System.out.println("Cleaning up after test...");
        demo = null;
    }

    @Test
    public void addPos() {
        // Arrange
        int firstNumber = 2;
        int secondNumber = 3;
        int expectedResult = 5;
        
        // Act
        int actualResult = demo.add(firstNumber, secondNumber);
        
        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addNeg() {
        // Arrange
        int firstNumber = -5;
        int secondNumber = -3;
        int expectedResult = -8;
        
        // Act
        int actualResult = demo.add(firstNumber, secondNumber);
        
        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countTwoDigit() {
        // Arrange
        int inputNumber = 2413;
        int expectedDigitCount = 4;
        
        // Act
        int actualDigitCount = demo.cntDigits(inputNumber);
        
        // Assert
        assertEquals(expectedDigitCount, actualDigitCount);
    }

    @Test
    public void countZeroAsDigit() {
        // Arrange
        int inputNumber = 0;
        int expectedDigitCount = 1;
        
        // Act
        int actualDigitCount = demo.cntDigits(inputNumber);
        
        // Assert
        assertEquals(expectedDigitCount, actualDigitCount);
    }
}