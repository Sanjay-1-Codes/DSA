package programminglanguage._1variablesandoperators;

public class VariablesAndOperatorsExecutable {
    public static void main(String[] args) {
        swapTwo(10, 20);
        understandAutoBoxingAndUnboxing();
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
            System.out.println("Same");
        } else {
            System.out.println("Different");
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
        System.out.println("Values after swap | Value of A : " + valueA + " B : " + valueB);
    }
}
