package hackerrank.datastructures.stack;

import java.util.Scanner;

/**
 * @author Akash Patra
 */
public class BalancedParenthesis {

    final int MAX = 1000;
    private int top;
    private char a[] = new char[MAX];

    BalancedParenthesis() {
        top = -1;
    }

    public boolean push(char data) {
        if (top >= MAX) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            a[++top] = data;
            return true;
        }
    }

    public char pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return a[top--];
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    static boolean isPair(char open, char close) {
        if (open == '(' && close == ')') {
            return true;
        } else if (open == '{' && close == '}') {
            return true;
        } else if (open == '[' && close == ']') {
            return true;
        } else {
            return false;
        }
    }

    static boolean isBalancedParanthesis(String data) {
        BalancedParenthesis balanPar = new BalancedParenthesis();

        char[] charArr = data.toCharArray();
        for (int i = 0; i < charArr.length; i++) {

            // For Pushing Data
            if (charArr[i] == '(' || charArr[i] == '{' || charArr[i] == '[') {
                balanPar.push(charArr[i]);
            }

            if (charArr[i] == ')' || charArr[i] == '}' || charArr[i] == ']') {
                if (balanPar.isEmpty()) {
                    return false;
                } else if (!isPair(balanPar.pop(), charArr[i])) {
                    return false;
                }
            }
        }

        if (balanPar.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int entries = scanner.nextInt();
        String data;
        for (int i = 0; i < entries; i++) {
            data = scanner.next();

            if (isBalancedParanthesis(data)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
