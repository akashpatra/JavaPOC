package ds.array;

/**
 * @author Akash Patra
 */
public class SmallestInteger {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};

        System.out.println(solution(a));
    }

    private static int solution(int[] a) {
        int smallest = 1;
        boolean elementFound = false;

        while (true) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == smallest) {
                    elementFound = true;
                    System.out.println("Found: " + a[i]);
                    break;
                }
            }

            if (!elementFound) {
                break;
            }

            ++smallest;
            elementFound = false;
        }

        return smallest;
    }
}
