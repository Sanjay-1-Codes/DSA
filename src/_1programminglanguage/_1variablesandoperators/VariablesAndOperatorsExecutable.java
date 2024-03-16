package _1programminglanguage._1variablesandoperators;

import java.util.logging.Logger;

public class VariablesAndOperatorsExecutable {
    private static final Logger LOGGER = Logger.getLogger(VariablesAndOperatorsExecutable.class.getName());

    public static void main(String[] args) {
        swapTwo(10, 20);
        understandAutoBoxingAndUnboxing();
        understandEscapeSequence();
        nthTermOfAnArithmeticSequence(1, 2, 4);
        nthTermOfAGeometricSequence(1, 2, 4);
        sumOfNNaturalNumbers(3);
        lastDigitOfANumber(123);
    }

    public static void lastDigitOfANumber(int n) {
        int absoluteValue = Math.abs(n);
        int lastDigit = absoluteValue % 10;
        LOGGER.info(String.format("The last digit of the provided input : %d %n", lastDigit));
    }

    // Formula : (n * (n+1)) / 2
    public static void sumOfNNaturalNumbers(int n) {
        int requiredValue = (n * (n + 1)) / 2;
        LOGGER.info(String.format("Sum of first %d natural numbers : %d %n", n, requiredValue));
    }

    // Formula : ar ^ (n-1)
    public static void nthTermOfAGeometricSequence(int start, int ratio, int n) {
        int requiredValue = start * (int) Math.pow(ratio, n - 1);
        LOGGER.info(String.format("Required nth term of the series : " + requiredValue));
    }

    // Formula : a + ((n-1) * d)
    public static void nthTermOfAnArithmeticSequence(int start, int diff, int n) {
        int requiredValue = start + ((n - 1) * diff);
        LOGGER.info(String.format("Required nth term of the series : " + requiredValue));
    }

    /**
     * Backslash - \  | plays an important role in escape sequence
     * Backslash followed by certain character makes them escape sequence
     * \' - to escape single quotes in a string
     * \" - to escape double quotes in a string
     * \n - to have a new line
     * \t - to have a tab space
     * \b - to have a backspace
     * \r - to have a carriage return
     * \f - to have form feed
     * \\ - to have a backslash
     */
    public static void understandEscapeSequence() {
        LOGGER.info("Welcome to \"Spartan's World\"");
        LOGGER.info("C:\\xyz\\abc.txt");
    }


    /**
     * Auto boxing and unboxing takes places only when one type is primitive and other type is object, in the below
     * example both are objects and are compared with == in this case unboxing doesn't happen, but the below code may
     * produce same as output for smaller numbers since the buffer values are returned for small numbers which points
     * to same reference
     */
    public static void understandAutoBoxingAndUnboxing() {
        Integer value1 = Integer.valueOf(1000);
        Integer value2 = Integer.valueOf(1000);
        if (value1 == value2) {
            LOGGER.info("Same");
        } else {
            LOGGER.info("Different");
        }
    }

    /**
     * When we pass a primitive type autoboxing takes place
     *
     * @param valueA
     * @param valueB
     */
    public static <T> void swapTwo(T valueA, T valueB) {
        T tempValue = valueA;
        valueA = valueB;
        valueB = tempValue;
        LOGGER.info(String.format("Values after swap | Value of A : " + valueA + " B : " + valueB));
    }
}
