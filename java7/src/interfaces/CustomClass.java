package interfaces;

/**
 * @author Akash Patra
 */
public class CustomClass implements CustomerInterface {

    @Override
    public void method() {
        System.out.println("Hello World >> State: " + state);
    }

    public static void main(String[] args) {
        CustomerInterface instance = new CustomClass();
        instance.method();
//        instance.method2();
    }
}
