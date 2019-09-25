package corejava.objectorientation.multipleinheritance.interfaces;

/**
 * Solving Diamond Problem using interfaces in Java
 * <p>
 * LINK: https://www.journaldev.com/1775/multiple-inheritance-in-java
 *
 * @author Akash Patra
 */
public class Driver {

    public static void main(String[] args) {
        InterfaceA objA = new InterfaceImpl();
        InterfaceB objB = new InterfaceImpl();
        InterfaceAB objAB = new InterfaceImpl();

        // All the method calls below are going to same concrete implementation
        objA.doSomething();
        objB.doSomething();
        objAB.doSomething();
    }

}
