/**
 * @author Akash Patra
 */
public class MyKey {
    String keyName;

    public MyKey(String keyName) {
        this.keyName = keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyName() {
        return keyName;
    }

    @Override
    public int hashCode() {
        return keyName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return ((MyKey) obj).getKeyName() == keyName;
    }
}
