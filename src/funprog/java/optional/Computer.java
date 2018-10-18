package funprog.java.optional;

import java.util.Optional;

/**
 * @author Akash Patra
 */
public class Computer {

    private Optional<Soundcard> soundcard;

    public Optional<Soundcard> getSoundcard() {
        return soundcard;
    }

    public void setSoundcard(Optional<Soundcard> soundcard) {
        this.soundcard = soundcard;
    }
}
