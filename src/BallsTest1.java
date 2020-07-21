import java.util.ArrayList;
import java.util.List;

import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;
/**
 * The type Balls test 1.
 */
public class BallsTest1 {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        List<HitListener> listeners = new ArrayList<HitListener>();
        GUI gui = new GUI("title", 800, 800);
        Sleeper sleeper = new Sleeper();
        Point bpoint = new Point(300, 200);
        Block block = new Block(bpoint, 100, 100, java.awt.Color.BLACK);
        ArrayList<Collidable> interList = new ArrayList<Collidable>();
        interList.add(block);
        GameEnvironment e = new GameEnvironment(interList);

        Ball ball = new Ball(50, 50, 30, java.awt.Color.BLACK);
        ball.setVelocity(0.5, 0.5);
        ball.setGameEnvironment(e);
        while (true) {
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            block.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}