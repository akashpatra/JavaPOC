package hackerrank.datastructures.stack;

import java.util.Scanner;

/**
 * @author Akash Patra
 */
public class StackImpl {

    final int MAX = 100000;
    private int top;
    private long a[] = new long[MAX];

    StackImpl() {
        top = -1;
    }

    public boolean push(int data) {
        if (top >= MAX) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            a[++top] = data;
            return true;
        }
    }

    public long pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return a[top--];
        }
    }

    public void findMax() {
        long max = 0;
        for (int i = 0; i <= top; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println("MAX: " + max);
    }

    public static void main(String[] args) {
        StackImpl stack = new StackImpl();

        Scanner scanner = new Scanner(System.in);
        int entries = scanner.nextInt();

        int type, data;
        for (int i = 0; i < entries; i++) {
            type = scanner.nextInt();

            switch (type) {
                case 1:
                    data = scanner.nextInt();
                    stack.push(data);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.findMax();
                    break;
            }
        }
    }
}
