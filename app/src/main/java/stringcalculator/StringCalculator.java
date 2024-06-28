package stringcalculator;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(numbers); // implementation to pass `testAdd_SingleNumber_ReturnsNumber` test
    }

}
