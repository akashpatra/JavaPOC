package funprog.java.optional;

import java.util.Optional;

/**
 * @author Akash Patra
 */
public class Soundcard {
    private Optional<USB> usb;

    public Optional<USB> getUSB() {
        return usb;
    }

    public void setUSB(Optional<USB> usb) {
        this.usb = usb;
    }
}
