import java.util.List;

/**
 * The interface Level information.
 */
public interface LevelInformation {
    /**
     * Number of balls .
     *
     * @return the int
     */
    int numberOfBalls();

    /**
     * Initial ball velocities.
     * The initial velocity of each ball
     *
     * @return the list
     */
    List<Velocity> initialBallVelocities();

    /**
     * Paddle speed .
     *
     * @return the speed
     */
    int paddleSpeed();

    /**
     * Paddle width.
     *
     * @return the
     */
    int paddleWidth();

    /**
     * Level name string.
     * the level name will be displayed at the top of the screen.
     *
     * @return the string
     */

    String levelName();

    /**
     * Gets background.
     * Returns a sprite with the background of the level
     *
     * @return the background
     */
    Sprite getBackground();

    /**
     * Blocks list.
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return the list
     */
    List<Block> blocks();

    /**
     * Number of blocks to remove int.
     * Number of levels that should be removed
     * before the level is considered to be "cleared".
     *
     * @return the int
     */
    int numberOfBlocksToRemove();
}