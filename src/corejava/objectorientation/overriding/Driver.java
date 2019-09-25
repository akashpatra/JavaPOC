package corejava.objectorientation.overriding;

/**
 * Checking Overriding Rules for normal and static methods.
 * <p>
 * LINK: https://www.geeksforgeeks.org/overriding-in-java/
 *
 * @author Akash Patra
 */
public class Driver {

    public static void main(String[] args) {
        Parent obj1 = new Child();

        // As per overriding rules this
        // should call to class Child static
        // overridden method. Since static
        // method can not be overridden, it
        // calls Parent's m1()
        obj1.m1();

        // Here overriding works
        // and Child's m2() is called
        obj1.m2();
    }
}
