package poc;

/**
 * Adds Separator uniformly in the data.
 *
 * @author Akash Patra
 */
public class Separator {

    public static void main(String[] args) {
        // 16 Char Test Data
        String data16 = "aaaabbbbccccdddd";

        // 12 Char Test Data
        String data12 = "aaaabbbbcccc";

        // 9 Char Test Data
        String data9 = "aaaabbbbc";

        System.out.println(new Separator().addSeparator(data16));
    }

    /**
     * Adds Separator uniformly in the data.
     *
     * @param data
     * @return
     */
    private String addSeparator(String data) {
        // Constants
        int BREAK_LENGTH = 3;
        String SEPARATOR = "-";

        StringBuilder result = new StringBuilder();
        int endIndex;

        for (int i = 0; i < data.length(); i = i + BREAK_LENGTH) {
            System.out.println("i: " + i);

            // To stop the delimiter to get added in last.
            if (i != 0 && i % BREAK_LENGTH == 0) {
                result.append(SEPARATOR);
            }

            endIndex = i + BREAK_LENGTH;

            // To avoid Array Index of Bound Exception
            if (endIndex > data.length()) {
                result.append(data.substring(i, data.length()));
            } else {
                result.append(data.substring(i, endIndex));
            }

        }
        return result.toString();
    }
}
