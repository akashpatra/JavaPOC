package corejava.objectorientation.overriding;

/**
 * @author Akash Patra
 */
public class Parent {

    static void m1() {
        System.out.println("From parent static m1()");
    }

    void m2() {
        System.out.println("From parent "
                + "non-static(instance) m2()");
    }
}
