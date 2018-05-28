package java8.funcprog;

import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Difference between Imperative & Declarative.
 *
 * @author Akash Patra
 */
public class Prime {
    public static void main(String[] args) {
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
    }

    private static boolean isPrime(final int number) {
        // imperative - saying how
        // mutability
//        for (int i = 2; i < number; i++) {
//            if (number % i == 0) {
//                return false;
//            }
//        }
//        return number > 1;

        // declarative - what
        // immutability
        Predicate<Integer> isDivisible = divisor -> number % divisor == 0;

        return number > 1 &&
                IntStream.range(2, number)
                        .noneMatch(index -> number % index == 0);
    }
}
