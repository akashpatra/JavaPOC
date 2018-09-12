package poc;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Iterator in Array List
 *
 * @author Akash Patra
 */
public class ArrayListIteratorEx {

    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        for (int i = 0; i < 10; i++) {
            a.add(i);
        }

        System.out.printf("BEFORE ITERATOR\n");
        int size = a.size();
        for (int i = 0; i < size; i++) {
            System.out.printf("I:%d\n", a.get(i));
//            if (i == 5) {
//                a.remove(i + 2);
//            }
        }

        System.out.printf("AFTER ITERATOR\n");
        Iterator i = a.iterator();
//        a.remove(5);

        int counter = 0;
        while (i.hasNext()) {
            System.out.printf("I:%d\n", i.next());
            ++counter;
            if (counter == 5) {
                i.remove();
                a.remove(counter);
            }
        }

        /*System.out.printf("AFTER DELETION\n");
        Iterator i1 = a.iterator();
        while (i1.hasNext()) {
            System.out.printf("I:%d\n", i1.next());
        }*/
    }
}
