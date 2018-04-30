package poc;

/**
 * @author Akash Patra
 */
public class ConstructorParentEx {

    public static ConstructorParentEx() {
        System.out.println("In Parent Constructor");
    }

    static {
        System.out.println("In Parent Static Block");
    }
}
