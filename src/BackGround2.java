import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Back ground 2.
 */
public class BackGround2 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        int xline = 30;
        d.setColor(Color.ORANGE);
        while (xline < 800) {
            d.drawLine(200, 180, xline, 320);
            xline = xline + 40;
        }
        d.setColor(Color.LIGHT_GRAY);
        d.fillCircle(200, 180, 75);
        d.setColor(Color.ORANGE);
        d.fillCircle(200, 180, 70);
        d.setColor(Color.YELLOW);
        d.fillCircle(200, 180, 60);


    }

    @Override
    public void timePassed() {

    }
}
