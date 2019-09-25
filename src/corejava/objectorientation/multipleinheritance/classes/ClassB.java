package corejava.objectorientation.multipleinheritance.classes;

/**
 * @author Akash Patra
 */
public class ClassB extends SuperClass {

    @Override
    public void doSomething() {
        System.out.println("doSomething() implementation of B");
    }

    public void methodB() {
        System.out.println("methodB() implementation of B");
    }
}
