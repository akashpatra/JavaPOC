package funprog.venkat.jetbrains;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Using Lambda, Method References, Predicates.
 * Find the double of first even number, greater than 3
 *
 * @author Akash Patra
 */
public class Problem {
    private static boolean isGreaterThan3(int number) {
        System.out.println("isGreaterThan3 " + number);
        return number > 3;
    }

    private static boolean isEven(int number) {
        System.out.println("isEven " + number);
        return number % 2 == 0;
    }

    private static int doubleIt(int number) {
        System.out.println("doubleIt " + number);
        return number * 2;
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

        // Imperative Approach
        /*int result = 0;
        for (Integer e : values) {
            if (e > 3 && e % 2 == 0) {
                result = e * 2;
                break;
            }
        }
        System.out.println(result);*/

        // Declarative Approach

        Predicate<Integer> isGreaterThan3 = number -> number > 3;

        Function<Integer, Predicate<Integer>> isGreaterThan = pivot ->
                number -> number > pivot;

        System.out.println(
                values.stream()
//                        .filter(e -> e > 3)
//                        .filter(e -> isGreaterThan3(e))
                        .filter(Problem::isGreaterThan3) // Using Method References, it is more expressive.
//                        .filter(isGreaterThan3) // Using Predicates.
//                        .filter(isGreaterThan.apply(3)) // Using Generic Function.
                        .filter(e -> e % 2 == 0)
//                        .filter(Problem::isEven)
                        .map(e -> e * 2)
//                        .map(Problem::doubleIt)
                        .findFirst()
                        .get());
    }
}
