package java8.funcprog;

import java.util.Arrays;
import java.util.List;

/**
 * @author Akash Patra
 */
public class Streams {

    private static int doubleIt(int number) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number * 2;
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(
                values.parallelStream()
                        .mapToInt(Streams::doubleIt)
                        .sum());
    }
}
