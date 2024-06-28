package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void Add_EmptyString_ReturnsZero () {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("");
        assertEquals(0, result);
    }

    @Test
    void testAdd_SingleNumber_ReturnsNumber() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1");
        assertEquals(1, result);
    }

    @Test
    void testAdd_TwoNumbers_ReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1,5");
        assertEquals(6, result);
    }

    @Test
    void testAdd_NewLinesBetweenNumbers_ReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1\n2,3");
        assertEquals(6, result);
    }

    @Test
    void testAdd_CustomDelimiter_ReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//;\n1;2");
        assertEquals(3, result);
    }

    @Test
    void testAdd_NegativeNumber_ThrowsException() {
        StringCalculator calculator = new StringCalculator();

        try {
            calculator.add("1,-2,3");
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative numbers not allowed: [-2]", e.getMessage());
        }
    }
}
