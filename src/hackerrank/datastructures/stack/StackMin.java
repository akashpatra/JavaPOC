package hackerrank.datastructures.stack;

import java.util.Stack;

/**
 * @author Akash Patra
 */
public class StackMin extends Stack<Integer> {
    Stack<Integer> min = new Stack<>();

    /* SpecialStack's member method to insert an element to it. This method
    makes sure that the min stack is also updated with appropriate minimum
    values */
    void push(int x) {
        if (isEmpty() == true) {
            super.push(x);
            min.push(x);
        } else {
            super.push(x);
            int y = min.peek();
//            min.push(y);
            if (x < y)
                min.push(x);
            else
                min.push(y);
        }
    }

    /* SpecialStack's member method to insert an element to it. This method
    makes sure that the min stack is also updated with appropriate minimum
    values */
    public Integer pop() {
        int x = super.pop();
        min.pop();
        return x;
    }

    /* SpecialStack's member method to get minimum element from it. */
    int getMin() {
//        int x = min.pop();
//        min.push(x);
        return min.peek();
    }

    /* Driver program to test SpecialStack methods */
    public static void main(String[] args) {
        StackMin s = new StackMin();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.getMin());
        s.push(5);
        System.out.println(s.getMin());
    }
}
