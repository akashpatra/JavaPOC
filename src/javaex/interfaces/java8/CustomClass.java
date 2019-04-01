package javaex.interfaces.java8;

/**
 * @author Akash Patra
 */
public class CustomClass implements CustomerInterface {

    @Override
    public void method1() {
        System.out.println("abstract method");
    }

    public static void main(String[] args) {
        CustomerInterface instance = new CustomClass();
        instance.method1();
        instance.method2();
        CustomerInterface.method3();
    }
}
