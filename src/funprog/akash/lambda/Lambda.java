package funprog.akash.lambda;

/**
 * @author Akash Patra
 */
public class Lambda {
    public int x = 0;

    public static void main(String[] args) {
        staticSayHello();
        new Lambda().sayHello();

        executeAdd();
    }

    private static void staticSayHello() {
        IShow iShow = name -> "Hello, " + name;
        System.out.println(iShow.show("akash"));
    }

    private static void executeAdd() {
        IAdd iAdd = (int a, int b) -> (a + b);
        System.out.println(iAdd.add(2, 4));
//        String.valueOf()
    }

    private void sayHello() {
        String name;
        // Scoping
        IShow iShow = new IShow() {
            @Override
            public String show(String name) {
                return "Hello, " + name + x;
            }
        };
    }
}
