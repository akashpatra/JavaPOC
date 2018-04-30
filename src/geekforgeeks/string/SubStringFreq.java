package geekforgeeks.string;

/**
 * @author Akash Patra
 */
public class SubStringFreq {

    public static void main(String[] args) {
        String name = "AABAACAADAABAABA";
        String sub = "AABA";

        System.out.println("No Of Occur: " + noOfOccurrences(name, sub));
    }

    private static int noOfOccurrences(String main, String sub) {
        int mainLength = main.length();
        int subLength = sub.length();

//        int index = 0;
        int noOfTimes = 0;
        for (int i = 0; i <= mainLength - subLength; i++) {
            System.out.println("i: " + i);

            for (int j = 0; j < subLength; j++) {
                if (main.charAt(i + j) != sub.charAt(j)) {
                    break;
                }
                if (j == subLength - 1) {
                    ++noOfTimes;
                    System.out.println("one more matched");
                }
            }

        }
        return noOfTimes;
    }
}
