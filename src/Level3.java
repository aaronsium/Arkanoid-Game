import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 3.
 */
public class Level3 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        ArrayList<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < numberOfBalls() * 10; i = i + 10) {
            Velocity speed = Velocity.fromAngleAndSpeed(20 + i, 5);
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
        return 130;

    }

    @Override
    public String levelName() {
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        BackGround3 background = new BackGround3();
        return background;

    }

    @Override
    public List<Block> blocks() {
        ArrayList<Block> blocks = new ArrayList<Block>();
        int counter = 0;
        for (int i = 0; i < 6; i++) {
            Block block = new Block(new Point(735 - counter, 200), 50, 20, Color.BLUE);
            block.setText("1");
            blocks.add(block);
            counter = counter + 51;
        }
        counter = 0;
        for (int i = 0; i < 6; i++) {

            Block block = new Block(new Point(735 - counter, 180), 50, 20, Color.RED);
            block.setText("1");
            blocks.add(block);
            counter = counter + 51;
        }
        counter = 0;
        for (int i = 0; i < 8; i++) {
            Block block = new Block(new Point(735 - counter, 160), 50, 20, Color.GREEN);
            block.setText("1");
            blocks.add(block);
            counter = counter + 51;
        }
        counter = 0;
        for (int i = 0; i < 9; i++) {
            Block block = new Block(new Point(735 - counter, 140), 50, 20, Color.YELLOW);
            block.setText("1");
            counter = counter + 51;
            blocks.add(block);
        }
        counter = 0;
        for (int i = 0; i < 10; i++) {
            Block block = new Block(new Point(735 - counter, 120), 50, 20, Color.ORANGE);
            block.setText("2");
            counter = counter + 51;
            blocks.add(block);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;

    }


}