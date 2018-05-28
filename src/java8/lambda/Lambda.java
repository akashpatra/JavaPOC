package java8.lambda;

/**
 * @author Akash Patra
 */
public class Lambda {
    public static void main(String[] args) {
        sayHello();

        executeAdd();
    }

    private static void sayHello() {
        IShow iShow = name -> "Hello, " + name;
        System.out.println(iShow.show("akash"));
    }

    private static void executeAdd() {
        IAdd iAdd = (int a, int b) -> (a + b);
        System.out.println(iAdd.add(2, 4));
    }
}
