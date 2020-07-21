/**
 * The type Show game task.
 */
public class ShowGameTask implements Task {
    private AnimationRunner runner;
    private Animation highScoresAnimation;

    /**
     * Instantiates a new Show game task.
     *
     * @param runner              the runner
     * @param highScoresAnimation the high scores animation
     */
    public ShowGameTask(AnimationRunner runner, Animation highScoresAnimation) {
        this.runner = runner;
        this.highScoresAnimation = highScoresAnimation;
    }
@Override
    public Void run() {
        this.runner.run(this.highScoresAnimation);
        return null;
    }
}
