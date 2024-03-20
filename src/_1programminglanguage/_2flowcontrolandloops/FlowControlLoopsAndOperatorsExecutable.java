package _1programminglanguage._2flowcontrolandloops;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class FlowControlLoopsAndOperatorsExecutable {

    public static final String NUMBER_PLACEHOLDER = "%d";
    public static final String STRING_PLACEHOLDER = "%s";
    public static final String NEW_LINE_PLACEHOLDER = "%n";

    public static void main(String[] args) {
        understandAdvancementsOfSwitchCase();
        largestOfThreeNumber(1, 2, 3);
        leapYear(2000);
        countTheDigits(-123);
        tablesOfANumber(3);
        printSquarePattern(5);
        printRightAngledTrianglePattern(5);
        printPyramidPattern(5);
        factorialOfANumber(5);
        factorialOfANumberByRecursion();
        gcdOfTwoNumbers(10, 15);
        lcmOfTwoNumbers(10, 15);
        allDivisorsOfANumber(15);
        checkPrimeNumber(7);
    }

    /**
     * A number is prime when the only divisors are one and itself
     * 1 is neither prime nor composite
     * 2 is the only even prime number
     * <p>
     * Naive Solution
     * --------------
     * If number is one change status variable to false
     * Else loop from 2 to number-1 and verify if any divide the number without remainder and exit the loop
     * Time Complexity - O(n)
     * <p>
     * Efficient Solution
     * ------------------
     * Divisors always occur in pair so looping from 2 to square root of n is enough to find a divisor
     * Time Complexity - O(square root of n)
     * <p>
     * More Efficient Solution
     * -----------------------
     * Simply by adding two check we can reduce the iterations even further
     * Verify if the number is divisible by 2 or 3 initially (except 2 and 3 themselves)
     * If not divisible by 2 and 3 then it's also not divisible by
     * 2 -> 4,6,8,10,12...
     * 3 -> 6,9,12,15,18...
     * So the remaining number to check are -> 5,7,11,13,17,19
     * It forms a series starting from 5 where the next two numbers differs by 2 and 6
     */
    private static void checkPrimeNumber(int number) {
        //Naive Solution
        boolean isPrime = true;
        if (number == 1) {
            isPrime = false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        System.out.println(isPrime ? "Prime number" : "Not a prime number");

        //Efficient Solution
        boolean isPrimeEfficient = true;
        if (number == 1) {
            isPrimeEfficient = false;
        } else {
            for (int i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    isPrimeEfficient = false;
                    break;
                }
            }
        }
        System.out.println(isPrimeEfficient ? "Prime number" : "Not a prime number");

        //More Efficient Solution

        boolean isPrimeMoreEfficient = true;
        if (number == 1) {
            isPrimeMoreEfficient = false;
        } else if (number != 2 && number != 3 && (number % 2 == 0 || number % 3 == 0)) {
            isPrimeMoreEfficient = false;
        } else {
            for (int i = 5; i * i <= number; i += 6) {
                if (number % i == 0 || number % (i + 2) == 0) {
                    isPrimeMoreEfficient = false;
                    break;
                }
            }
        }
        System.out.println(isPrimeMoreEfficient ? "Prime number" : "Not a prime number");

    }

    /**
     * Naive Solution
     * --------------
     * Iterate from one to n and the numbers that divide n without remainder are divisors
     * Time Complexity - O(n)
     * <p>
     * Efficient Solution
     * ------------------
     * Divisors of a number always occur in pair . EG: 30 -> (1, 30), (2, 15), (3, 10), (5, 6)
     * Any one value of the pair is always less than or equal (in case of perfect squares) to square root of n
     * x * y = n (Let x be smaller)
     * Then x * x <= n
     * x ^ 2 <= n
     * x <= square root of n
     * So looping from one to square root on n is enough
     * Time Complexity - O(square root of n)
     * <p>
     * Efficient Solution Orderly Print
     * --------------------------------
     * Two loops needed
     * One traverses from one (inclusive) to root n (exclusive)
     * Other traverses from root n (exclusive) to one (inclusive)
     *
     * @param number
     */
    private static void allDivisorsOfANumber(int number) {

        //Naive Solution
        StringBuilder divisors = new StringBuilder();
        IntStream.range(1, number + 1).forEach(num -> {
            if (number % num == 0) {
                divisors.append(num).append(" ");
            }
        });
        System.out.format("The divisors of " + NUMBER_PLACEHOLDER + " is " + STRING_PLACEHOLDER + NEW_LINE_PLACEHOLDER, number, divisors);

        //Efficient Solution
        StringBuilder divisorsEfficient = new StringBuilder();
        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                divisorsEfficient.append(i).append(" ");
                //No need to add same number twice for perfect square EG: 25 -> i = 5 case
                if (i != number / i) {
                    divisorsEfficient.append(number / i).append(" ");
                }
            }
        }
        System.out.format("The divisors of " + NUMBER_PLACEHOLDER + " is " + STRING_PLACEHOLDER + NEW_LINE_PLACEHOLDER, number, divisorsEfficient);

        //Efficient Solution Orderly Print
        StringBuilder divisorsEfficientOrderly = new StringBuilder();
        int i = 1;
        for (; i * i < number; i++) {
            if (number % i == 0) {
                divisorsEfficientOrderly.append(i).append(" ");
            }
        }
        for (; i >= 1; i--) {
            if (number % i == 0) {
                divisorsEfficientOrderly.append(number / i).append(" ");
            }
        }
        System.out.format("The divisors of " + NUMBER_PLACEHOLDER + " is " + STRING_PLACEHOLDER + NEW_LINE_PLACEHOLDER, number, divisorsEfficientOrderly);
    }

    /**
     * Find the max of two integers
     * Iterate from max(a, b) to a * b
     * The smallest number that gets divides both a, b is the LCM
     */
    private static void lcmOfTwoNumbers(int num1, int num2) {
        int max = Math.max(num1, num2);
        int lcm = num1 * num2;
        for (int i = max; i <= num1 * num2; i++) {
            if (i % num1 == 0 && i % num2 == 0) {
                lcm = i;
                break;
            }
        }
        System.out.format("LCM of two numbers is %d %n", lcm);
    }

    /**
     * Find the minimum of two integers
     * Iterate from 1 to min(a, b)
     * The largest number that divides both a, b is the GCD
     */
    private static void gcdOfTwoNumbers(int num1, int num2) {
        int min = Math.min(num1, num2);
        AtomicInteger gcd = new AtomicInteger(1);
        IntStream.range(1, min + 1).forEach(num -> {
            if (num1 % num == 0 && num2 % num == 0) {
                gcd.set(num);
            }
        });
        System.out.format("GCD of two numbers is %d %n", gcd.get());
    }

    private static void factorialOfANumberByRecursion() {
        System.out.format("Factorial of the given number is %d %n", factorialOfANumberByRecursion(5));
    }

    private static int factorialOfANumberByRecursion(int number) {
        if (number == 0) {
            return 1;
        } else {
            return number * factorialOfANumberByRecursion(number - 1);
        }
    }

    private static void factorialOfANumber(int number) {
        int factorial = 1;
        while (number > 0) {
            factorial = factorial * number;
            number--;
        }
        System.out.format("Factorial of the given number is %d %n", factorial);
    }

    /**
     * No of spaces to be printed in each row
     * (number of rows to be printed - current row number)
     * No of stars to be printed in each row
     * (2 * current row number) - 1
     */
    private static void printPyramidPattern(int number) {
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number - i; j++) {
                System.out.print("   ");
            }
            for (int k = 1; k <= (2 * i) - 1; k++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    private static void printRightAngledTrianglePattern(int number) {
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }

    private static void printSquarePattern(int number) {
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }

    private static void tablesOfANumber(int number) {
        StringBuilder tables = new StringBuilder();
        tables.append("The output table of given number ").append(number).append(" is ");
        IntStream.range(1, 11).forEach(index -> {
            tables.append(index * number);
            if (index != 10) {
                tables.append(", ");
            }
        });
        System.out.println(tables);
    }

    private static void countTheDigits(int number) {
        int noOfDigits = 0;
        number = Math.abs(number);
        if (number == 0) {
            System.out.println("No of digits in the given number is 1");
            return;
        }
        while (number > 0) {
            noOfDigits++;
            number = number / 10;
        }
        System.out.format("No of digits in the given number is %d %n", noOfDigits);
    }

    /**
     * Rules for finding a leap year
     * The year should be divisible by 4 and not by 100
     * OR
     * The year should be divisible by 400
     */
    private static void leapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.format("Yes, %d is a leap year %n", year);
        } else {
            System.out.format("No, %d is not a leap year %n", year);
        }

    }

    private static void largestOfThreeNumber(int a, int b, int c) {
        int largest = a > b ? Math.max(a, c) : Math.max(b, c);
        System.out.format("Largest of the 3 is %d %n", largest);
    }

    private static void understandAdvancementsOfSwitchCase() {
        // No need of break statement while using arrow
        switch ('1') {
            case '1', '2' -> System.out.println("Case 1 and 2");
            case '3', '4' -> {
                System.out.println("Case 3");
                System.out.println("or Case 4");
            }
        }

        // Switch can be used as an expression using yield
        // Default case is mandatory while using switch expression
        String returned = switch ("Hello") {
            case "Hello", "World" -> "Hey";
            default -> throw new IllegalStateException("Unexpected value: " + "Hello");
        };
        System.out.println(returned);
    }
}
