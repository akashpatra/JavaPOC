package java8.funcprog;

import java.util.Arrays;
import java.util.List;

/**
 * Example on Dependency Injection. Take the values and total them.
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
    public static int totalValues(List<Integer> values, Selector selector) {
        int result = 0;
        for (Integer e : values) {
            if (selector.pick(e)) {
                result += e;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

        System.out.println(totalValues(values, e -> true)); // For all values
        System.out.println(totalValues(values, e -> e % 2 == 0)); // For even values
    }
}

