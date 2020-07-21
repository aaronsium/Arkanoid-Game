import biuoop.DrawSurface;
import biuoop.KeyboardSensor;


/**
 * The type Key press stoppable animation.
 */
public class KeyPressStoppableAnimation implements Animation {

    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;
    private boolean firstTime;


    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param sensor    the sensor
     * @param key       the key
     * @param animation the animation
     */

    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.sensor = sensor;
        this.key = key;
        this.isAlreadyPressed = false;
    }

    @Override
    public boolean shouldStop() {

        if (sensor.isPressed(key)) {
            isAlreadyPressed = true;
        }

        return isAlreadyPressed;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
    }

}

