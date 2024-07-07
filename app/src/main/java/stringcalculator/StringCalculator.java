package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String numbers) {
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

                // setting value of ismultiplication based on * delimiter
                if(delimiter.equals("*")){
                    isMultiplication = true;
                }
                else {
                    delimiter = "[" + delimiter + "]";
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
}
