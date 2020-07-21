import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Back ground 3.
 */
public class BackGround3 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(0x38993C));
        d.fillRectangle(0, 0, 800, 800);
        d.setColor(Color.BLACK);
        d.fillRectangle(40, 590, 140, 210);
        d.setColor(Color.WHITE);
        // line 1
        d.fillRectangle(50, 600, 20, 30);
        d.fillRectangle(85, 600, 20, 30);
        d.fillRectangle(120, 600, 20, 30);
        d.fillRectangle(155, 600, 20, 30);
        //line 2
        d.fillRectangle(50, 640, 20, 30);
        d.fillRectangle(85, 640, 20, 30);
        d.fillRectangle(120, 640, 20, 30);
        d.fillRectangle(155, 640, 20, 30);
        //line 3
        d.fillRectangle(50, 680, 20, 30);
        d.fillRectangle(85, 680, 20, 30);
        d.fillRectangle(120, 680, 20, 30);
        d.fillRectangle(155, 680, 20, 30);
        //line 4
        d.fillRectangle(50, 720, 20, 30);
        d.fillRectangle(85, 720, 20, 30);
        d.fillRectangle(120, 720, 20, 30);
        d.fillRectangle(155, 720, 20, 30);
        //line 5
        d.fillRectangle(50, 760, 20, 30);
        d.fillRectangle(85, 760, 20, 30);
        d.fillRectangle(120, 760, 20, 30);
        d.fillRectangle(155, 760, 20, 30);
        d.setColor(Color.BLACK);
        d.fillRectangle(103, 280, 15, 250);
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(90, 510, 40, 80);
        d.setColor(Color.yellow);
        d.fillCircle(110, 275, 15);
        d.setColor(Color.RED);
        d.fillCircle(110, 275, 10);
        d.setColor(Color.WHITE);
        d.fillCircle(110, 275, 5);

    }

    @Override
    public void timePassed() {

    }
}
