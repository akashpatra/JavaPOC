package javaex.interfaces.java8;

/**
 * @author Akash Patra
 */
public interface CustomerInterface {
    void method1();

    default void method2() {
        System.out.println("default method");
    }

    static void method3() {
        System.out.println("static method");
    }
}
