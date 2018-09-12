package poc;

/**
 * @author Akash Patra
 */
public class Anagram {

    static int sherlockAndAnagrams(String s) {
        int sLength = s.length();
        String s1, s2;
        int s1EIndex, s2EIndex;
        boolean status;
        int counter = 0;

        for (int subLength = 1; subLength < sLength; subLength++) {
            for (int i = 0; i < sLength; i++) {
                for (int j = i + 1; j < sLength; j++) {
                    s1EIndex = i + subLength;
                    s2EIndex = j + subLength;
                    if (s1EIndex <= sLength && s2EIndex <= sLength) {
                        s1 = s.substring(i, s1EIndex);
                        s2 = s.substring(j, s2EIndex);
                        status = isAnagram(s1, s2);
                        if (status) {
                            ++counter;
                        }
                        System.out.println("S1: " + s1 + ", S2: " + s2 + " >> Status: " + status);
                    }
                }
            }
        }

        return counter;
    }

    /*static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        } else {
            char[] s1Arr = s1.toCharArray();
            int s1Sum = 0;
            for (int i = 0; i < s1Arr.length; i++) {
                s1Sum += s1Arr[i];
            }
            char[] s2Arr = s2.toCharArray();
            int s2Sum = 0;
            for (int i = 0; i < s2Arr.length; i++) {
                s2Sum += s2Arr[i];
            }

            if (s1Sum == s2Sum) {
                return true;
            }

            return false;
        }
    }*/

    static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        } else {
            int count[] = new int[26];
            char[] s1Arr = s1.toCharArray();
            for (int i = 0; i < s1Arr.length; i++) {
                count[s1Arr[i] - 97]++;
            }
            char[] s2Arr = s2.toCharArray();
            for (int i = 0; i < s2Arr.length; i++) {
                count[s2Arr[i] - 97]--;
            }

            for (int k = 0; k < count.length; k++) {
                if (count[k] != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "kkkk";
        System.out.println(sherlockAndAnagrams(s));
    }
}
