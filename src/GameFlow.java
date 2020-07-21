import biuoop.DialogManager;
import biuoop.KeyboardSensor;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * The type Game flow.
 */
public class GameFlow {
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private Counter score;
    private Counter lives;
    private DialogManager dialogManager;
    private ScoreInfo scoreInfo;

    /**
     * Instantiates a new Game flow.
     *
     * @param ar             the AnimationRunner
     * @param ks             the KeyboardSensor
     * @param dialogManager1 the DialogManager
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, DialogManager dialogManager1) {
        keyboardSensor = ks;
        animationRunner = ar;
        score = new Counter();
        lives = new Counter();
        lives.setNumber(7);
        scoreInfo = new ScoreInfo("israel", 0);
        dialogManager = dialogManager1;

    }

    /**
     * Run levels.
     * this class in charge of  moving from one level to the next by running them
     *
     * @param levels the levels
     *               throws ClassNotFoundException
     */
    public void runLevels(List<LevelInformation> levels) {
        // this counters will moving from the first level till the last
        Counter scoreindicator = new Counter();
        Counter livesRemained = lives;
        //running the levels from the list
        File newFile = new File("highscores");
        HighScoresTable table = new HighScoresTable(5);

        try {
            if (newFile.isFile()) {
                table.load(newFile);
            } else {
                table.save(newFile);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(animationRunner, keyboardSensor, levelInfo, scoreindicator, livesRemained);
            level.initialize();
            // the loop will stopped when there are lives and blocks to remove
            while (level.getLives().getNumber() > 0 && level.getCounterBlocks().getNumber() > 0) {
                level.playOneTurn();
                if (level.getCounterBlocks().getNumber() != 0) {
                    lives.decrease(1);
                }
            }
            if (level.getLives().getNumber() == 0) {
                break;
            }
            //update the score and the lives from one level to the next
            scoreindicator.setNumber(level.getScore().getNumber());
            livesRemained.setNumber(level.getLives().getNumber());
            this.score = level.getScore();
            this.lives = level.getLives();

        }
        if (table.getRank(this.score.getNumber()) <= table.size()) {
            String name = this.dialogManager.showQuestionDialog("Name", "What is your name?", "Israel Israeli");
            this.scoreInfo.setName(name);
            this.scoreInfo.setScore(this.score.getNumber());
            table.add(this.scoreInfo);
            try {
                table.save(newFile);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (lives.getNumber() == 0) {
            animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY,
                    new LoseScreen(score.getNumber())));
        } else {
            animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY,
                    new WinScreen(score.getNumber())));
        }
        animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY,
                new HighScoresAnimation(table)));


    }
}