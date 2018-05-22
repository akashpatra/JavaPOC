package hackerrank.datastructures.stack;

import java.util.Stack;

/**
 * @author Akash Patra
 */
public class StackMax extends Stack<Integer> {
    Stack<Integer> max = new Stack<>();

    void push(int x) {
        if (isEmpty() == true) {
            super.push(x);
            max.push(x);
        } else {
            super.push(x);
            int y = max.peek();
//            max.push(y);
            if (x > y)
                max.push(x);
            else
                max.push(y);
        }
    }

    public Integer pop() {
        int x = super.pop();
        max.pop();
        return x;
    }


    int getMax() {
        int x = max.peek();
//        max.push(x);
        return x;
    }

    /* Driver program to test SpecialStack methods */
    public static void main(String[] args) {
        StackMax s = new StackMax();
        s.push(40);
        s.push(20);
        s.push(30);
        s.pop();
        System.out.println(s.getMax());
        s.push(45);
        System.out.println(s.getMax());
    }
}
