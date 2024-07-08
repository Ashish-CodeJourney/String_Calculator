package stringcalculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setup() {
        calculator = new StringCalculator();
    }

    @Test
    void Add_EmptyString_ReturnsZero() {
        int result = calculator.add("");
        assertEquals(0, result);
    }

    @Test
    void testAdd_SingleNumber_ReturnsNumber() {
        int result = calculator.add("1");
        assertEquals(1, result);
    }

    @Test
    void testAdd_TwoNumbers_ReturnsSum() {
        int result = calculator.add("1,5");
        assertEquals(6, result);
    }

    @Test
    void testAdd_NewLinesBetweenNumbers_ReturnsSum() {
        int result = calculator.add("1\n2,3");
        assertEquals(6, result);
    }

    @Test
    void testAdd_CustomDelimiter_ReturnsSum() {
        int result = calculator.add("//;\n1;2");
        assertEquals(3, result);
    }

    @Test
    void testAdd_NegativeNumber_ThrowsException() {
        try {
            calculator.add("1,-2,3");
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative numbers not allowed: [-2]", e.getMessage());
        }
    }

    @Test
    void testAdd_IgnoreNumbersGreaterThan1000_ReturnsSum() {
        int result = calculator.add("2,1001");
        assertEquals(2, result);
    }

    @Test
    void testAdd_StarAsDelimiter_ReturnsMul() {
        int result = calculator.add("//*\n3*2*5");
        assertEquals(30, result);
    }

    @Test
    void testAdd_DelimiterOfAnyLength_ReturnsSum() {
        int result = calculator.add("//[***]\n1***2***3");
        assertEquals(6, result);
    }

    @Test
    void testAdd_GetCalledCount() {
        calculator.add("1,2,3");
        calculator.add("4,5");
        calculator.add("6");

        assertEquals(3, calculator.getCalledCount());
    }

    @Test
    void testAdd_MultipleDelimiters_ReturnsSum() {
        int result = calculator.add("//[*][%]\n1*2%3");
        assertEquals(6, result);
    }

    @Test
    void testAdd_MultipleDelimitersOfAnyLength_ReturnsSum() {
        int result = calculator.add("//[**][%%]\n1**2%%3");
        assertEquals(6, result);
    }

}
