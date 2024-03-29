package _1programminglanguage._1variablesandoperators;

import java.util.Scanner;
import java.util.logging.Logger;

public class VariablesAndOperatorsExecutable {
    private static final Logger LOGGER = Logger.getLogger(VariablesAndOperatorsExecutable.class.getName());

    public static void main(String[] args) {
        swapTwo(10, 20);
        //understandInputs();
        understandAutoBoxingAndUnboxing();
        understandEscapeSequence();
        understandDivisionAndPreciseFormat();
        understandBitwise();
        nthTermOfAnArithmeticSequence(1, 2, 4);
        nthTermOfAGeometricSequence(1, 2, 4);
        sumOfNNaturalNumbers(3);
        lastDigitOfANumber(123);
        findEvenOrOddWithoutModulo(2);
        dayBeforeNDays(2, 4);
    }

    /**
     * Given two integers d and n. Where d is the day, out of 7 days of the week, d varies from 0 to 6 as shown below
     * 0 - Sunday
     * 1 - Monday
     * 2 - Tuesday
     * 3 - Wednesday
     * 4 - Thursday
     * 5 - Friday
     * 6 - Saturday
     * You have to print the index for the day which is n days before the given day d.
     *
     * @param d - index of day
     * @param n - no of days to reduce
     */
    public static void dayBeforeNDays(int d, int n) {
        //Naive Solution
        int minus = d - n;
        if (minus >= 0) {
            LOGGER.info(String.format("%d days before the %d day is : %d", n, d, minus));
        } else if (minus >= -7) {
            LOGGER.info(String.format("%d days before the %d day is : %d", n, d, 7 + minus));
        } else {
            int modulo = minus % 7;
            LOGGER.info(String.format("%d days before the %d day is : %d", n, d, 7 + modulo));
        }

        // Efficient
        int x = n % 7;
        int ans = d - x;
        if (ans >= 0) {
            LOGGER.info(String.format("%d days before the %d day is : %d", n, d, ans));
        } else {
            LOGGER.info(String.format("%d days before the %d day is : %d", n, d, ans + 7));
        }
    }

    /**
     * We can find whether the given number is even or odd using BITWISE AND with 1
     * Thumb rule is the last bit on an int is 1 then its odd number
     */
    public static void findEvenOrOddWithoutModulo(int n) {
        if ((n & 1) == 0) {
            LOGGER.info(String.format("Number %d is Even Number.", n));
        } else {
            LOGGER.info(String.format("Number %d is Odd Number.", n));
        }
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
     * Bitwise operator operates on the binary form of the elements
     * & - AND - Gives 1 when both are 1 - Eg: 1 & 2 = 0
     * | - OR - Gives 1 when anyone is 1 - Eg: 1 | 2 = 3
     * ~ - NOT - Inverts 1 to 0 and 0 to 1 - Eg: ~1 = -2
     * ^ - XOR - Gives 1 when both are different 0 when both are same - Eg: 2 ^ 1 = 3
     * >> - RIGHT SHIFT - Right shifts the given binary number by specified times and fills zero for voids when +ve
     * and ones for voids when negative, sign digit is maintained the same as the element - Eg: -8>>1 = -4
     * << - LEFT SHIFT - Left shifts the given binary number by specified times and appends zero to the end - Eg:
     * -8<<1 = -16
     * >>> - UNSIGNED RIGHT SHIFT - Right shifts the given binary number by specified times and appends zero to the
     * front - Eg: -8>>>1 = 2147483644
     * Explanation of ~1
     * ------------------
     * In Java -ve numbers are stored in 2's complement form
     * 1's binary form  000..001
     * ~1's binary form 111..110 -> required answer
     * Representation of -x = 2^32 - x
     * 2^32 - 1 = 32 ones - binary form
     * 2^3 - 1 = 111 - binary form
     * 111..110 = 2^32 -1 -1 = 2^32 - 2 -> value of ~1 = -2
     */
    public static void understandBitwise() {
        LOGGER.info(String.format("Bitwise AND of 1 and 2 is %d", 1 & 2));
        LOGGER.info(String.format("Bitwise OR of 1 and 2 is %d", 1 | 2));
        LOGGER.info(String.format("Bitwise XOR of 1 and 2 is %d", 1 ^ 2));
        LOGGER.info(String.format("Bitwise NOT of 1 is %d", ~1));
        LOGGER.info(String.format("Bitwise RIGHT SHIFT of -8 by 1 is %d", -8 >> 1));
        LOGGER.info(String.format("Bitwise UNSIGNED RIGHT SHIFT of -8 by 1 is %d", -8 >>> 1));
        LOGGER.info(String.format("Bitwise LEFT SHIFT of -8 by 1 is %d", -8 << 1));
    }

    /**
     * If both the quotient and divisor are non-decimal the output is non-decimal
     * If any one or both are decimal then the output is that decimal type
     * For format of precision %.Yf or %X.Yf is used
     * X - total no of characters including the ones after decimal point and the decimal point
     * Y - total no of characters after decimal point
     * %0X.Yf can be used if we want to prepend 0 instead on blank space
     */
    public static void understandDivisionAndPreciseFormat() {
        int intDivision = 10 / 3;
        LOGGER.info(String.format("The value of 10/3 is %d", intDivision));
        double oneDoubleDivision = 10.0 / 3;
        LOGGER.info(String.format("The value of 10.0/3 is %f", oneDoubleDivision));
        double bothDoubleDivision = 10.0 / 3.0;
        LOGGER.info(String.format("The value of 10.0/3.0 is %f", bothDoubleDivision));
        LOGGER.info(String.format("The value of 5.2f formatted 10.0/3.0 division is %5.2f", bothDoubleDivision));
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
     * Scanner has a separate method the capture all the number types individually, and nextLine method to capture
     * string as input
     */
    public static void understandInputs() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextByte();
        scanner.nextShort();
        scanner.nextInt();
        scanner.nextLong();
        scanner.nextFloat();
        scanner.nextDouble();
        scanner.nextBigDecimal();
        scanner.nextBigInteger();
        scanner.nextLine(); // Captures a sentence
        scanner.next(); // Captures only a word
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
        LOGGER.info(String.format("Values after swap | Value of A :  %s  B : %s", valueA, valueB));
    }
}
