package funprog.java.normal;

/**
 * Example Taken from Java 8 Optional.
 * <p>
 * <a href>https://www.oracle.com/technetwork/articles/java/java8-optional-2175753.html</a>
 *
 * @author Akash Patra
 */
public class Example {

    public static void main(String[] args) {
        Computer computer = new Computer();

        // Easy way to get Version
//        System.out.println(computer.getSoundcard().getUsb().getVersion());

        // To avoid null pointer exception, need to add so many boiler plate code
        String version = "UNKNOWN";
        if (computer != null) {
            Soundcard soundcard = computer.getSoundcard();
            if (soundcard != null) {
                USB usb = soundcard.getUSB();
                if (usb != null) {
                    version = usb.getVersion();
                }
            }
        }
        System.out.println(version);

        //

    }
}
