import biuoop.DrawSurface;

/**
 * The interface Animation.
 */
public interface Animation {
    /**
     * Do one frame.
     *
     * @param d the board which we used for drawing
     */
    void doOneFrame(DrawSurface d);
    /**
     * tell us when to stop.
     *
     * @return the boolean
     */
    boolean shouldStop();
}
