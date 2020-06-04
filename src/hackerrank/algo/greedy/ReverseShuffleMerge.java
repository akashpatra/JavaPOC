package hackerrank.algo.greedy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Akash Patra
 * @link https://www.hackerrank.com/challenges/reverse-shuffle-merge/problem
 * <p>
 * Explanation:
 * https://www.hackerrank.com/challenges/reverse-shuffle-merge/forum/comments/79730
 * <p>
 * Examples for easy understanding:
 * https://www.hackerrank.com/challenges/reverse-shuffle-merge/forum/comments/618410
 * <p>
 * Test Cases:
 * https://www.hackerrank.com/challenges/reverse-shuffle-merge/forum/comments/741092
 */
public class ReverseShuffleMerge {

    private static HashMap<Character, Integer> leftChars;
    private static HashMap<Character, Integer> neededChars;
    private static HashMap<Character, Integer> skippedChars;

    static String reverseShuffleMerge(String s) {
        // forget about reverse - now merge is done on original string and its shuffle
        s = new StringBuilder(s).reverse().toString();

        StringBuilder sb = new StringBuilder();
        createLeftChars(s);
        createNeededChars();
        int lastIndex = -1;
        int currentIndex;
        char currentChar;
        int bestIndex;
        char bestChar;
        while (sb.length() < s.length() / 2) {
            skippedChars = new HashMap();
            currentIndex = lastIndex + 1;
            bestIndex = lastIndex;
            bestChar = '{';

            // Find the best character lexicographically in a range. The range end point is the index where you can't skip the character
            do {
                currentChar = s.charAt(currentIndex);
                if (neededChars.get(currentChar) > 0 && currentChar < bestChar) {
                    bestChar = currentChar;
                    bestIndex = currentIndex;
                }
                skipChar(currentChar);
                currentIndex++;
            } while (canBeSkipped(currentChar));

            sb.append(bestChar);

            // Decrease the characters count in the range from the Left Characters Map
            for (int i = lastIndex + 1; i <= bestIndex; i++) {
                leftChars.compute(s.charAt(i), (key, value) -> value - 1);
            }
            // Decrease the best character from the Needed Characters Map
            neededChars.compute(bestChar, (key, value) -> value - 1);
            lastIndex = bestIndex;
        }
        return sb.toString();
    }

    /**
     * Create the Left Characters Map from the String
     *
     * @param s
     */
    private static void createLeftChars(String s) {
        leftChars = new HashMap();
        char currentChar;
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            leftChars.putIfAbsent(currentChar, 0);
            leftChars.compute(currentChar, (key, value) -> value + 1);
        }
    }

    /**
     * Create the Needed Characters Map from the Left Characters Map
     */
    private static void createNeededChars() {
        neededChars = new HashMap();
        for (Map.Entry<Character, Integer> e : leftChars.entrySet()) {
            neededChars.put(e.getKey(), e.getValue() / 2);
        }
    }

    /**
     * Create Skip Characters Map
     *
     * @param currentChar
     */
    private static void skipChar(char currentChar) {
        skippedChars.putIfAbsent(currentChar, 0);
        skippedChars.compute(currentChar, (key, value) -> value + 1);
    }

    /**
     * Tells the characters can be skipped or not
     *
     * @param currentChar
     * @return
     */
    private static boolean canBeSkipped(char currentChar) {
        return (leftChars.get(currentChar) - skippedChars.getOrDefault(currentChar, 0) - neededChars.get(currentChar)) >= 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = reverseShuffleMerge(s);
        System.out.println(result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
