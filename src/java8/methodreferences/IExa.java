package java8.methodreferences;

/**
 * @author Akash Patra
 */
public interface IExa {
    static String fasd(String body) {
        return "Hi " + body;
    }

    void data();

    default void default1 () {
        System.out.println("Default Body");
    }
}
