package poc;

/**
 * @author Akash Patra
 */
public class ContructorEx extends ConstructorParentEx {

    public ContructorEx() {
        System.out.println("In Child Constructor");
    }

    static {
        System.out.println("In Child Static Block");
    }
}
