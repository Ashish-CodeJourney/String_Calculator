package stringcalculator;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n"; // comma and new line are default delimiters
        String numbersWithoutDelimiter = numbers;

        // implementation to pass `testAdd_CustomDelimiter_ReturnsSum` test
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbersWithoutDelimiter = numbers.substring(delimiterIndex + 1);
        }

        // implementation to pass `testAdd_SingleNumber_ReturnsNumber` test
        // Split numbers by comma or new line and calculate sum for `testAdd_NewLinesBetweenNumbers_ReturnsSum` test
        String[] nums = numbersWithoutDelimiter.split(delimiter);

        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num.trim());
        }

        return sum;
    }
}
