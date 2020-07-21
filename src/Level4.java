
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 4.
 */
public class Level4 implements LevelInformation {
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
        return 130;

    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        BackGround4 background = new BackGround4();
        return background;

    }

    @Override
    public List<Block> blocks() {
        ArrayList<Block> blocks = new ArrayList<Block>();
        for (int i = 0; i < 765; i = i + 51) {
            Block block1 = new Block(new Point(18 + i, 200), 50, 30, Color.GRAY);
            blocks.add(block1);
        }
        for (int i = 0; i < 765; i = i + 51) {
            Block block1 = new Block(new Point(18 + i, 230), 50, 30, Color.RED);
            blocks.add(block1);
        }
        for (int i = 0; i < 765; i = i + 51) {
            Block block1 = new Block(new Point(18 + i, 260), 50, 30, Color.YELLOW);
            blocks.add(block1);
        }
        for (int i = 0; i < 765; i = i + 51) {
            Block block1 = new Block(new Point(18 + i, 290), 50, 30, Color.GREEN);
            blocks.add(block1);
        }
        for (int i = 0; i < 765; i = i + 51) {
            Block block1 = new Block(new Point(18 + i, 320), 50, 30, Color.WHITE);
            blocks.add(block1);
        }
        for (int i = 0; i < 765; i = i + 51) {
            Block block1 = new Block(new Point(18 + i, 350), 50, 30, Color.PINK);
            blocks.add(block1);
        }
        for (int i = 0; i < 765; i = i + 51) {
            Block block1 = new Block(new Point(18 + i, 380), 50, 30, new Color(193, 210, 190));
            blocks.add(block1);
        }
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


//
//
//
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Level4 implements LevelInformation {
//    public int numberOfBalls(){
//        return 3;
//    }
//    // The initial velocity of each ball
//    // Note that initialBallVelocities().size() == numberOfBalls()
//    public List<Velocity> initialBallVelocities() {
//        ArrayList<Velocity> velocities = new ArrayList<>();
//        for(int i = 0; i < numberOfBalls() * 45; i = i + 45) {
//            Velocity speed = Velocity.fromAngleAndSpeed(-45 + i, 5);
//            velocities.add(speed);
//        }
//        return velocities;
//    }
//    public int paddleSpeed (){
//        return 5;
//
//    }
//    public  int paddleWidth (){
//        return 200;
//
//    }
//    // the level name will be displayed at the top of the screen.
//    public String levelName(){
//        return  "Green 3";
//    }
//    // Returns a sprite with the background of the level
//    public Sprite getBackground(){
//        BackGround3   background = new BackGround3();
//        return background;
//
//    }
//    // The Blocks that make up this level, each block contains
//    // its size, color and location.
//    public List<Block> blocks(){
//        ArrayList<Block> blocks = new ArrayList<>();
//        Block block1 = new Block(new Point(30, 320), 30, 30, Color.RED);
//        Block block2 = new Block(new Point(30, 320), 30, 30, Color.RED);
//        Block block3 = new Block(new Point(30, 320), 30, 30, Color.ORANGE);
//        Block block4 = new Block(new Point(30, 320), 30, 30, Color.ORANGE);
//        Block block5 = new Block(new Point(30, 320), 30, 30, Color.YELLOW);
//        Block block6 = new Block(new Point(30, 320), 30, 30, Color.YELLOW);
//        Block block7 = new Block(new Point(30, 320), 30, 30, Color.GREEN);
//        Block block8 = new Block(new Point(30, 320), 30, 30, Color.GREEN);
//        Block block9 = new Block(new Point(30, 320), 30, 30, Color.GREEN);
//        Block block10 = new Block(new Point(30, 320), 30, 30, Color.BLUE);
//        Block block11 = new Block(new Point(30, 320), 30, 30, Color.BLUE);
//        Block block12 = new Block(new Point(30, 320), 30, 30, Color.PINK);
//        Block block13 = new Block(new Point(30, 320), 30, 30, Color.PINK);
//        Block block14 = new Block(new Point(30, 320), 30, 30, Color.GRAY);
//        Block block15 = new Block(new Point(30, 320), 30, 30, Color.GRAY);
//
//        blocks.add(block1);
//        blocks.add(block2);
//        blocks.add(block3);
//        blocks.add(block4);
//        blocks.add(block5);
//        blocks.add(block6);
//        blocks.add(block7);
//        blocks.add(block8);
//        blocks.add(block9);
//        blocks.add(block10);
//        blocks.add(block11);
//        blocks.add(block12);
//        blocks.add(block13);
//        blocks.add(block14);
//        blocks.add(block15);
//        for (Block temp : blocks) {
//            temp.setText("x");
//        }
//        return blocks;
//    }
//    // Number of levels that should be removed
//    // before the level is considered to be "cleared".
//    // This number should be <= blocks.size();
//    public int numberOfBlocksToRemove(){
//        return 15;
//
//    }
//
//
//
//}
