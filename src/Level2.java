import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 2.
 */
public class Level2 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        ArrayList<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < numberOfBalls() * 12; i = i + 12) {
            Velocity speed = Velocity.fromAngleAndSpeed(-50 + i, 5);
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
        return 500;

    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        BackGround2 background = new BackGround2();
        return background;

    }

    @Override
    public List<Block> blocks() {
        ArrayList<Block> blocks = new ArrayList<Block>();
        Block block1 = new Block(new Point(15, 320), 50, 30, Color.RED);
        Block block2 = new Block(new Point(66, 320), 50, 30, Color.RED);
        Block block3 = new Block(new Point(117, 320), 50, 30, Color.ORANGE);
        Block block4 = new Block(new Point(168, 320), 50, 30, Color.ORANGE);
        Block block5 = new Block(new Point(219, 320), 50, 30, Color.YELLOW);
        Block block6 = new Block(new Point(270, 320), 50, 30, Color.YELLOW);
        Block block7 = new Block(new Point(321, 320), 50, 30, Color.GREEN);
        Block block8 = new Block(new Point(372, 320), 50, 30, Color.GREEN);
        Block block9 = new Block(new Point(423, 320), 50, 30, Color.GREEN);
        Block block10 = new Block(new Point(474, 320), 50, 30, Color.BLUE);
        Block block11 = new Block(new Point(525, 320), 50, 30, Color.BLUE);
        Block block12 = new Block(new Point(576, 320), 50, 30, Color.PINK);
        Block block13 = new Block(new Point(627, 320), 50, 30, Color.PINK);
        Block block14 = new Block(new Point(678, 320), 50, 30, Color.GRAY);
        Block block15 = new Block(new Point(729, 320), 50, 30, Color.GRAY);

        blocks.add(block1);
        blocks.add(block2);
        blocks.add(block3);
        blocks.add(block4);
        blocks.add(block5);
        blocks.add(block6);
        blocks.add(block7);
        blocks.add(block8);
        blocks.add(block9);
        blocks.add(block10);
        blocks.add(block11);
        blocks.add(block12);
        blocks.add(block13);
        blocks.add(block14);
        blocks.add(block15);
        for (Block temp : blocks) {
            temp.setText("x");
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;

    }


}
