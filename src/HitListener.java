/**
 * The interface listener.
 * it's object will lisening to other object and execute action depends on the specific
 * implements of hitEvent in the item
 */
public interface HitListener {
    /**
     * Hit event.
     * method which execute action depends on the specific
     * implements
     *
     * @param beingHit the being hit
     * @param hitter   the hitter
     */
    void hitEvent(Block beingHit, Ball hitter);
}
