import java.util.HashMap;

/**
 * @author Akash Patra
 */
public class MapEx {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        MyKey key = new MyKey("shreyansh");
        map.put(key, "value");

        key.setKeyName("asksh");

        System.out.println(map.get(new MyKey("shreyansh")));
    }
}
