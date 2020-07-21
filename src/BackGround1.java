import biuoop.DrawSurface;
import java.awt.Color;
/**
 * The type Background 1.
 */
public class BackGround1 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        //creat the background and draw it
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, 800, 800);
        d.setColor(Color.BLUE);
        d.drawLine(400, 60, 400, 320);
        d.drawLine(260, 180, 540, 180);
        d.drawCircle(400, 180, 60);
        d.drawCircle(400, 180, 90);
        d.drawCircle(400, 180, 120);
    }
    @Override
    public void timePassed() {

    }
}
