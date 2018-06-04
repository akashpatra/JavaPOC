package funprog.venkat.jetbrains;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Example on Dependency Injection. Take the values and total them.
 * Dependency Injection is a strategy pattern.
 *
 * @author Akash Patra
 */
public class DependencyInjection {

    interface Selector {
        boolean pick(int value);
    }

    /**
     * Strategy Pattern using interfaces
     *
     * @param values
     * @param selector
     * @return
     */
   /* public static int totalValues(List<Integer> values, Selector selector) {
        int result = 0;
        for (Integer e : values) {
            if (selector.pick(e)) {
                result += e;
            }
        }
        return result;
    }*/

    /**
     * Strategy Pattern using Predicates
     *
     * @param values
     * @param selector
     * @return
     */
    /*public static int totalValues(List<Integer> values, Predicate<Integer> selector) {
        int result = 0;
        for (Integer e : values) {
            if (selector.test(e)) {
                result += e;
            }
        }
        return result;
    }*/

    /**
     * Strategy Pattern using Lambdas
     *
     * @param values
     * @param selector
     * @return
     */
    public static int totalValues(List<Integer> values, Predicate<Integer> selector) {
        return values.stream()
                .filter(selector)
                .reduce(0, Math::addExact);
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

        System.out.println(totalValues(values, e -> true)); // For all values
        System.out.println(totalValues(values, e -> e % 2 == 0)); // For even values
    }
}

