package geekforgeeks.string;

/**
 * Remove all characters of a Word from another Word and count how many such moves can be done.
 * 
 * @author Akash Patra
 */
public class RemoveWord4mWord {
    public static void main(String[] args) {
//        String s = "BAONXXOLL";
//        String s = "BAOOLLNNOLOLGBAX";
//        String s = "QAWABAWONL";
        String s = "ONLABLABLOON";
        System.out.println("Moves: " + solution(s));
    }

    public static int solution(String s) {
        String template = "BALLOON";

        int moves = 0;

        boolean[] flag;
        int noOfCharactersMatched = 0;
        StringBuilder newString;

        while (true) {
            flag = new boolean[s.length()];
            noOfCharactersMatched = 0;

            for (int i = 0; i < template.length(); i++) {
                for (int j = 0; j < s.length(); j++) {
                    if (!flag[j] && template.charAt(i) == s.charAt(j)) {
                        flag[j] = true;
                        ++noOfCharactersMatched;
                        System.out.println("Matched:: i: " + i + ",j: " + j);
                        break;
                    }
                }
            }

            if (noOfCharactersMatched == template.length()) {
                newString = new StringBuilder();
                for (int k = 0; k < flag.length; k++) {
                    if (!flag[k]) {
                        newString.append(s.charAt(k));
                    }
                }
                System.out.println("New String: " + newString);

                ++moves;
                s = newString.toString();
            } else {
                return moves;
            }

            if (s.length() < template.length()) {
                return moves;
            }
        }
    }
}
