package funprog.java.optional;

import java.util.Optional;

/**
 * Example Taken from Java 8 Optional.
 * <p>
 * <a href>https://www.oracle.com/technetwork/articles/java/java8-optional-2175753.html</a>
 *
 * @author Akash Patra
 */
public class Example {

    public static void main(String[] args) {
        Optional<Computer> computer = Optional.of(new Computer());

//        Optional<USB> usb = Optional.empty();
//        usb.filter(usb -> "3.0".equals(usb.getVersion());

        String version = computer.flatMap(Computer::getSoundcard)
                .flatMap(Soundcard::getUSB)
                .map(USB::getVersion)
                .orElse("UNKNOWN");
    }
}
