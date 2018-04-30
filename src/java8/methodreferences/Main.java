package java8.methodreferences;

/**
 * @author Akash Patra
 */
public class Main implements IExa {

    public static void main(String[] args) {
        System.out.println(IExa.fasd("sachin"));
        new Main().data();
    }

    @Override
    public void data() {
        default1();
    }
}
