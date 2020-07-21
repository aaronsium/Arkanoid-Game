import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 1.
 */
public class Level1 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        ArrayList<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            Velocity speed = Velocity.fromAngleAndSpeed(0, 10);
            velocities.add(speed);
        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;


    }

    @Override
    public int paddleWidth() {
        return 85;

    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        BackGround1 background1 = new BackGround1();
        return background1;

    }

    @Override
    public List<Block> blocks() {
        ArrayList<Block> blocks = new ArrayList<Block>();
        Block one = new Block(new Point(380, 155), 40, 40, Color.RED);
        one.setText("x");
        blocks.add(one);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;

    }
}
