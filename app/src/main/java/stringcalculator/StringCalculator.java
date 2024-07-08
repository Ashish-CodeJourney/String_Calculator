package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private int callCount = 0;

    public int add(String numbers) {
        callCount++;
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n"; // comma and new line are default delimiters
        String numbersWithoutDelimiter = numbers;
        Boolean isMultiplication = false;

        // implementation to pass `testAdd_CustomDelimiter_ReturnsSum` test
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            if (delimiterIndex != -1) {
                delimiter = numbers.substring(2, delimiterIndex);
                numbersWithoutDelimiter = numbers.substring(delimiterIndex + 1);

                // handling delimiters of any length
                if (delimiter.startsWith("[") && delimiter.endsWith("]")) {
                    delimiter = delimiter.substring(1, delimiter.length() - 1);
                    String[] delimiters = delimiter.split("\\]\\[");
                    StringBuilder delimiterRegex = new StringBuilder();
                    for (String delim : delimiters) {
                        delimiterRegex.append(java.util.regex.Pattern.quote(delim)).append("|");
                    }
                    delimiter = delimiterRegex.toString();
                    delimiter = delimiter.substring(0, delimiter.length() - 1); // remove last "|"
                } else if (delimiter.equals("*")) {
                    isMultiplication = true;
                    delimiter = "\\*";
                } else {
                    delimiter = java.util.regex.Pattern.quote(delimiter); // quoting the delimiter for regex
                }
            } else {
                throw new IllegalArgumentException("Invalid input format for custom delimiter");
            }
        }
        // implementation to pass `testAdd_SingleNumber_ReturnsNumber` test
        // Split numbers by comma or new line and calculate sum for `testAdd_NewLinesBetweenNumbers_ReturnsSum` test
        String[] nums;

        if(isMultiplication) {
            nums = numbersWithoutDelimiter.split("\\*");
        }
        else {
            nums = numbersWithoutDelimiter.split(delimiter);
        }


        int sum = isMultiplication ? 1 : 0;
        List<Integer> negatives = new ArrayList<>();

        // implementation to pass `testAdd_NegativeNumber_ThrowsException` test
        for (String num : nums) {
            int n = Integer.parseInt(num.trim());
            if (n < 0) {
                negatives.add(n);
            }
            else if (isMultiplication) {
                sum *= n;
            }
            else if (n <= 1000) { // Check if number is less than or equal to 1000
                sum += n;
            }
        }

        // Throwing exception for negative numbers
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }

        return sum;
    }

    // Method to return the number of times add() has been called
    public int getCalledCount() {
        return callCount;
}
}