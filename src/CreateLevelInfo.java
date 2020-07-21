import java.util.List;

/**
 * The type Create level info.
 */
public class CreateLevelInfo implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> initialBallVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private List<Block> blocks;
    private Sprite getBackground;
    private int rowHeight;
    private int numberOfBlocksToPass;
    private int numberOfBlocksToRemove;
    private int xStart;
    private int yStart;


    /**
     * Instantiates a new Create level info.
     */
    public CreateLevelInfo() {
        this.numberOfBalls = -1;
        this.initialBallVelocities = null;
        this.paddleSpeed = -1;
        this.paddleWidth = -1;
        this.levelName = null;
        this.blocks = null;
        this.getBackground = null;
        this.numberOfBlocksToRemove = -1;
        this.numberOfBlocksToPass = -1;
        this.xStart = -1;
        this.yStart = -1;
        this.rowHeight = -1;
    }

    /**
     * Sets row height.
     *
     * @param rowHeight1 the row height 1
     */
    public void setRowHeight(int rowHeight1) {
        this.rowHeight = rowHeight1;
    }

    /**
     * Sets number of blocks to pass.
     *
     * @param numberOfBlocksToPass1 the number of blocks to pass 1
     */
    public void setNumberOfBlocksToPass(int numberOfBlocksToPass1) {
        this.numberOfBlocksToPass = numberOfBlocksToPass1;
    }

    /**
     * Sets start.
     *
     * @param xStart1 the x start 1
     */
    public void setxStart(int xStart1) {
        this.xStart = xStart1;
    }

    /**
     * Sets start.
     *
     * @param yStart1 the y start 1
     */
    public void setyStart(int yStart1) {
        this.yStart = yStart1;
    }

    /**
     * Sets number of balls.
     *
     * @param numberOfBalls1 the number of balls 1
     */
    public void setNumberOfBalls(int numberOfBalls1) {
        this.numberOfBalls = numberOfBalls1;
    }

    /**
     * Sets initial ball velocities.
     *
     * @param initialBallVelocities1 the initial ball velocities 1
     */
    public void setInitialBallVelocities(List<Velocity> initialBallVelocities1) {
        this.initialBallVelocities = initialBallVelocities1;
    }

    /**
     * Sets paddle speed.
     *
     * @param paddleSpeed1 the paddle speed 1
     */
    public void setPaddleSpeed(int paddleSpeed1) {
        this.paddleSpeed = paddleSpeed1;
    }

    /**
     * Sets paddle width.
     *
     * @param paddleWidth1 the paddle width 1
     */
    public void setPaddleWidth(int paddleWidth1) {
        this.paddleWidth = paddleWidth1;
    }

    /**
     * Sets level name.
     *
     * @param levelName1 the level name 1
     */
    public void setLevelName(String levelName1) {
        this.levelName = levelName1;
    }

    /**
     * Sets blocks.
     *
     * @param blocks1 the blocks 1
     */
    public void setBlocks(List<Block> blocks1) {
        this.blocks = blocks1;
    }

    /**
     * Sets get background.
     *
     * @param getBackground1 the get background 1
     */
    public void setGetBackground(Sprite getBackground1) {
        this.getBackground = getBackground1;
    }

    /**
     * Sets number of blocks to remove.
     *
     * @param numberOfBlocksToRemove1 the number of blocks to remove 1
     */
    public void setNumberOfBlocksToRemove(int numberOfBlocksToRemove1) {
        this.numberOfBlocksToRemove = numberOfBlocksToRemove1;
    }

    @Override
    public int numberOfBalls() {
        return 0;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return null;
    }

    @Override
    public int paddleSpeed() {
        return 0;
    }

    @Override
    public int paddleWidth() {
        return 0;
    }

    @Override
    public String levelName() {
        return null;
    }

    @Override
    public Sprite getBackground() {
        return null;
    }

    @Override
    public List<Block> blocks() {
        return null;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 0;
    }
}
