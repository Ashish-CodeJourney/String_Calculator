# String Calculator TDD Kata

## Tips:
- Start with the simplest test case of an empty string and move to one and two numbers.
- Remember to solve problems in a simple manner so that you force yourself to write tests you did not think about.
- Remember to refactor after each passing test.

## Steps:
1. **Create a simple String calculator with a method signature like this:**
   ```java
   int add(String numbers)
   ```
   - Input: a string of comma-separated numbers.
   - Output: an integer, sum of the numbers.

2. **Examples:**
   - Input: `""`, Output: `0`
   - Input: `"1"`, Output: `1`
   - Input: `"1,5"`, Output: `6`
   - Allow the add method to handle any amount of numbers.

3. **Allow the add method to handle new lines between numbers (instead of commas).**
   - Example: `"1\n2,3"` should return `6`.

4. **Support different delimiters:**
   - To change the delimiter, the beginning of the string will contain a separate line that looks like this: `"//[delimiter]\n[numbers…]"`.
   - Example: `"//;\n1;2"` where the delimiter is `";"` should return `3`.

5. **Negative number handling:**
   - Calling `add` with a negative number will throw an exception: `"negative numbers not allowed <negative_number>"`.
   - If there are multiple negative numbers, show all of them in the exception message, separated by commas.

6. **Ignore numbers greater than 1000:**
   - Numbers greater than 1000 should be ignored in the sum calculation.
   - Example: `"2,1001"` should return `2`.
  
7. **Using `*` as delimiter return Multiplication :**
   - When you use `*` as delimiter it should return multiplication.
   - Example: `"//*\n3*2*5"` should return `30`.

8. **Delimiters of any length:**
   - Delimiters can be of any length if enclosed in square brackets.
   - Example: `"//[***]\n1***2***3"` where the delimiter is `"***"` should return `6`.
  
9. **Track how many times `add()` is invoked:**
    - Implement a method `getCalledCount()` that returns the number of times `add()` method was called.

10. **Support multiple delimiters:**
   - Allow multiple delimiters to be specified using square brackets.
   - Example: `"//[*][%]\n1*2%3"` should return `6`.

11. **Handle multiple delimiters with length longer than one character:**
   - Delimiters can also be longer than one character.
   - Example: `"//[**][%%]\n1**2%%3"` should return `6`.

Remember to follow the Test-Driven Development (TDD) cycle:
- Write a failing test.
- Write the simplest code to make it pass.
- Refactor the code while keeping all tests passing.
