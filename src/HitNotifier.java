/**
 * The interface Hit notifier.
 * it's object will lisening to other object and execute action depends on the specific
 * implements of hitEvent in the item
 */
public interface HitNotifier {
    /**
     * Add hit listener.
     *
     * @param hl the hl
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hit listener.
     *
     * @param hl the hl
     */
    void removeHitListener(HitListener hl);
}
