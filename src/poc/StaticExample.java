package poc;

/**
 * @author Akash Patra
 */
public class StaticExample {
    private static int a;

    public static void main(String[] args) {
        StaticExample staticExample = new StaticExample();
        staticExample.a = 1000;

        System.out.println(staticExample.a);

        staticExample = null;

        System.out.println(staticExample.a);

        staticExample.a = 2000;

        System.out.println(staticExample.a);
    }
}
