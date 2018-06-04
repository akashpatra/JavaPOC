package funprog.techprimers;

import java.util.Arrays;
import java.util.List;

/**
 * Print all names except Sam using @link{filter} and @link{forEach}
 *
 * @author Akash Patra
 */
public class FilterExample {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Peter", "Sam", "Greg", "Ryan");

        System.out.println("Imperative Style");

        for (String name : names) {
            if (isNotSam(name)) {
                System.out.println(name);
            }
        }

        System.out.println("\nFunctional Style");

        names.stream()
                .filter(FilterExample::isNotSam)
                .forEach(System.out::println);
    }

    private static boolean isNotSam(String name) {
        return !"Sam".equals(name);
    }
}
