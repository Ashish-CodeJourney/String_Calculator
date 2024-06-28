package stringcalculator;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        // implementation to pass `testAdd_SingleNumber_ReturnsNumber` test
        String[] nums = numbers.split(",");
        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}
