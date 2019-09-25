package corejava.objectorientation.multipleinheritance.interfaces;

/**
 * @author Akash Patra
 */
public class InterfaceImpl implements InterfaceA, InterfaceB, InterfaceAB {

    @Override
    public void doSomething() {
        System.out.println("doSomething() implementation of InterfaceImpl");
    }
}
