import java.awt.Color;
import java.util.ArrayList;

import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type GameLevel.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Paddle paddle;
    private Counter counterBlocks;
    private Counter counterBalls;
    private Counter score;
    private Counter lives;
    private boolean running;
    private AnimationRunner runner;
    private KeyboardSensor keyboard;
    private LevelInformation info;


    /**
     * Gets counter g.
     *
     * @return the counter g
     */
    public Counter getCounterG() {
        return counterBlocks;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public Counter getScore() {
        return score;
    }

    /**
     * Gets counter balls.
     *
     * @return the counter balls
     */
    public Counter getCounterBalls() {
        return counterBalls;
    }

    /**
     * Instantiates a new GameLevel.
     *
     * @param an     the AnimationRunner
     * @param key    KeyboardSensor
     * @param info1  LevelInformation
     * @param score1 the Counter of score
     * @param live1  the counter of lives
     */
    public GameLevel(AnimationRunner an, KeyboardSensor key, LevelInformation info1, Counter score1, Counter live1) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        counterBlocks = new Counter();
        counterBalls = new Counter();
        score = new Counter();
        lives = new Counter();
        running = true;
        runner = an;
        info = info1;
        keyboard = key;
        score.setNumber(score1.getNumber());
        lives = live1;
    }

    /**
     * Add collidable.
     *
     * @param c is the Collidable object
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * Add sprite object.
     *
     * @param s the Sprite object
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Gets lives.
     *
     * @return the lives
     */
    public Counter getLives() {
        return lives;
    }

    /**
     * Sets paddle.
     *
     * @param paddle1 the paddle 1
     */
    public void setPaddle(Paddle paddle1) {
        this.paddle = paddle1;
    }

    /**
     * Gets counter of blocks that remaining.
     *
     * @return the counter blocks
     */
    public Counter getCounterBlocks() {
        return counterBlocks;
    }

    /**
     * Initialize a new game: create the Blocks
     * and add them to the game.
     */
    public void initialize() {
        keyboard = runner.getGui().getKeyboardSensor();
        BlockRemover remover = new BlockRemover(this, counterBlocks);
        BallRemover ballremover = new BallRemover(this, counterBlocks);
        ScoreTrackingListener currentScore = new ScoreTrackingListener(score);
        ScoreIndicator indicator = new ScoreIndicator(score);
        LivesIndicator livesRemained = new LivesIndicator(lives);
        LevelName nameOfLevel = new LevelName(info.levelName());
        // creates the limits
        Block limitLeft = new Block(new Point(0, 0), 15, 800, Color.GRAY);
        limitLeft.setText("x");
        Block limitRight = new Block(new Point(785, 0), 15, 800, Color.GRAY);
        limitRight.setText("x");
        Block limitUp = new Block(new Point(16, 0), 768, 15, Color.GRAY);
        limitUp.setText("x");
        Block limitDown = new Block(new Point(16, 785), 768, 15, Color.GRAY);
        limitDown.setText("x");
        //adding the death zone
        limitDown.addHitListener(ballremover);
        ArrayList<Block> blacks = new ArrayList<Block>(info.blocks());
        this.sprites.addSprite(info.getBackground());
        // adding all blocks the listeners
        for (Block temp : blacks) {
            getCounterG().setNumber(counterBlocks.getNumber() + 1);
            temp.addHitListener(currentScore);
            temp.addHitListener(remover);
            temp.addToGame(this);
        }
        //create the paddle
        Point left = new Point(400 - this.info.paddleWidth() / 2, 760);
        Rectangle rect = new Rectangle(left, info.paddleWidth(), 10);
        Paddle paddle1 = new Paddle(rect, runner.getGui().getKeyboardSensor());
        setPaddle(paddle1);
        // adding all to the game
        this.sprites.addSprite(indicator);
        this.sprites.addSprite(livesRemained);
        this.sprites.addSprite(nameOfLevel);
        paddle.addToGame(this);
        limitUp.addToGame(this);
        limitDown.addToGame(this);
        limitRight.addToGame(this);
        limitLeft.addToGame(this);
    }

    /**
     * playOneTurn.
     * continue only if there are still ball and blocks
     * the method create ball/paddle if we are remove them
     * and sill have lives
     */
// Run the game -- start the animation loop.
    public void playOneTurn() {
        running = true;
        if (getCounterBalls().getNumber() == 0) {
            getCounterBalls().increase(info.numberOfBalls());
            for (int i = 0; i < info.numberOfBalls(); i++) {
                Ball ballx = new Ball(400, 750, 5, Color.WHITE);
                ballx.setVelocity(info.initialBallVelocities().get(i));
                ballx.setGameEnvironment(environment);
                ballx.addToGame(this);
            }
            removeCollidable(paddle);
            removeSprite(paddle);
            setPaddle(null);
        }
        if (this.paddle == null) {
            Point left = new Point(400 - this.info.paddleWidth() / 2, 760);
            Rectangle rect = new Rectangle(left, info.paddleWidth(), 10);
            Paddle paddle1 = new Paddle(rect, runner.getGui().getKeyboardSensor());
            setPaddle(paddle1);
            paddle.addToGame(this);
        }
        this.runner.run(new CountdownAnimation(2.0, 3, sprites));
        runner.run(this);
        if (score.getNumber() == 0) {
            lives.decrease(1);
        }
    }

    /**
     * Create paddle paddle.
     *
     * @return the paddle
     */
    public Paddle createPaddle() {
        Point rectPoint = new Point(400, 775);
        Point paddlePoint = new Point(50, 50);
        Rectangle rectangle = new Rectangle(paddlePoint, 50, 50);
        GUI guix = new GUI("title", 800, 800);
        return new Paddle(rectangle, guix.getKeyboardSensor());
    }

    /**
     * Remove collidable.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);

    }

    /**
     * Remove sprite.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (getCounterBalls().getNumber() <= 0 || getCounterG().getNumber() <= 0) {
            running = false;
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(keyboard, KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }
        sprites.notifyAllTimePassed();
        sprites.drawAllOn(d);


    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

}


