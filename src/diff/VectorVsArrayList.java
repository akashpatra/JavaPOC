package diff;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * Vector Vs ArrayList
 *
 * @author Akash Patra
 */
public class VectorVsArrayList {
    public static void main(String[] args) {

        // **** Vector **** //
        Vector<String> v = new Vector<>();

        // Using Enumerator
        Enumeration vEnumeration = v.elements();
        if (vEnumeration.hasMoreElements()) {
            System.out.println(vEnumeration.nextElement());
        }

        // Using Iterator
        Iterator<String> vIterator = v.iterator();
        if (vIterator.hasNext()) {
            System.out.println(vIterator.next());
        }

        // **** ArrayList **** //
        ArrayList<String> al = new ArrayList<>();

        // Using Iterator
        Iterator<String> alIterator = al.iterator();
        if (alIterator.hasNext()) {
            System.out.println(alIterator.next());
        }
    }
}
